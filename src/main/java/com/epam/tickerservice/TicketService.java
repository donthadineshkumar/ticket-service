package com.epam.tickerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    public Ticket findTicketById(Long ticketId){
        Optional<TicketEntity> ticketOptional = ticketRepository.findById(ticketId);
        Ticket ticket = new Ticket();
        if(ticketOptional.isPresent()){
            TicketEntity entity = ticketOptional.get();
            ticket.setTicketNo(entity.getTicketNo());
            ticket.setDescription(entity.getDescription());
            ticket.setStatus(entity.getStatus());
            ticket.setRequestedBy(entity.getRequestedBy());
            ticket.setRequestedDate(entity.getRequestedDate());
            List<Task> tasks = new ArrayList<>();
            for(TaskEntity taskEntity: entity.getTaskList()){
                Task task = new Task();
                task.setStatus(taskEntity.getTaskStatus());
                task.setTaskName(taskEntity.getTaskName());
                task.setTaskId(taskEntity.getTaskId());
                tasks.add(task);
            }
            ticket.setTaskList(tasks);
        }
        return ticket.getTicketNo()==null ? null : ticket;
    }

    public Ticket createTicket(Ticket ticket){
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setDescription(ticket.getDescription());
        ticketEntity.setRequestedBy(ticket.getRequestedBy());
        ticketEntity.setRequestedDate(ticket.getRequestedDate());
        ticketEntity.setStatus(ticket.getStatus());
        List<TaskEntity> taskEntityList = new ArrayList<>();
        for(Task task: ticket.getTaskList()){
            TaskEntity taskEntity = new TaskEntity();
            taskEntity.setTaskName(task.getTaskName());
            taskEntity.setTaskStatus(task.getStatus());
            taskEntity.setTicket(ticketEntity);
            taskEntityList.add(taskEntity);
        }
        ticketEntity.setTaskList(taskEntityList);
        TicketEntity ticketEntityWithId = ticketRepository.save(ticketEntity);
        ticket.setTicketNo(ticketEntityWithId.getTicketNo());
        return ticket;
    }

    public void deleteTicket(Long ticketNo){
        ticketRepository.deleteById(ticketNo);
    }
}
