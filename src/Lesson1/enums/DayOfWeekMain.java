package Lesson1.enums;

public class DayOfWeekMain {
    public static void main(String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.MONDAY));
        System.out.println(getWorkingHours(DayOfWeek.SUNDAY));
    }

    private static int getWorkingHours(DayOfWeek dayOfWeek) {
        if (dayOfWeek.getWorkDay()){
            int hours = 40 - dayOfWeek.ordinal() * 8;
            return hours;
        } else {
             System.out.println("Сегодня выходной");
        } return 0;
    }

}
