package com.epam.tickerservice;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "TICKET")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TICKET_NO")
    private Long ticketNo;

    @Column(name = "TICKET_DESC")
    private String description;
    @Column(name = "REQUESTED_BY")
    private String requestedBy;
    @Column(name = "REQUESTED_DATE")
    private Date requestedDate;
    @Column(name = "STATUS")
    private String status;

    @OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<TaskEntity> taskList;

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

    public List<TaskEntity> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<TaskEntity> taskList) {
        this.taskList = taskList;
    }
}
