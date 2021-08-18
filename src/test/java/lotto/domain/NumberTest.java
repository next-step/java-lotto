package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {

    @DisplayName("데이터 대소 비교 - 해피케이스")
    @ParameterizedTest
    @CsvSource(value = {"2:1", "3:2", "4:3"}, delimiter = ':')
    void isBiggerThan_true(int data, int expected) {
        Number number = new Number(data);
        Number other = new Number(expected);

        assertThat(number.isBiggerThan(other)).isEqualTo(true);
    }

    @DisplayName("데이터 대소 비교 - 블루케이스")
    @ParameterizedTest
    @CsvSource(value = {"1:2", "2:2", "3:4"}, delimiter = ':')
    void isBiggerThan_false(int data, int expected) {
        Number number = new Number(data);
        Number other = new Number(expected);

        assertThat(number.isBiggerThan(other)).isEqualTo(false);
    }
}