/**
 * Read web server data and analyse
 * hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer(String filename)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[25];
        // Create the reader to obtain the data.
        reader = new LogfileReader(filename);
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        int hour = 0;
        while(true){
            hour++;
            System.out.println(hour + ": " + hourCounts[hour]);
            if(hour>=hourCounts.length-1){
                break;
            }
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    
    /**
     * Return the number of accesses recorded in the log file.
     */
    public int numberOfAccesses(){
        int total = 0;
        //Add the value in each element of hourCounts.
        //to total.
        int hour = 0;
        while(true){
            hour++;
            total = total + hourCounts[hour];
            if(hour>=hourCounts.length-1){
                break;
            }
        }
        return total;
    }
    
    /**
     * Return the busiest hour
     */
    public int busiestHour(){
        int busy = 0;
        for(int hour = 0; hour < hourCounts.length; hour++){
            if(hourCounts[hour]>busy){
                busy=hourCounts[hour];
            }
        }
        return busy;
    }
    
    /**
     * Return the quietest hour
     */
    public int quietestHour(){
        int quiet = hourCounts[1];
        for(int hour = 0; hour < hourCounts.length; hour++){
            if(hourCounts[hour]<quiet){
                quiet=hourCounts[hour];
            }
        }
        return quiet;
    }
    
    /**
     * Return the busiest 2 hour period
     */
    public int busiestTwoHour(){
        int most = 0;
        for(int hour = 0; hour<hourCounts.length; hour++){
            int period = hourCounts[hour]+hourCounts[hour+1];
            if(period>most){
                most=period;
            }
            if(hour == hourCounts.length-2){
                break;
            }
        }
        return most;
    }
}
