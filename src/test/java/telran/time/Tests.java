package telran.time;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Tests {
    
    @Test
    void compareToTest(){
        TimePoint tp = new TimePoint(1800, TimeUnit.SECOND);
        assertEquals(1,new TimePoint(60, TimeUnit.MINUTE).compareTo(tp));
        assertEquals(0,new TimePoint(30, TimeUnit.MINUTE).compareTo(tp));
        assertEquals(-1,new TimePoint((float) 0.1, TimeUnit.HOUR).compareTo(tp));
    }

    @Test
    void equalsTrueTest(){
        TimePoint tp = new TimePoint(1800, TimeUnit.SECOND);
        TimePoint tp2 = new TimePoint(30, TimeUnit.MINUTE);
        TimePoint tp3 = new TimePoint((float)0.5, TimeUnit.HOUR);
        assertTrue(tp2.equals(tp3));
        assertTrue(tp.equals(tp2));
        assertTrue(tp.equals(tp3));
    }
    @Test
    void equalsFalseTest(){
        TimePoint tp = new TimePoint(1800, TimeUnit.SECOND);
        TimePoint tp2 = new TimePoint(31, TimeUnit.SECOND);
        TimePoint tp3 = new TimePoint(1, TimeUnit.HOUR);
        assertFalse(tp.equals(tp2));
        assertFalse(tp.equals(tp3));
        assertFalse(tp2.equals(tp3));
    }
    @Test
    void convertTest(){
        TimePoint tets = new TimePoint(10,TimeUnit.MINUTE);
        assertEquals(600,tets.convert(TimeUnit.SECOND).getAmount());
        assertEquals((float)1/6,tets.convert(TimeUnit.HOUR).getAmount());

        TimePoint a = new TimePoint(10,TimeUnit.HOUR);
        assertEquals(36000,a.convert(TimeUnit.SECOND).getAmount());
        assertEquals(600,a.convert(TimeUnit.MINUTE).getAmount());

    }
    @Test
    void betweenTest() {
        TimePoint p1 = new TimePoint(1800, TimeUnit.SECOND);
        TimePoint p2 = new TimePoint(60, TimeUnit.MINUTE);
        
        assertEquals(-30, TimeUnit.MINUTE.between(p1, p2));
        assertEquals(30, TimeUnit.MINUTE.between(p2, p1));
        assertEquals(-1800, TimeUnit.SECOND.between(p1, p2));
        assertEquals(-0.5, TimeUnit.HOUR.between(p1, p2));
    }
    @Test
    public void PlusTimePointAdjusterTest(){
        TimePoint pt = new TimePoint(100, TimeUnit.SECOND);
        TimePoint expected = new TimePoint(101, TimeUnit.SECOND);
        PlusTimePointAdjuster newAdjuster = new PlusTimePointAdjuster(1,TimeUnit.SECOND);
        assertEquals(expected, pt.with(newAdjuster));
        TimePoint pt1 = new TimePoint(30, TimeUnit.MINUTE);
        TimePoint expected1 = new TimePoint((float)1.5, TimeUnit.HOUR);
        PlusTimePointAdjuster newAdjuster2 = new PlusTimePointAdjuster(60,TimeUnit.MINUTE);
        assertEquals(expected1, pt1.with(newAdjuster2));
    }
    @Test
    public void FutureProximityAdjusterTest (){ 
    TimePoint p1 = new TimePoint(120, TimeUnit.SECOND); //120
    TimePoint p2 = new TimePoint(1, TimeUnit.MINUTE);   //60
    TimePoint p3 = new TimePoint(30, TimeUnit.SECOND);  //30
    TimePoint p4 = new TimePoint((float)1.1, TimeUnit.HOUR);   //
    TimePoint p5 = new TimePoint(60, TimeUnit.MINUTE);  //3600
    TimePoint[] timePoints = {p1, p2, p3, p4, p5};
    TimePoint p6 = new TimePoint(100, TimeUnit.SECOND);
    assertEquals(p1, timePoints.adjust(p6));
}
}
