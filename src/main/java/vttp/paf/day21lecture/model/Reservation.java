package vttp.paf.day21lecture.model;

import java.util.Date;

public class Reservation {

    private int id;
    private Customer customer;
    private Room room;
    private Date startDate;
    private Date endDate;
    private float cost;

    
    public Reservation(int id, Customer customer, Room room, Date startDate, Date endDate, float cost) {
        this.id = id;
        this.customer = customer;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }

    public Reservation() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    } 
}
