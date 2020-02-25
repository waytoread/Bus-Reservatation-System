import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class Bus {
    private int id;
    private String bus_route;
    private static int SIZE = 30;
    private int[] seat = new int[SIZE];
    private static Set<Integer> id_list = new TreeSet<Integer>();
    public Bus(int id) throws Exception {
        setId(id);
    }

    public Bus(int id, String bus_route) throws Exception {
        setId(id);
        this.bus_route = bus_route;

    }

    public String getBus_route() {
        return bus_route;
    }

    public void setBus_route(String bus_route) {
        this.bus_route = bus_route;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {
        try {
            int old_size = id_list.size();
            id_list.add(id);
            if(old_size == id_list.size()){
                throw new Exception("This ID already exists");
            }else {
                this.id = id;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public int getSeat(int seat_number) {
        return seat[seat_number];
    }

    public void setSeat(int seat_number) throws Exception {
        try {
            if (this.seat[seat_number] == 1)
                throw new Exception("This seat is already occupied");
            else 
            this.seat[seat_number]++;
        }catch (Exception e){
            throw  e;
        }
    }

    public Vector<Integer> available_seats(){
        Vector<Integer> available = new Vector<Integer>();

        for (int i = 0; i < SIZE; i++) {
            if(seat[i]==0){
                available.add(i);
            }
        }
        return available;
    }
    public int number_of_available_seats(){
        int number_available = 0;
        for (int i = 0; i < SIZE; i++) {
            if(seat[i]==0) number_available++;
        }
        return number_available;
    }
}
