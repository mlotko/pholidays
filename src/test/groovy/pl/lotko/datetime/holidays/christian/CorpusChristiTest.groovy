package pl.lotko.datetime.holidays.christian

import spock.lang.Specification

import java.time.LocalDate
import java.time.Month

class CorpusChristiTest extends Specification {
    private CorpusChristi corpusChristi

    def setup() {
        corpusChristi = new CorpusChristi()
    }

    def "Corpus Christi positive check"() {
        expect:
        corpusChristi.isOn(someEaster)

        where:
        someEaster << [
                LocalDate.of(2017, Month.JUNE, 15),
                LocalDate.of(2018, Month.MAY, 31),
                LocalDate.of(2019, Month.JUNE, 20),
                LocalDate.of(2020, Month.JUNE, 11)
        ]
    }
}
