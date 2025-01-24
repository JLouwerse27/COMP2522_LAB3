package ca.bcit.comp2522.lab3;



abstract class IDevice
{


    private String purpose;

    IDevice(final String purpose)
    {
        validatePurpose(purpose);
        this.purpose = purpose;
    }

    private static void validatePurpose(final String purpose)
    {
        if(purpose == null || purpose.isBlank())
        {
            throw new IllegalArgumentException("null or blank purpose");
        }
    }

    protected final String getPurpose()
    {
        return purpose;
    }

    abstract void printDetails();

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + this.getPurpose();
    }

    @Override
    public boolean equals(final Object obj)
    {
        if(obj instanceof IDevice)
        {
            return false;
        }
        else if (obj == this || obj.getClass().getSimpleName() == this.getClass().getSimpleName())
        {
            return true;
        }
        else
        {
         return false;
        }

    }


    @Override
    public int hashCode()
    {
        return 0;
    }






}