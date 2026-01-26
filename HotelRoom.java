// ==========================
// File: HotelRoom.java
// ==========================
public class HotelRoom {
    // --- Attributes ---
    private int _roomNum;       // three digits: 100..999, default 999 if invalid
    private int _numBeds;       // 2..4, default 2 if invalid
    private boolean _occupied;  // default false
    private String _guest;      // default ""

    // --- Constants ---
    private static final int MIN_ROOM = 100;
    private static final int MAX_ROOM = 999;
    private static final int DEFAULT_ROOM = 999;

    private static final int MIN_BEDS = 2;
    private static final int MAX_BEDS = 4;
    private static final int DEFAULT_BEDS = 2;

    // --- Constructor ---
    public HotelRoom(int roomNum, int numBeds) {
        if (roomNumOk(roomNum)) {
            _roomNum = roomNum;
        } else {
            _roomNum = DEFAULT_ROOM;
        }
        if (numBedsOk(numBeds)) {
            _numBeds = numBeds;
        } else {
            _numBeds = DEFAULT_BEDS;
        }
        _occupied = false;
        _guest = "";
    }

    // --- Getters ---
    public int getRoomNum() { return _roomNum; }
    public int getNumBeds() { return _numBeds; }
    public boolean isOccupied() { return _occupied; }
    public String getGuest() { return _guest; }

    // --- Setters ---
    public void setRoomNum(int roomNum) {
        if (roomNumOk(roomNum)) {
            _roomNum = roomNum;
        }
    }
    public void setNumBeds(int numBeds) {
        if (numBedsOk(numBeds)) {
            _numBeds = numBeds;
        }
    }

    // --- Private validators ---
    private boolean roomNumOk(int roomNum) {
        return roomNum >= MIN_ROOM && roomNum <= MAX_ROOM;
    }
    private boolean numBedsOk(int numBeds) {
        return numBeds >= MIN_BEDS && numBeds <= MAX_BEDS;
    }

    // --- toString (exact formatting) ---
    public String toString() {
        if (_occupied) {
            return "Room " + _roomNum + ", " + _numBeds + " Beds: Occupied by " + _guest;
        } else {
            return "Room " + _roomNum + ", " + _numBeds + " Beds: Available";
        }
    }

    // --- Equality: same room number AND same number of beds ---
    public boolean equals(HotelRoom other) {
        return _roomNum == other._roomNum && _numBeds == other._numBeds;
    }

    // --- Ordering by room number ---
    public boolean before(HotelRoom other) {
        return _roomNum < other._roomNum;
    }
    public boolean after(HotelRoom other) {
        // must be implemented using before only (as taught)
        return other.before(this);
    }

    // --- State changes ---
    public boolean checkIn(String guest) {
        if (!_occupied) {
            _occupied = true;
            _guest = guest;
            return true;
        }
        return false;
    }

    public void checkOut() {
        _occupied = false;
        _guest = "";
    }
}
