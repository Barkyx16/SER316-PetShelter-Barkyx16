package edu.asu.ser316.petshelter.observers;

import edu.asu.ser316.petshelter.events.AdoptionEvent;
import edu.asu.ser316.petshelter.events.CapacityWarningEvent;
import edu.asu.ser316.petshelter.events.IntakeEvent;
import edu.asu.ser316.petshelter.events.ShelterEvent;
import edu.asu.ser316.petshelter.events.ShelterObserver;

/**
 * Observer that prints key events to the console.
 */
public class ConsoleLoggerObserver implements ShelterObserver {

    @Override
    public void onEvent(ShelterEvent event) {
        if (event instanceof IntakeEvent) {
            IntakeEvent intakeEvent = (IntakeEvent) event;
            System.out.println(
                    "Observer: IntakeEvent animalId=" + intakeEvent.getAnimalId()
                            + " cycle=" + intakeEvent.getCycleNumber()
                            + " zone=" + intakeEvent.getZoneCode());
            return;
        }

        if (event instanceof AdoptionEvent) {
            AdoptionEvent adoptionEvent = (AdoptionEvent) event;
            System.out.println(
                    "Observer: AdoptionEvent animalId=" + adoptionEvent.getAnimalId()
                            + " cycle=" + adoptionEvent.getCycleNumber());
            return;
        }

        if (event instanceof CapacityWarningEvent) {
            CapacityWarningEvent capacityEvent = (CapacityWarningEvent) event;
            System.out.println(
                    "Observer: CapacityWarningEvent zone=" + capacityEvent.getZoneCode()
                            + " count=" + capacityEvent.getCurrentCount()
                            + " capacity=" + capacityEvent.getCapacity());
            return;
        }

        System.out.println("Observer: Unknown event=" + event.getName());
    }
}
