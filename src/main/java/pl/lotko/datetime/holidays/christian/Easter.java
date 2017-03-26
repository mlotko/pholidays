package pl.lotko.datetime.holidays.christian;

import pl.lotko.datetime.holidays.Holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class Easter implements Holiday {
    @Override
    public boolean isOn(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SUNDAY
                && date.isEqual(ofYear(date.getYear()));
    }

    public static LocalDate ofYear(int year) {
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int g = (8 * b + 13) / 25;
        int h = (19 * a + b - d - g + 15) % 30;
        int j = c / 4;
        int k = c % 4;
        int m = (a + 11 * h) / 319;
        int r = (2 * e + 2 * j - k - h + m + 32) % 7;
        int month = (h - m + r + 90) / 25;
        int day = (h - m + r + month + 19) % 32;
        return LocalDate.of(year, Month.of(month), day);
    }
}
