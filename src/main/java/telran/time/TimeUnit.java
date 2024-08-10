package telran.time;

public enum TimeUnit {
    SECOND(1), MINUTE(60), HOUR(3600);
    private int valueOfSeconds;    
    TimeUnit(int valueOfSeconds){
        this.valueOfSeconds = valueOfSeconds;
    }
    public int getValueOfSeconds() {
        return valueOfSeconds;
    }
    public float between(TimePoint p1, TimePoint p2){                               //returns amount of "this" time units between p2 and p1
        float res = p1.convert(this).getAmount() - p2.convert(this).getAmount();    // if p2 < p1 a negative valuse should be returned  
        return res;
    }
}
