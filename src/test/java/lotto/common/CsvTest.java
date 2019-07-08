package lotto.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CsvTest {

    @Test
    @DisplayName("CSV 사이즈를 확인한다")
    void checkCsvSize() {
        Csv csv = Csv.ofString("a,b,c");
        assertThat(csv.getCsv().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("CSV 토큰 문자열을 확인한다")
    void checkCsvValue() {
        Csv csv = Csv.ofString("a,b,c");
        assertThat(csv.getCsv().get(0)).isEqualTo("a");
        assertThat(csv.getCsv().get(1)).isEqualTo("b");
        assertThat(csv.getCsv().get(2)).isEqualTo("c");
    }

    @Test
    @DisplayName("CSV 토큰 정수값을 확인한다")
    void checkCsvLongValue() {
        Csv csv = Csv.ofString("1,2,3");
        assertThat(csv.getCsvLong().get(0)).isEqualTo(1L);
        assertThat(csv.getCsvLong().get(1)).isEqualTo(2L);
        assertThat(csv.getCsvLong().get(2)).isEqualTo(3L);
    }

    @Test
    @DisplayName("CSV 문자열을 확인한다")
    void checkString() {
        Csv csv = Csv.ofString("1,2,3");
        assertThat(csv.getString()).isEqualTo("1,2,3");
    }

    @Test
    @DisplayName("문자열 값이 없는경우 예외를 확인한다")
    void checkExceptioni() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Csv.ofString(null);
                }).withMessageMatching("String is empty");
    }
}
