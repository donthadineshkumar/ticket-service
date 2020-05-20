package com.epam.tickerservice;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;


public class TicketServiceTest {

    TicketController ticketController = new TicketController();

    @Mock
    Ticket ticket;

    @Mock
    TicketService ticketService;

    public TicketServiceTest() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(ticketController, "ticketService", ticketService);
    }

    @Test
    public void testCreateTicketSuccess(){
       doReturn(getTicket()).when(ticketService).createTicket(any(Ticket.class));
        ResponseEntity<Ticket> responseEntity = ticketController.createTicket(ticket);
        //responseEntity.getStatusCode()
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(Long.valueOf(1l), responseEntity.getBody().getTicketNo());
    }

    @Test
    public void testTicketSearch(){
        doReturn(getTicket()).when(ticketService).findTicketById(any(Long.class));
        ResponseEntity<?> responseEntity = ticketController.searchTicket(1l);
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        verify(ticketService).findTicketById(any(Long.class));
    }

    @Test(expected = TicketNotFoundException.class)
    public void testTicketSearchNotFound(){
        doReturn(null).when(ticketService).findTicketById(any(Long.class));
        ResponseEntity<?> responseEntity = ticketController.searchTicket(1l);
    }

    @Test
    public void testDeleteTicket(){
        doNothing().when(ticketService).deleteTicket(any(Long.class));
        ResponseEntity<?> responseEntity = ticketController.deleteTicket(1l);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(responseEntity.getBody(),"Ticket Deleted Successfully");
    }

    public Ticket getTicket(){
        Ticket ticket = new Ticket();
        ticket.setTicketNo(1l);
        ticket.setRequestedBy("Dinesh");
        ticket.setRequestedDate(new Date());
        ticket.setDescription("Install list of softwares");

        Task task1 = new Task();
        task1.setTaskId(1l);
        task1.setTaskName("Install windows os");
        task1.setStatus("Initiated");

        Task task2 = new Task();
        task2.setTaskId(2l);
        task2.setTaskName("Install Linux os");
        task2.setStatus("Initiated");

        ticket.setTaskList(Arrays.asList(task1, task2));
        return ticket;
    }
}
