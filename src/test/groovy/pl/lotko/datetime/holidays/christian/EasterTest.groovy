package pl.lotko.datetime.holidays.christian

import spock.lang.Specification

import java.time.LocalDate
import java.time.Month

/**
 * Test cases taken from http://www.astro.uni.torun.pl/~kb/Efemerydy/EasterDates.htm
 */
class EasterTest extends Specification {
    private Easter easter

    def setup() {
        easter = new Easter()
    }

    def "Easter positive check"() {
        expect:
        easter.isOn(someEaster)

        where:
        someEaster << [
                LocalDate.of(2017, Month.APRIL, 16),
                LocalDate.of(2018, Month.APRIL, 1),
                LocalDate.of(2019, Month.APRIL, 21),
                LocalDate.of(2020, Month.APRIL, 12)
        ]
    }
}
