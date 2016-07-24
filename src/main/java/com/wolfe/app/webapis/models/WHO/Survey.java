package webapis.models.WHO;

public class Survey
{
    public int year;
    public int value;

    public String region;
    public String country;
    public String gho;
    public String publishState;

    public void PrintAll()
    {
        System.out.println(country);
        System.out.println("Region: " + region);
        System.out.println("Year: " + year);
        System.out.println("Value: " + value);
        System.out.println("GHO: " + gho);
        System.out.println("Publish State: " + publishState);
        System.out.println("-------------------");
    }
}
