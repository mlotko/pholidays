package pl.lotko.datetime.holidays.polish

import spock.lang.Specification

import java.time.LocalDate
import java.time.Month

class PolishHolidayCheckerCheckerTest extends Specification {
    private PolishHolidayChecker polishHolidayChecker

    def setup() {
        polishHolidayChecker = new PolishHolidayChecker()
    }

    def "IsWorkday works for regular Monday to Friday"() {
        expect:
        polishHolidayChecker.isWorkday(LocalDate.of(2017, Month.MARCH, day))

        where:
        day << (20..24).toArray()
    }

    def "Easter Monday is holiday in Poland"() {
        expect:
        polishHolidayChecker.isHoliday(LocalDate.of(2020, Month.APRIL, 12))
    }

    def "Saturday is not working day (thank you Solidarity :-))"() {
        expect:
        !polishHolidayChecker.isWorkday(LocalDate.of(2017, Month.MARCH, 25))
    }

    def "locale returns Locale object appropriate for Poland"() {
        given:
        when:
        def locale = polishHolidayChecker.locale()

        then:
        locale.country == 'PL'
        locale.language == 'pl'
    }
}
