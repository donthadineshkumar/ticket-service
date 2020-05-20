package com.epam.tickerservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class Ticket {
    private Long ticketNo;
    private String description;
    private String requestedBy;
    private Date requestedDate;
    private String status;
    private List<Task> taskList;

    public Long getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(Long ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public static void main(String[] args) throws JsonProcessingException {
        Ticket ticket = new Ticket();
        ticket.setTicketNo(1l);
        ticket.setDescription("Installation of softwares");
        ticket.setRequestedBy("Dinesh");
        ticket.setRequestedDate(new Date());
        ticket.setStatus("Initiated");
        Task task1 = new Task();
        task1.setTaskId(1l);
        task1.setTaskName("Install OS- Linux-Ubuntu");
        task1.setStatus("Initiated");

        Task task2 = new Task();
        task2.setTaskId(2l);
        task2.setTaskName("Install Microsoft Office");
        task2.setStatus("Initiated");


        Task task3 = new Task();
        task3.setTaskId(3l);
        task3.setTaskName("Install Sublime text");
        task3.setStatus("Initiated");
        ticket.setTaskList(Arrays.asList(task1, task2, task3));
        System.out.println(new ObjectMapper().writeValueAsString(ticket));
    }
}
