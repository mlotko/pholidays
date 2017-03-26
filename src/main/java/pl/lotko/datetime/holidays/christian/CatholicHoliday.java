package pl.lotko.datetime.holidays.christian;

import pl.lotko.datetime.holidays.Holiday;
import pl.lotko.datetime.holidays.HolidayAggregator;
import pl.lotko.datetime.holidays.fixed.FixedHoliday;
import pl.lotko.datetime.holidays.fixed.FixedHolidayAggregator;

import javax.inject.Named;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@Named
public class CatholicHoliday implements Holiday {
    private final static FixedHoliday NEW_YEAR = new FixedHoliday(1, Month.JANUARY);
    private final static FixedHoliday EPIPHANY = new FixedHoliday(6, Month.JANUARY);
    private final static FixedHoliday ASSUMPTION = new FixedHoliday(15, Month.AUGUST);
    private final static FixedHoliday ALL_SAINTS = new FixedHoliday(1, Month.NOVEMBER);
    private final static FixedHoliday CHRISTMAS = new FixedHoliday(25, Month.DECEMBER);
    private final static FixedHoliday BOXING = new FixedHoliday(26, Month.DECEMBER);

    private final FixedHolidayAggregator fixedCatholicHoliday = new FixedHolidayAggregator(Arrays.asList(
            NEW_YEAR, EPIPHANY, ASSUMPTION, ALL_SAINTS, CHRISTMAS, BOXING
    ));
    private final HolidayAggregator nonFixed = new HolidayAggregator(Arrays.asList(
            new Easter(), new EasterMonday(), new CorpusChristi()
    ));

    @Override
    public boolean isOn(LocalDate date) {
        return fixedCatholicHoliday.isOn(date) || nonFixed.isOn(date);
    }
}
