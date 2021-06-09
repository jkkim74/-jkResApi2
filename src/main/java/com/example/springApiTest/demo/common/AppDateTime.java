package com.example.springApiTest.demo.common;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class AppDateTime {

    public static void main(String[] args){
        Date date = new Date();
        Instant instant = date.toInstant();
        System.out.println(instant);
        Date from = Date.from(instant);
        System.out.println(from);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        ZonedDateTime zonedDateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
        LocalDateTime dateTime = zonedDateTime.toLocalDateTime();
        System.out.println(dateTime);


        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now.format(dateTimeFormatter));

        LocalDate parse = LocalDate.parse("06/10/1974", dateTimeFormatter);
        System.out.println(parse);


        String format = dateTime.format(dateTimeFormatter);
        System.out.println(format);


        GregorianCalendar from1 = GregorianCalendar.from(zonedDateTime);
        System.out.println(from1.getWeeksInWeekYear());

        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);
        System.out.println(timeZone.observesDaylightTime());

        LocalDateTime now1 = LocalDateTime.now();
        LocalDateTime plus = now1.plus(20, ChronoUnit.DAYS);
        System.out.println(now);
        System.out.println(plus);

    }
}
