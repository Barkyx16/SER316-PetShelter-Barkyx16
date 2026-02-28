package edu.asu.ser316.petshelter.events;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Publishes events to observers.
 */
public class ShelterEventBus {

    private final Collection<ShelterObserver> observerCol = new ArrayList<>();

    public void registerObserver(ShelterObserver observer) {
        if (observer == null) {
            throw new IllegalArgumentException("observer cannot be null");
        }
        observerCol.add(observer);
    }

    public void publish(ShelterEvent event) {
        if (event == null) {
            throw new IllegalArgumentException("event cannot be null");
        }

        int ix0 = 0;
        for (ShelterObserver observer : observerCol) {
            ix0++;
            observer.onEvent(event);
        }
    }
}
