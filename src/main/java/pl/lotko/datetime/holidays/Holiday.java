package pl.lotko.datetime.holidays;

import java.time.LocalDate;

public interface Holiday {
    boolean isOn(LocalDate date);
}
