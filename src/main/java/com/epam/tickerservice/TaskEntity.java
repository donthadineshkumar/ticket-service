package com.epam.tickerservice;

import javax.persistence.*;

@Entity
@Table(name = "TASK")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TASK_ID")
    private long taskId;
    @Column(name = "TASK_NAME")
    private String taskName;
    @Column(name = "TASK_STATUS")
    private String taskStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="TICKET_NO", nullable = false)
    private TicketEntity ticket;

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public TicketEntity getTicket() {
        return ticket;
    }

    public void setTicket(TicketEntity ticket) {
        this.ticket = ticket;
    }
}
