package pl.lotko.datetime.holidays.christian;

import pl.lotko.datetime.holidays.Holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class CorpusChristi implements Holiday {

    @Override
    public boolean isOn(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.THURSDAY
                && date.isEqual(ofYear(date.getYear()));
    }

    public static LocalDate ofYear(int year) {
        return Easter.ofYear(year).plusDays(60);
    }
}
