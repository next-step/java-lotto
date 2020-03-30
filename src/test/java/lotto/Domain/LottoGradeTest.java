package lotto.Domain;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGradeTest {


    @ParameterizedTest
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    void lottoGradeTest(String input, String expected) {
        LottoGrade lottoGrade = LottoGrade.findGrade(Integer.parseInt(input));

        assertThat(lottoGrade.getPrice()).isEqualTo(Integer.parseInt(expected));
    }
}
