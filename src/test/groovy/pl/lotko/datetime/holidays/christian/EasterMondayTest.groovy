package pl.lotko.datetime.holidays.christian

import spock.lang.Specification

import java.time.LocalDate
import java.time.Month

class EasterMondayTest extends Specification {
    private EasterMonday easterMonday

    def setup() {
        easterMonday = new EasterMonday()
    }

    def "Easter Monday positive check"() {
        expect:
        easterMonday.isOn(someEaster)

        where:
        someEaster << [
                LocalDate.of(2017, Month.APRIL, 17),
                LocalDate.of(2018, Month.APRIL, 2),
                LocalDate.of(2019, Month.APRIL, 22),
                LocalDate.of(2020, Month.APRIL, 13)
        ]
    }
}
