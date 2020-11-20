package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setup() {
        lottoGenerator = new TesterLottoGenerator();
    }

    @DisplayName("Lotto 생성 테스트")
    @Test
    void of() {
        assertThat(Lotto.of(lottoGenerator))
                .isEqualToComparingOnlyGivenFields(Lotto.of(lottoGenerator));
    }


    @DisplayName("Lotto contains 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "1, true",
            "6, true",
            "7, false"
    })
    void contains(int num, boolean expectedResult) {
        // 1,2,3,4,5,6
        Lotto lotto = Lotto.of(lottoGenerator);

        assertThat(lotto.contains(LottoNumber.of(num))).isEqualTo(expectedResult);
    }
}
