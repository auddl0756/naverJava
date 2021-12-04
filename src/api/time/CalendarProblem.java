package api.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class CalendarProblem {
    //problem 1
    public void getTomorrow() {
        TimeZone utc = TimeZone.getTimeZone("UTC");
        Calendar calendar = Calendar.getInstance(utc);
        calendar.set(1582, Calendar.OCTOBER, 4);

        final String pattern = "yyyy.MM.dd";

        String theDay = toString(calendar, pattern, utc);
        calendar.add(Calendar.DATE, 1);
        String nextDay = toString(calendar, pattern, utc);

        //10월 4일, 10월 15일이 나온다.
        System.out.println(theDay + " " + nextDay);
    }

    //problem 2
    //이건 수정된 듯? 결과 제대로 나옴.
    public void afterOneHour() {
        TimeZone seoul = TimeZone.getTimeZone("Asia/Seoul");
        Calendar calendar = Calendar.getInstance(seoul);
        calendar.set(1988, Calendar.MAY, 7, 23, 0);
        String pattern = "yyyy.MM.dd HH:mm";
        String theTime = toString(calendar, pattern, seoul);
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        String after1Hour = toString(calendar, pattern, seoul);

        System.out.println(theTime + " " + after1Hour);
    }

    //problem 3
    public void getAfterOneMinute() {
        TimeZone seoul = TimeZone.getTimeZone("Asia/Seoul");
        Calendar calendar = Calendar.getInstance(seoul);
        calendar.set(1961, Calendar.AUGUST, 9, 23, 59);
        //String pattern = "yyyy.MM.dd HH:mm";
        String pattern = "yyyy.MM.dd HH:mm(Z)";
        String theTime = toString(calendar, pattern, seoul);
        calendar.add(Calendar.MINUTE, 1);

        String after1Minute = toString(calendar, pattern, seoul);

        //after1Minute이 1분 후인 00:00이 아니라 00:30이 됨.
        //utc 표준시가 변경된 시기여서 이런 결과가 나옴.
        //패턴에 (Z) 적어 주면 utc 시간까지 나옴.
        System.out.println(theTime + " " + after1Minute);
    }

    private String toString(Calendar calendar, String pattern, TimeZone timezone) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        formatter.setTimeZone(timezone);

        return formatter.format(calendar.getTime());
    }
}
