package edu.asu.ser316.petshelter.events;

public class IntakeEvent implements ShelterEvent {

    private final String animalId;
    private final int cycleNumber;
    private final String zoneCode;

    public IntakeEvent(String animalId, int cycleNumber, String zoneCode) {
        this.animalId = animalId;
        this.cycleNumber = cycleNumber;
        this.zoneCode = zoneCode;
    }

    public String getAnimalId() {
        return animalId;
    }

    public int getCycleNumber() {
        return cycleNumber;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    @Override
    public String getName() {
        return "IntakeEvent";
    }
}
