package edu.asu.ser316.petshelter.observers;

import edu.asu.ser316.petshelter.events.AdoptionEvent;
import edu.asu.ser316.petshelter.events.CapacityWarningEvent;
import edu.asu.ser316.petshelter.events.IntakeEvent;
import edu.asu.ser316.petshelter.events.ShelterEvent;
import edu.asu.ser316.petshelter.events.ShelterObserver;

/**
 * Observer that tracks summary counts for the simulation.
 */
public class ShelterStatsObserver implements ShelterObserver {

    private int intakeCount;
    private int adoptionCount;
    private int capacityWarningCount;

    @Override
    public void onEvent(ShelterEvent event) {
        if (event instanceof IntakeEvent) {
            intakeCount++;
            return;
        }
        if (event instanceof AdoptionEvent) {
            adoptionCount++;
            return;
        }
        if (event instanceof CapacityWarningEvent) {
            capacityWarningCount++;
        }
    }

    public int getIntakeCount() {
        return intakeCount;
    }

    public int getAdoptionCount() {
        return adoptionCount;
    }

    public int getCapacityWarningCount() {
        return capacityWarningCount;
    }

    public String buildSummaryString() {
        return "Stats: intakes=" + intakeCount
                + " adoptions=" + adoptionCount
                + " capacityWarnings=" + capacityWarningCount;
    }
}
