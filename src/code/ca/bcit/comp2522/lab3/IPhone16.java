package ca.bcit.comp2522.lab3;

/**
 * Represents the IPhone16, which uniquely tracks
 * it's storage and the presences of a high resulution camera.
 *
 * @author Ryan Chu
 * @author Joseph Louwerse
 * @version 2025
 */
final class IPhone16
        extends IPhone
{
    private static final int MIN_MEMORY_GB = 1;
    private static final int HIGH_RES_CAMERA_HASH_MOD = -1;

    private final boolean highResCamera;
    private       int     memoryGB;

    /**
     * Constructs an IPhone 16.
     * throws an exception if the memoryGB is lass than MIN_MEMORY_GB.
     *
     * @param planRemainingMinutes the phone plan remaining as a double
     * @param carrier the carrier as a String
     * @param highResCamera if the phone has a high resulustion camera
     * @param memoryGB the memory in GB as an int
     */
    IPhone16(final double planRemainingMinutes,
             final String carrier,
             final boolean highResCamera,
             final int memoryGB)
    {
        super(planRemainingMinutes,
              carrier);

        validateMemoryGB(memoryGB);

        this.highResCamera = highResCamera;
        this.memoryGB      = memoryGB;
    }

    /*
     * Validates the memory given is greater than MIN_MEMORY_GB
     * @param memoryGB the memory to check
     */
    private static void validateMemoryGB(final int memoryGB)
    {
        if(memoryGB < MIN_MEMORY_GB)
        {
            throw new IllegalArgumentException("Memory GB must be at least " + MIN_MEMORY_GB);
        }
        ;
    }

    /**
     * Checks if the device has a high-resolution camera.
     *
     * @return if the device has a high-resolution camera
     */
    protected final boolean hasHighResCamera()
    {
        return highResCamera;
    }

    /**
     * Gets the memory capacity of the device in gigabytes.
     *
     * @return the memory capacity in GB.
     */
    protected final int getMemoryGB()
    {
        return memoryGB;
    }

    /**
     * Validates then sets the memory capacity of the device.
     *
     * @param memoryGB the memory capacity in GB.
     */
    protected final void setMemoryGB(int memoryGB)
    {
        validateMemoryGB(memoryGB);
        this.memoryGB = memoryGB;
    }

    /**
     * Returns a String containing the class name and the instance variables from IDevice, IPhone, and IPhone16,
     * @return the details of the phone as a String
     */
    @Override
    public final String toString()
    {
        StringBuilder details;
        details = new StringBuilder();

        details.append(super.toString())
               .append("\nHigh Res Camera: ")
               .append(highResCamera)
               .append("\nMemory GB: ")
               .append(memoryGB);

        return details.toString();
    }



    /**
     * Compares this iPhone object to another object for equality.
     *
     * @param obj the object to compare with this iPhone.
     * @return {@code true} if the specified object is an instance of {@code IPhone} and has
     *         the same plan remaining minutes and high-resolution camera status as this iPhone,
     *         otherwise {@code false}.
     */
    @Override
    public boolean equals(final Object obj)
    {
        if (!(obj instanceof IPhone))
        {
            return false;
        }
        else
        {
            return (obj == this ||
                    (((IPhone) obj).getPlanRemainingMinutes() == this.getPlanRemainingMinutes()
                     && ((IPhone16) obj).hasHighResCamera()) == this.hasHighResCamera());
        }
    }

    /**
     * Computes the hash code for this iPhone instance.
     *
     * @return the hash code value, calculated based on the plan remaining minutes and
     *         whether the device has a high-resolution camera.
     */
    @Override
    public int hashCode()
    {
        if (highResCamera)
        {
            return (int) getPlanRemainingMinutes() * HIGH_RES_CAMERA_HASH_MOD;
        }
        return (int) getPlanRemainingMinutes();
    }
}
