public class HotelRoom {
    private int _roomNum;
    private int _numBeds;
    private boolean _occupied;
    private String _guest;

    // קבועים לפי דרישות המטלה
    private final int DEFAULT_ROOM = 999;
    private final int DEFAULT_BEDS = 2;
    private final int MIN_BEDS = 2;
    private final int MAX_BEDS = 4;
    private final int MIN_ROOM = 100;
    private final int MAX_ROOM = 999;

    // בנאי המחלקה
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

    // שיטות אחזור (Getters)
    public int getRoomNum() {
        return _roomNum; 
    }
    
    public int getNumBeds() {
        return _numBeds; 
    }
    
    public boolean isOccupied() {
        return _occupied; 
    }
    
    public String getGuest() {
        return _guest; 
    }

    // שיטות קובעות (Setters)
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

    // שיטות פרטיות לבדיקת תקינות קלט
    private boolean roomNumOk(int roomNum) {
        return roomNum >= MIN_ROOM && roomNum <= MAX_ROOM;
    }

    private boolean numBedsOk(int numBeds) {
        return numBeds >= MIN_BEDS && numBeds <= MAX_BEDS;
    }

    // שיטות המחלקה
    public String toString() {
        String status = _occupied ? "Occupied by " + _guest : "Available";
        return "Room " + _roomNum + ", " + _numBeds + " Beds: " + status;
    }

    public boolean equals(HotelRoom other) {
        if (other == null) {
            return false;
        }
        
        return _roomNum == other._roomNum && _numBeds == other._numBeds;
    }

    public boolean before(HotelRoom other) {
        if (other == null) {
            return false;
        }
        
        return _roomNum < other._roomNum;
    }

    public boolean after(HotelRoom other) {
        if (other == null) {
            return false;
        }
        
        return other.before(this);
    }

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
    
    public boolean roomNumEquals(int other){
        return _roomNum == other;
    }
}
