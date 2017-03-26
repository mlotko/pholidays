package pl.lotko.datetime.holidays.fixed

import spock.lang.Specification

import java.time.LocalDate
import java.time.Month

class FixedHolidayAggregatorTest extends Specification {
    def "IsHoliday matches any fixed date"() {
        given:
        final FixedHoliday christmas = new FixedHoliday(25, Month.DECEMBER)
        final FixedHoliday boxing = new FixedHoliday(26, Month.DECEMBER)
        final FixedHolidayAggregator holiday = new FixedHolidayAggregator([christmas, boxing])

        when:
        def shouldMatchChristmas = holiday.isOn(LocalDate.of(2018, Month.DECEMBER, 25))
        def shouldMatchBoxing = holiday.isOn(LocalDate.of(2017, Month.DECEMBER, 26))
        def shouldMatchChristmasEve = holiday.isOn(LocalDate.of(2016, Month.DECEMBER, 24))

        then:
        shouldMatchChristmas
        shouldMatchBoxing
        !shouldMatchChristmasEve
    }

    def "No defined holidays in month imply it's not a holiday"() {
        given:
        final FixedHoliday labor = new FixedHoliday(1, Month.MAY)
        final FixedHoliday constitutionOf3rdMay = new FixedHoliday(3, Month.MAY)
        final FixedHolidayAggregator holiday = new FixedHolidayAggregator([labor, constitutionOf3rdMay])

        when:
        def shouldMatchApril = holiday.isOn(LocalDate.of(2017, Month.APRIL, 1))

        then:
        !shouldMatchApril
    }
}
