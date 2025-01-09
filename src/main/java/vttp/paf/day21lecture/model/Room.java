package vttp.paf.day21lecture.model;

public class Room {

    private int id;
    private String roomType;
    private float price;


    public Room(int id, String roomType, float price) {
        this.id = id;
        this.roomType = roomType;
        this.price = price;
    }

    public Room() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    } 
}
