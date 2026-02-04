import java.util.*;
public class Hotel {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        HotelRoom room1 = new HotelRoom(307, 4);
        HotelRoom room2 = new HotelRoom(205, 3);
        room2.checkIn("Test Guest");
        HotelRoom room3 = new HotelRoom(402, 2);
        System.out.println("Hotel rooms:");
        display(room1, room2, room3);
        System.out.println("\nHotel Menu:\n1 - Display rooms by room number (ascending)\n2 - Check-in to a room\n3 - Check-out from a room\n4 - Find available room by requested beds\nEnter your choice:");
        int selection = scan.nextInt();
        String name;
        int roomNumber;
        scan.nextLine();
        int numBeds;
        switch(selection) {
            case 1:
                displaySorted(room1, room2, room3);
                break;
            case 2:
                System.out.println("Enter room number:");
                roomNumber = scan.nextInt();
                scan.nextLine();

                System.out.println("Enter guest name:");
                name = scan.nextLine();
    
    
                checkIn(name, roomNumber, room1, room2, room3);
                break;
            case 3:
                System.out.println("Enter room number:");
                roomNumber = scan.nextInt();
                scan.nextLine();
                checkOut(roomNumber, room1, room2, room3);
                break;
            case 4:
                System.out.println("Enter requested number of beds (2-4):");
                numBeds = scan.nextInt();
                scan.nextLine();
                findAvailableByBeds(numBeds, room1, room2, room3);
                break;
            default:
                System.out.println("Error: Invalid menu choice");
        }
    }
    // בודק אם החדרים הם null או לא         
    public static void nullVerify(HotelRoom a, HotelRoom b, HotelRoom c) {
        if(a == null || b == null || c == null){
            return;
        }
    }
    //מדפיס את החדרים         
    public static void display(HotelRoom a, HotelRoom b, HotelRoom c) {
        nullVerify(a, b, c);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
    
    public static void displaySorted(HotelRoom a, HotelRoom b, HotelRoom c) {
        nullVerify(a, b, c);
        HotelRoom first = a;
        HotelRoom second = b;
        HotelRoom third = c;

        if (second.before(first)) {
            HotelRoom temp = first;
            first = second;
            second = temp;
        }
        
        if (third.before(first)) {
            HotelRoom tempSecond = second;
            second = first;
            first = third;
            third = tempSecond;
        } else if (third.before(second)) {
            HotelRoom tempSecond = second;
            second = third;
            third = tempSecond;
        }
        System.out.println("Hotel Rooms by room number:");
        display(first, second, third);
    }

    public static HotelRoom findRoomByNumber(int roomNum, HotelRoom a, HotelRoom b, HotelRoom c) {
        nullVerify(a, b, c);
        if(a != null && a.getRoomNum() == roomNum) {
            return a;
        }
        
        if(b != null && b.getRoomNum() == roomNum) {
            return b;
        }
        
        if(c != null && c.getRoomNum() == roomNum) {
            return c;
        }
        return null;
        }
    
    public static void checkIn(String guestName, int roomNum, HotelRoom a, HotelRoom b, HotelRoom c) {
        nullVerify(a, b, c);
        if(guestName == null) {
            return;
        }
        
        HotelRoom room = findRoomByNumber(roomNum, a, b, c);    
        if(room != null && room.checkIn(guestName)) {
            System.out.println(room);  
        } else {
            System.out.println("Error: Room not available or not found");
        }
    }
        
    public static void checkOut(int roomNum, HotelRoom a, HotelRoom b, HotelRoom c) {
        nullVerify(a, b, c);
        HotelRoom room = findRoomByNumber(roomNum, a, b, c);
        if(room != null){
            room.checkOut();
            System.out.println(room);
        } else {
            System.out.println("Error: Room not available or not found");
        }
    }
      
    public static void findAvailableByBeds(int beds, HotelRoom a, HotelRoom b, HotelRoom c) {
        nullVerify(a, b, c);
        HotelRoom room = findRoomByBeds(beds, a, b, c);
        if(room != null){
            System.out.println(room);
        } else {
            System.out.println("No available room with the requested number of beds");
        }
    }   
    
    public static HotelRoom findRoomByBeds(int numBeds, HotelRoom a, HotelRoom b, HotelRoom c) {
        nullVerify(a, b, c);
        if(a != null && a.getNumBeds() == numBeds && !a.isOccupied()) {
            return a;
        }
        
        if(b != null && b.getNumBeds() == numBeds && !b.isOccupied()) {
            return b;
        }
        
        if(c != null && c.getNumBeds() == numBeds && !c.isOccupied()) {
            return c;
        }
        return null;
        }
}
