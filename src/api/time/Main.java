package api.time;

import java.util.Date;
import java.sql.Timestamp;

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
        < JDK 기본 날짜 라이브러리의 문제>
            1. 불변 객체가 아니다 :: mutable
               어떤 객체가 Date 객체를 가지고 있으면
               방어적 복사를 통해 Date 객체의 복제본(새 객체)을 리턴해서
               내부의 Date 객체가 의도치 않게 변경되지 않도록 해야 한다.

            2. 초,분,월 등에 int 상수를 사용한 것도 문제라고 함.
                그럼 int 상수값 안 쓰면 어떻게 해야 하는데..?

            3. N월의 상수값이 N-1이다.
                예를 들어 Calendar.10월의 값은 9이다.
                그래서 헷갈린다고 한다.
                13월을 설정해도 Calendar.set()이 오류를 반환하지 않는다고 한다.

            4. TimeZone 아이디를 잘못 설정했을 때
                Asia/Seoul을 Seoul/Asia로 지정해도 컴파일 오류가 발생하지 않음.

            5. 기타 하위 클래스들의 문제
                - Comparable과 관련된 제네릭 선언을 복잡하게 만들었다? (무슨 말인지?)
                - Timestamp 클래스는 equals() 선언의 대칭성을 어겼다.
         */

        Timestamp t1 = new Timestamp(1);
        Date d1 = new Date(1);
        System.out.println(t1.equals(d1)+" "+d1.equals(t1));
        // t1 instanceof java.util.Date == true

//        *** Date 클래스의 equlas() ***
//        public boolean equals(Object obj) {
//            return obj instanceof Date && getTime() == ((Date) obj).getTime();
//        }

//        *** Timestamp 클래스의 equals***
//        public boolean equals(java.lang.Object ts) {
//            if (ts instanceof Timestamp) {
//                return this.equals((Timestamp)ts);
//            } else {
//                return false;
//            }
//        }

    }
}
