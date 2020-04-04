package lotto.Domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoGradeTest {

    @ParameterizedTest
    @CsvSource(value = {"3 false:5000", "4 false:50000", "5 false:1500000", "5 true:30000000", "6 false:2000000000"}, delimiter = ':')
    void lottoGradeTest(String input, String expected) {
        String[] inputs = input.split(" ");
        LottoGrade lottoGrade = LottoGrade.findGrade(Integer.parseInt(inputs[0]), Boolean.parseBoolean(input[1]));

        assertThat(lottoGrade.getPrize()).isEqualTo(Integer.parseInt(expected));
    }

    @Test
    void findGradeExceptionTest() {
        assertThatExceptionOfType(IllegalStateException.class).isThrownBy(() -> {
            LottoGrade.findGrade(0);
        });
    }
}
