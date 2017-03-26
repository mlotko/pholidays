package pl.lotko.datetime.holidays.polish

import spock.lang.Specification

import java.time.LocalDate
import java.time.Month

class PolishPublicHolidayTest extends Specification {
    PolishPublicHoliday polishPublicHoliday

    def setup() {
        polishPublicHoliday = new PolishPublicHoliday()
    }

    def "3rd May is Polish holida"() {
        expect:
        polishPublicHoliday.isOn(LocalDate.of(year, Month.MAY, 3))

        where:
        year << ((LocalDate.now().getYear() - 2)..(LocalDate.now().getYear() + 10)).toArray()
    }
}
