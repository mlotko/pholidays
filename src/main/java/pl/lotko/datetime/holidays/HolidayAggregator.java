package pl.lotko.datetime.holidays;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class HolidayAggregator implements Holiday {
    private final List<Holiday> holidays;

    @Override
    public boolean isOn(LocalDate date) {
        return holidays.stream().anyMatch(holiday -> holiday.isOn(date));
    }
}
