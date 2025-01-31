package ca.bcit.comp2522.lab3;

/**
 * Represents any IPhone, which tracks the carrier and remaining phone plan.
 *
 * @author Ryan Chu
 * @author Joseph Louwerse
 * @version 2025
 */
class IPhone extends IDevice
{
    private static final int MIN_PLAN_REMAINING_MINUTES = 0;

    private       double planRemainingMinutes;
    private final String carrier;


    /**
     * Constructs an IPhone with the specified plan remaining minutes and carrier.
     *
     * @param planRemainingMinutes the remaining minutes on the plan.
     * @param carrier the carrier providing the service.
     */
    IPhone(final double planRemainingMinutes, final String carrier)
    {
        super("talking");

        validatePlan(planRemainingMinutes);
        validateCarrier(carrier);

        this.planRemainingMinutes = planRemainingMinutes;
        this.carrier = carrier;
    }

    /*
     * Validates the remaining minutes of the phone plan.
     *
     * @param planRemainingMinutes the remaining minutes to validate.
     */
    private static void validatePlan(final double planRemainingMinutes)
    {
        if (planRemainingMinutes < MIN_PLAN_REMAINING_MINUTES) {
            throw new IllegalArgumentException("Plan remaining cannot be negative, got: " + planRemainingMinutes);
        }
    }

    /**
     * Validates the carrier name.
     *
     * @param carrier the carrier to validate.
     * @throws IllegalArgumentException if the carrier is null or blank.
     */
    private static void validateCarrier(final String carrier) {
        if (carrier == null || carrier.isBlank())
        {
            throw new IllegalArgumentException("Null or blank carrier");
        }
    }

    /**
     * Gets the remaining minutes on the phone plan.
     *
     * @return the remaining plan minutes.
     */
    public final double getPlanRemainingMinutes()
    {
        return planRemainingMinutes;
    }

    /**
     * Sets the remaining minutes on the phone plan.
     *
     * @param planRemainingMinutes the new remaining minutes.
     */
    public final void setPlanRemainingMinutes(double planRemainingMinutes)
    {
        this.planRemainingMinutes = planRemainingMinutes;
    }

    /**
     * Gets the carrier of the iPhone.
     *
     * @return the carrier name.
     */
    public final String getCarrier()
    {
        return carrier;
    }

    /**
     * Prints the details of the iPhone.
     */
    @Override
    void printDetails()
    {
        System.out.println(toString());
    }

    /**
     * Returns a string representation of the iPhone, including details from the superclass.
     *
     * @return a string containing the device details.
     */
    @Override
    public String toString()
    {
        StringBuilder details = new StringBuilder();

        details.append(super.toString())
               .append("\nPlan Remaining Minutes: ")
               .append(planRemainingMinutes)
               .append("\nCarrier: ")
               .append(carrier);

        return details.toString();
    }

    /**
     * Compares this iPhone to another object for equality.
     *
     * @param obj the object to compare with this iPhone.
     * @return {@code true} if the specified object is an instance of {@code IPhone} and has
     *         the same remaining plan minutes, otherwise {@code false}.
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
                    ((IPhone) obj).getPlanRemainingMinutes() == this.getPlanRemainingMinutes());
        }
    }

    /**
     * Computes the hash code for this iPhone instance.
     *
     * @return the hash code, based on the remaining plan minutes.
     */
    @Override
    public int hashCode()
    {
        return (int) getPlanRemainingMinutes();
    }
}
