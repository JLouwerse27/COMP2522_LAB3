package ca.bcit.comp2522.lab3;

/**
 * Parent of any device in the apple I line of products.
 * Contains methods to get and print details.
 *
 * @author Ryan Chu
 * @author Joseph Louwerse
 * @version 2025
 */
abstract class IDevice
{

    private final String purpose;

    /**
     * Constructs an {@code IDevice} with the specified purpose.
     *
     * @param purpose the purpose of the device.
     */
    IDevice(final String purpose)
    {
        validatePurpose(purpose);
        this.purpose = purpose;
    }

    /**
     * Validates the purpose of the device.
     *
     * @param purpose the purpose to validate.
     */
    private static void validatePurpose(final String purpose)
    {
        if (purpose == null || purpose.isBlank())
        {
            throw new IllegalArgumentException("null or blank purpose");
        }
    }

    /**
     * Gets the purpose of this device.
     *
     * @return the purpose of the device.
     */
    protected final String getPurpose()
    {
        return purpose;
    }

    /**
     * Prints the details of the device.
     */
    abstract void printDetails();

    /**
     * Returns a string representation of this device, including its type and purpose.
     *
     * @return a string representation of the device.
     */
    @Override
    public String toString()
    {
        StringBuilder details = new StringBuilder();

        details.append("Type: ")
               .append(this.getClass().getSimpleName())
               .append("\nPurpose: ")
               .append(this.getPurpose());

        return details.toString();
    }

    /**
     * Compares this device to another object for equality.
     *
     * @param obj the object to compare with this device.
     * @return {@code true} if the specified object is an instance of {@code IDevice} and has
     *         the same class type, otherwise {@code false}.
     */
    @Override
    public boolean equals(final Object obj)
    {
        if (!(obj instanceof IDevice))
        {
            return false;
        }
        else
        {
            return (obj == this ||
                    obj.getClass().equals(this.getClass()));
        }
    }

    /**
     * Computes the hash code for this device.
     *
     * @return a hash code value for this device.
     */
    @Override
    public int hashCode()
    {
        return 0;
    }
}