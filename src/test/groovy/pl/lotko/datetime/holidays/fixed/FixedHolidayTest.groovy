package pl.lotko.datetime.holidays.fixed

import spock.lang.Specification

import java.time.LocalDate
import java.time.Month

class FixedHolidayTest extends Specification {
    def "IsOn checks if date is on the same day and month"() {
        given:
        FixedHoliday christmas = new FixedHoliday(25, Month.DECEMBER)

        when:
        def shouldBe = christmas.isOn(LocalDate.of(year, Month.DECEMBER, 25))

        then:
        shouldBe

        where:
        year << ((LocalDate.now().getYear() - 2)..(LocalDate.now().getYear() + 10)).toArray()
    }
}
