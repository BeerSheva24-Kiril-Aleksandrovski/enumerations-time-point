package telran.time;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DayOfWeekTest {
    private static final String ISRAEL_WEEKEND = null;
    private static final String WEEKEND = "";
    private static final String NON_ISRAEL_WEEKEND = "Weekend but not in Israel";
    private static final String WORKING_DAY = "Working day";

    String getComment(DayOfWeek dayOfWeek) {
        String comment = switch(dayOfWeek){
            case FRI -> ISRAEL_WEEKEND;
            case SAT -> WEEKEND;
            case SUN -> NON_ISRAEL_WEEKEND;
            default -> WORKING_DAY;
        };
        return comment;
    }
    @Test
    void getCommentTest(){
        assertEquals(WORKING_DAY, getComment(DayOfWeek.THU));
        assertEquals(ISRAEL_WEEKEND, getComment(DayOfWeek.FRI));
        assertEquals(WEEKEND, getComment(DayOfWeek.SAT));
    }
    @Test
    void enumExistingMethodsTest() {
        DayOfWeek[] expected = {DayOfWeek.MON, DayOfWeek.TUE,DayOfWeek.WED,DayOfWeek.THU,DayOfWeek.FRI,DayOfWeek.SAT,DayOfWeek.SUN};
        assertArrayEquals(expected, DayOfWeek.values());
        assertEquals("MON", DayOfWeek.MON.toString());
        assertEquals(DayOfWeek.MON, DayOfWeek.valueOf("MON"));
        assertThrowsExactly(IllegalArgumentException.class, () -> DayOfWeek.valueOf("lyly"));

    }

}
