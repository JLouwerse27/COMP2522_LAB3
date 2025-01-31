package ca.bcit.comp2522.lab3;

import java.util.Objects;

/**
 * Represents the IPad, tracks whether it has a case and its operating system version.
 *
 * @author Ryan Chu
 * @author Joseph Louwerse
 * @version 2025
 */
public class IPad extends IDevice {

    // Whether the IPad has a case.
    private boolean hasCase;

    // The operating system version of the IPad, as a String.
    private String OSVersion;

    /**
     * Constructs an IPad with the specified case status and OS version.
     *
     * @param hasCase whether the IPad has a case.
     * @param OSVersion the operating system version of the IPad.
     */
    IPad(boolean hasCase, String OSVersion) {
        super("learning");
        validateOSVersion(OSVersion);
        this.hasCase = hasCase;
        this.OSVersion = OSVersion;
    }

    /**
     * Validates the operating system version.
     *
     * @param OSVersion the OS version to validate.
     * @throws IllegalArgumentException if the OS version is null or blank.
     */
    private static void validateOSVersion(String OSVersion) {
        if (OSVersion == null || OSVersion.isBlank()) {
            throw new IllegalArgumentException("Operating system version cannot be null or blank.");
        }
    }

    /**
     * Gets whether the IPad has a case.
     *
     * @return true if the IPad has a case, false otherwise.
     */
    public final boolean getHasCase() {
        return hasCase;
    }

    /**
     * Sets whether the IPad has a case.
     *
     * @param hasCase the new case status.
     */
    public final void setHasCase(boolean hasCase) {
        this.hasCase = hasCase;
    }

    /**
     * Gets the operating system version of the IPad.
     *
     * @return the OS version.
     */
    public String getOSVersion() {
        return OSVersion;
    }

    /**
     * Sets the operating system version of the IPad.
     *
     * @param OSVersion the new OS version.
     */
    public void setOSVersion(String OSVersion) {
        validateOSVersion(OSVersion);
        this.OSVersion = OSVersion;
    }

    /**
     * Prints the details of this IPad.
     */
    @Override
    void printDetails() {
        System.out.println(toString());
    }

    /**
     * Returns a string representation of the IPad, including details from the superclass.
     *
     * @return a string containing the device details.
     */
    @Override
    public String toString() {
        StringBuilder details = new StringBuilder();
        details.append(super.toString())
                .append("\nOperating System Version: ")
                .append(OSVersion)
                .append("\nHas Case: ")
                .append(hasCase ? "Yes" : "No");
        return details.toString();
    }

    /**
     * Checks if this IPad is equal to another object.
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
        IPad ipad = (IPad) obj;
        return Objects.equals(OSVersion, ipad.OSVersion);
    }

    /**
     * Generates a hash code for this IPad.
     *
     * @return the hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(OSVersion);
    }
}
