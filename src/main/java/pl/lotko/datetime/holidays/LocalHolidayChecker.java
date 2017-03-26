package pl.lotko.datetime.holidays;

import java.time.LocalDate;
import java.util.Locale;

public interface LocalHolidayChecker {
    /**
     * Returns region where holiday checker is applicable.
     * @return region where holiday checker is applicable.
     */
    Locale locale();

    /**
     * Checks whether a date is a holiday.
     * This include both holy day of week (e.g. Sunday) and special holidays (e.g. Christmas).
     * @param date date to be checked
     * @return true if it's holiday, false if it's not (including e.g. Saturdays - neither holiday nor workday).
     */
    boolean isHoliday(LocalDate date);

    boolean isWorkday(LocalDate date);

    default LocalDate advanceUntilWorkday(LocalDate date) {
        LocalDate workDay = date;
        while (!isWorkday(workDay)) {
            workDay = workDay.plusDays(1);
        }
        return workDay;
    }
}
