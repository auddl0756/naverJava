package api.time;

public class Main {
    public static void main(String[] args) {
        CalendarProblem calendarProblem = new CalendarProblem();
        calendarProblem.getTomorrow();

        calendarProblem.afterOneHour();

        calendarProblem.getAfterOneMinute();

        //자바는 OS에 의존하지 않고 시간대 DB르 업데이트 함.
        //이런 오류들이 시간대 DB의 오류때문이라고 함.
        //국제화 관련 개발을 하면 시간대 DB에 대해 의심해 봐야 한다고 함.

        /*

         */
    }
}
