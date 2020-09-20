package Lesson1.enums;

public enum DayOfWeek {
    MONDAY(true), TUESDAY(true), WEDNESDAY(true), THURSDAY(true), FRIDAY(true), SATURDAY(false), SUNDAY(false);

    private boolean workDay;

    DayOfWeek(boolean workDay) {
        this.workDay = workDay;
    }

    boolean getWorkDay (){
        return workDay;
    }
}
