package pl.lotko.datetime.holidays.polish;

import pl.lotko.datetime.holidays.LocalHolidayChecker;
import pl.lotko.datetime.holidays.christian.CatholicHoliday;

import javax.inject.Named;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Locale;

@Named
public class PolishHolidayChecker implements LocalHolidayChecker {

    private static final Locale POLAND = new Locale("pl", "PL");

    private final CatholicHoliday catholicHoliday = new CatholicHoliday();
    private final PolishPublicHoliday polishPublicHoliday = new PolishPublicHoliday();

    @Override
    public Locale locale() {
        return POLAND;
    }

    @Override
    public boolean isWorkday(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek != DayOfWeek.SATURDAY
                && dayOfWeek != DayOfWeek.SUNDAY
                && !isHoliday(date);
    }

    @Override
    public boolean isHoliday(LocalDate date) {
        return catholicHoliday.isOn(date) || polishPublicHoliday.isOn(date);
    }
}
