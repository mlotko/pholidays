package pl.lotko.datetime.holidays.fixed;

import pl.lotko.datetime.holidays.Holiday;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class FixedHolidayAggregator implements Holiday {
    private final Map<Month, Set<FixedHoliday>> fixedDates;

    public FixedHolidayAggregator(Collection<FixedHoliday> fixedHolidays) {
        this.fixedDates = new EnumMap<>(Month.class);
        fixedHolidays.forEach(
                fixedHoliday -> this.fixedDates.computeIfAbsent(fixedHoliday.getMonth(), s -> new HashSet<>()).add(fixedHoliday));
    }

    @Override
    public boolean isOn(LocalDate date) {
        final Set<FixedHoliday> datesInMonth = this.fixedDates.get(date.getMonth());
        return datesInMonth != null
                && datesInMonth.stream().anyMatch(
                fixedHoliday -> fixedHoliday.isOn(date));
    }
}
