package pl.lotko.datetime.holidays.christian

import spock.lang.Specification

import java.time.LocalDate
import java.time.Month

class CatholicHolidayTest extends Specification {
    CatholicHoliday catholicHoliday

    def setup() {
        catholicHoliday = new CatholicHoliday()
    }

    def "fixed catholic holiday"() {
        expect:
        catholicHoliday.isOn(LocalDate.of(2031, Month.JANUARY, 6))
    }

    def "Corpus Christi is moving holiday"() {
        expect:
        catholicHoliday.isOn(LocalDate.of(2023, Month.JUNE, 8))
    }
}
