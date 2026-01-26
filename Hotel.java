
// ==========================
// File: Hotel.java
// ==========================
import java.util.Scanner;

public class Hotel {
	public static void main(String[] args) {
		// Create the 3 rooms in the exact order specified
		HotelRoom r1 = new HotelRoom(307, 4);
		HotelRoom r2 = new HotelRoom(205, 3);
		HotelRoom r3 = new HotelRoom(402, 2);

		// Room 205 is initially occupied by "Test Guest"
		r2.checkIn("Test Guest");

		// Initial display (same order as created)
		System.out.println("Hotel rooms:");
		display(r1, r2, r3);
		System.out.println();

		// Menu
		System.out.println("Hotel Menu:");
		System.out.println("1 - Display rooms by room number (ascending)");
		System.out.println("2 - Check-in to a room");
		System.out.println("3 - Check-out from a room");
		System.out.println("4 - Find available room by requested beds");
		System.out.println("Enter your choice:");

		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		switch (choice) {
			case 1: {
				System.out.println("Rooms by room number:");
				displaySorted(r1, r2, r3);
				break;
			}
			case 2: {
				System.out.println("Enter room number:");
				int roomNum = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter guest name:");
				String guest = sc.nextLine();
				checkIn(guest, roomNum, r1, r2, r3);
				break;
			}
			case 3: {
				System.out.println("Enter room number:");
				int roomNum = sc.nextInt();
				checkOut(roomNum, r1, r2, r3);
				break;
			}
			case 4: {
				System.out.println("Enter requested number of beds (2-4):");
				int beds = sc.nextInt();
				findAvailableByBeds(beds, r1, r2, r3);
				break;
			}
			default: {
				System.out.println("Error: Invalid menu choice");
			}
		}
		sc.close();
	}

	public static void display(HotelRoom a, HotelRoom b, HotelRoom c) {
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
	}

	public static void displaySorted(HotelRoom a, HotelRoom b, HotelRoom c) {
		// order will be a b c
		HotelRoom t;
		if (b.before(a) && b.before(c)) {// b first
			t = a;
			a = b;
			b = t;
		} else if (c.before(a)) { // c first
			t = a;
			a = c;
			c = t;
		}// now a first
		if (c.before(b)) {
			t = c;
			c = b;
			b = t;
		}
		display(a, b, c);
	}

	public static HotelRoom findRoomByNumber(int roomNum, HotelRoom a, HotelRoom b, HotelRoom c) {
		if (a.getRoomNum() == roomNum)
			return a;
		if (b.getRoomNum() == roomNum)
			return b;
		if (c.getRoomNum() == roomNum)
			return c;
		return null;
	}

	public static void checkIn(String guest, int roomNum, HotelRoom a, HotelRoom b, HotelRoom c) {
		HotelRoom r = findRoomByNumber(roomNum, a, b, c);
		if (r != null && r.checkIn(guest)) {
			System.out.println(r);
		} else {
			System.out.println("Error: Room not available or not found");
		}
	}

	public static void checkOut(int roomNum, HotelRoom a, HotelRoom b, HotelRoom c) {
		HotelRoom r = findRoomByNumber(roomNum, a, b, c);
		if (r != null) {
			r.checkOut();
			System.out.println(r);
		} else {
			System.out.println("Error: Room not available or not found");
		}
	}

	public static void findAvailableByBeds(int beds, HotelRoom a, HotelRoom b, HotelRoom c) {
		if (a.getNumBeds() == beds && !a.isOccupied())
			System.out.println(a);
		else if (b.getNumBeds() == beds && !b.isOccupied())
			System.out.println(b);
		else if (c.getNumBeds() == beds && !c.isOccupied())
			System.out.println(c);
		else
			System.out.println("No available room with the requested number of beds");
	}
}
