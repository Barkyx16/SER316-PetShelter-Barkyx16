package edu.asu.ser316.petshelter.events;

public class AdoptionEvent implements ShelterEvent {

    private final String animalId;
    private final int cycleNumber;

    public AdoptionEvent(String animalId, int cycleNumber) {
        this.animalId = animalId;
        this.cycleNumber = cycleNumber;
    }

    public String getAnimalId() {
        return animalId;
    }

    public int getCycleNumber() {
        return cycleNumber;
    }

    @Override
    public String getName() {
        return "AdoptionEvent";
    }
}
