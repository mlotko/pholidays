package pl.lotko.datetime.holidays.polish;

import pl.lotko.datetime.holidays.Holiday;
import pl.lotko.datetime.holidays.fixed.FixedHoliday;
import pl.lotko.datetime.holidays.fixed.FixedHolidayAggregator;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

public class PolishPublicHoliday implements Holiday {
    private final static FixedHoliday LABOR = new FixedHoliday(1, Month.MAY);
    private final static FixedHoliday CONSTITUTION_OF_3RD_MAY = new FixedHoliday(3, Month.MAY);
    private final static FixedHoliday INDEPENDENCE = new FixedHoliday(11, Month.NOVEMBER);

    private FixedHolidayAggregator fixed = new FixedHolidayAggregator(Arrays.asList(
            LABOR, CONSTITUTION_OF_3RD_MAY, INDEPENDENCE));

    @Override
    public boolean isOn(LocalDate date) {
        return fixed.isOn(date);
    }
}
