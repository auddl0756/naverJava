package api.time;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneRules;
import java.time.zone.ZoneRulesException;

//기존 자바 날짜 클래스의 문제점을 개선한 api들이 jdk8부터 포함됐다.
//JSR (Java Specification Request)라는 자바 표준 스펙서 310번째에 기술됐다고 함.
// java.time 패키지 아래의 api들.
// Joda-Time이란 라이브러리에 영향을 많이 받았다고 함.

public class JSR310 {
    public void getTomorrow() {
//        LocalDate theDay = IsoChronology.INSTANCE.date(1582,10,4);
        LocalDate theDay = LocalDate.of(1582, 10, 4);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

        LocalDate nextDay = theDay.plusDays(1);

        System.out.println(theDay.format(formatter) + " " + nextDay.format(formatter));
    }

    public void getAfterOneHour() {
        ZoneId seoul = ZoneId.of("Asia/Seoul");
        ZonedDateTime theTime = ZonedDateTime.of(1988, 5, 7, 23, 0, 0, 0, seoul);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        ZoneRules seoulRules = seoul.getRules();
        ZonedDateTime after1Hour = theTime.plusHours(1);

        System.out.println(theTime + " " + after1Hour);
    }

    //잘못된 zone 아이디 설정 시 exception 발생하여 알려줌.
    public void setWrongZoneId() {
        try {
            ZoneId.of("Seoul/Asia");
        } catch (ZoneRulesException zoneRulesException) {
            zoneRulesException.printStackTrace();
        }
    }
}
