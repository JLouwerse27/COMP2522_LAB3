package ca.bcit.comp2522.lab3;

import java.util.Objects;

/**
 * Represents the IPod, tracks the number of songs stored and volume range.
 *
 * @author Ryan Chu
 * @author Joseph Louwerse
 * @version 2025
 */
public class IPod extends IDevice {
    private static final int    MIN_NUM_SONGS_STORED = 0;
    private static final double MIN_VOLUME = 0.0;

    // The number of songs stored in the IPod.
    private int numSongsStored;

    // The maximum volume of the device, in decibels.
    private double maxVolume;

    /**
     * Constructs an IPod with the specified number of songs and maximum volume.
     *
     * @param numSongsStored the number of songs stored in the IPod.
     * @param maxVolume the maximum volume of the device.
     */
    IPod(final int numSongsStored, final double maxVolume) {
        super("music");
        validateNumSongsStored(numSongsStored);
        validateVolume(maxVolume);
        this.numSongsStored = numSongsStored;
        this.maxVolume = maxVolume;
    }

    /**
     * Validates the number of songs stored on the IPod.
     *
     * @param numSongsStored the number of songs to validate.
     * @throws IllegalArgumentException if the number of songs is negative.
     */
    private static void validateNumSongsStored(final int numSongsStored) {
        if (numSongsStored < MIN_NUM_SONGS_STORED) {
            throw new IllegalArgumentException("Songs stored cannot be negative, got: " + numSongsStored);
        }
    }

    /**
     * Validates the volume level.
     *
     * @param volume the volume to validate.
     * @throws IllegalArgumentException if the volume is negative.
     */
    private static void validateVolume(final double volume) {
        if (volume < MIN_VOLUME) {
            throw new IllegalArgumentException("Volume cannot be negative, got: " + volume);
        }
    }

    /**
     * Gets the number of songs stored in the IPod.
     *
     * @return the number of songs stored.
     */
    public final int getNumSongsStored() {
        return numSongsStored;
    }

    /**
     * Sets the number of songs stored in the IPod.
     *
     * @param numSongsStored the new number of songs stored.
     */
    public final void setNumSongsStored(int numSongsStored) {
        validateNumSongsStored(numSongsStored);
        this.numSongsStored = numSongsStored;
    }

    /**
     * Gets the maximum volume of the IPod.
     *
     * @return the maximum volume in decibels.
     */
    public final double getMaxVolume() {
        return maxVolume;
    }

    /**
     * Sets the maximum volume of the IPod.
     *
     * @param maxVolume the new maximum volume.
     */
    public final void setMaxVolume(double maxVolume) {
        validateVolume(maxVolume);
        this.maxVolume = maxVolume;
    }

    /**
     * Prints the details of this IPod.
     */
    @Override
    void printDetails() {
        System.out.println(toString());
    }

    /**
     * Returns a string representation of the IPod, including details from the superclass.
     *
     * @return a string containing the device details.
     */
    @Override
    public String toString() {
        StringBuilder details = new StringBuilder();
        details.append(super.toString())
                .append("\nNumber of Songs Stored: ")
                .append(numSongsStored)
                .append("\nMaximum Volume: ")
                .append(maxVolume).append(" dB");
        return details.toString();
    }

    /**
     * Checks if this IPod is equal to another object.
     *
     * @param obj the object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        IPod ipod = (IPod) obj;
        return numSongsStored == ipod.numSongsStored;
    }

    /**
     * Generates a hash code for this IPod.
     *
     * @return the hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(numSongsStored);
    }
}
