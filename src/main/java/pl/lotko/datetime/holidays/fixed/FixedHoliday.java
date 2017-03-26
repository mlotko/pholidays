package pl.lotko.datetime.holidays.fixed;

import lombok.Value;
import pl.lotko.datetime.holidays.Holiday;

import java.time.LocalDate;
import java.time.Month;

@Value
public class FixedHoliday implements Holiday {
    private final int dayOfMonth;
    private final Month month;

    @Override
    public boolean isOn(LocalDate date) {
        return date.getMonth() == this.month && date.getDayOfMonth() == this.dayOfMonth;
    }
}
