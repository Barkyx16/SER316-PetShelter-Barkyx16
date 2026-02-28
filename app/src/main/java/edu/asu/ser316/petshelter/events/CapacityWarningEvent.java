package edu.asu.ser316.petshelter.events;

public class CapacityWarningEvent implements ShelterEvent {

    private final String zoneCode;
    private final int currentCount;
    private final int capacity;

    public CapacityWarningEvent(String zoneCode, int currentCount, int capacity) {
        this.zoneCode = zoneCode;
        this.currentCount = currentCount;
        this.capacity = capacity;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String getName() {
        return "CapacityWarningEvent";
    }
}
