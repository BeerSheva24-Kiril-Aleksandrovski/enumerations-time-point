package telran.time;

public class TimePoint implements Comparable<TimePoint> {
    private float amount;
    private TimeUnit timeUnit;
    public TimePoint(float amount, TimeUnit timeUnit) {
        this.amount = amount;
        this.timeUnit = timeUnit;
    }
    @Override
    public int compareTo(TimePoint arg0) {
        float res = this.timeUnit.between(this, arg0);
        return res > 0 ? 1 : res == 0 ? 0 : -1;
    }
    public float getAmount() {
        return amount;
    }
    public TimeUnit getTimeUnit() {
        return timeUnit;
    }
    @Override
    public boolean equals(Object obj) {        
        return this.compareTo((TimePoint)obj) == 0;
    }
    public TimePoint convert (TimeUnit timeUnit) {
        TimePoint res = new TimePoint(this.amount, timeUnit);                                          //returns new TimePoint obj equaled to the "this " obj but
        res.amount = res.amount * this.timeUnit.getValueOfSeconds() / timeUnit.getValueOfSeconds();    //with a given TimeUnit 
        return res;
    }
    public TimePoint with(TimePointAdjuster adjuster){
        return adjuster.adjust(this); 
    }
}
