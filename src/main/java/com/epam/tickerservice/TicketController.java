package com.epam.tickerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ticket-service")
public class TicketController {
    @Autowired
    TicketService ticketService;


    @Autowired
    MapProperties mapProperties;

    @Value("${test1*}")
    String greet;

    @Autowired
    MyConfigPojo pojo;

    @GetMapping("/queryparamlist")
    public Integer check(@RequestParam List<Integer> list){
        System.out.println(pojo.getMap());
        return Integer.sum(list.get(0),100);
    }

        @GetMapping("/read/{str}")
        public String check(@PathVariable String str){
            String modifiedStr = str.replaceAll("\\+", "");
            return modifiedStr;
        }


    @GetMapping(value = "/tickets/{ticket_id}")
    public ResponseEntity<?> searchTicket(@PathVariable("ticket_id") long ticketId){
        System.out.println(mapProperties.getComp());
        Ticket ticket = ticketService.findTicketById(ticketId);
        /*try{*/
            if(!ObjectUtils.isEmpty(ticket))
                return new ResponseEntity<>(ticket, HttpStatus.FOUND);
            else
                throw new TicketNotFoundException("Ticket Not Found");
        /*}catch (TicketNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket Not Found");
        }*/
    }

    @RequestMapping(value = "/tickets/create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket){
        Ticket savedTicket = ticketService.createTicket(ticket);
        return new ResponseEntity<>(savedTicket, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/tickets/{ticket_no}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTicket(@PathVariable("ticket_no") long ticketNo){
        ticketService.deleteTicket(ticketNo);
        return new ResponseEntity<>("Ticket Deleted Successfully", HttpStatus.OK);
    }
}
