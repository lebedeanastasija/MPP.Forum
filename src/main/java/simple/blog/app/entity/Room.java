package simple.blog.app.entity;

/**
 * Created by Anastasiya on 02.04.2017.
 */
public class Room {
    private Integer idRoom;
    private Byte seatsNumber;
    private Integer perdayCost;

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public Byte getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(Byte seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public Integer getPerdayCost() {
        return perdayCost;
    }

    public void setPerdayCost(Integer perdayCost) {
        this.perdayCost = perdayCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (idRoom != null ? !idRoom.equals(room.idRoom) : room.idRoom != null) return false;
        if (seatsNumber != null ? !seatsNumber.equals(room.seatsNumber) : room.seatsNumber != null) return false;
        if (perdayCost != null ? !perdayCost.equals(room.perdayCost) : room.perdayCost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRoom != null ? idRoom.hashCode() : 0;
        result = 31 * result + (seatsNumber != null ? seatsNumber.hashCode() : 0);
        result = 31 * result + (perdayCost != null ? perdayCost.hashCode() : 0);
        return result;
    }
}
