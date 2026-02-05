## AI Code Review

❌ Duplicate Code (-10 points)
Methods with duplication: findRoomByNumber and findRoomByBeds
```java
private static HotelRoom findRoomMatch(int roomNum,int numBeds,boolean byRoomNum,HotelRoom a,HotelRoom b,HotelRoom c){ if(a!=null){ if(byRoomNum ? a.getRoomNum()==roomNum : a.getNumBeds()==numBeds && !a.isOccupied()) return a;} if(b!=null){ if(byRoomNum ? b.getRoomNum()==roomNum : b.getNumBeds()==numBeds && !b.isOccupied()) return b;} if(c!=null){ if(byRoomNum ? c.getRoomNum()==roomNum : c.getNumBeds()==numBeds && !c.isOccupied()) return c;} return null; }
```
Recommended adjusted grade: 90%
