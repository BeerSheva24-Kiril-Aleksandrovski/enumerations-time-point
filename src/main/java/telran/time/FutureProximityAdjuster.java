package telran.time;

import java.util.Arrays;

public class FutureProximityAdjuster implements TimePointAdjuster {
    TimePoint [] timePoints;
    public FutureProximityAdjuster(TimePoint [] timePoints) {             //copy a given array 
        this.timePoints = Arrays.copyOf(timePoints, timePoints.length);   //sort copy and assign to the field timePoints
        Arrays.sort(this.timePoints);                                     //using standart Arrays class                                                
    }                                                                     //repeated time points are possible
    @Override
    public TimePoint adjust (TimePoint timePoint) {
        TimePoint fin = new TimePoint(0, null);
        /*int low = 0, high = timePoints.length - 1;
        int res = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int comp = timePoints[mid].compareTo(timePoint);
            if (comp < 0) {
                low = mid + 1;
            } else if (comp > 0 ) {
                high = mid - 1;
            } else if (comp == 0) {
                res = mid;
                break;
            }
        }
        if (res > 0) {
            float a = TimeUnit.SECOND.between(timePoint, timePoints[res + 1]);
            float b = TimeUnit.SECOND.between(timePoint, timePoints[res - 1]);
            if (a < b) {
                fin = timePoints[res];
            } else {
                fin = timePoints[res - 1];
            } 
        */
        for (int i = 0; i < timePoints.length; i++) {
            if (timePoints[i].compareTo(timePoint) > 0){
                fin = timePoints [i];
                break;
            }
        }
        //returns a time point only in future (greater  than a gfiven time point) from field timePoints
        //nbearest to a  given timePoint value
        return fin;
    }

}
