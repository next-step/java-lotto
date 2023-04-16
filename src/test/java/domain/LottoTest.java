package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    private final String NUMBER_DELIMITER = ", ";

    Lotto lotto;

    @Test
    @DisplayName("로또 생성 테스트")
    void createLottoTest() {
        LottoNumbers lottoNumbers = new LottoNumbers()
                .from(Arrays.asList(1, 2, 3, 4, 5, 6));
       lotto = new Lotto(lottoNumbers);

        assertThat(lotto.getLottoNumbers()).isEqualTo(lottoNumbers);
    }

    @ParameterizedTest
    @DisplayName("당첨번호와 로또 번호 일치 개수 계산 기능 - 1개부터 5개까지")
    @CsvSource(value = {
            "1, 2, 3, 4, 5, 6:13, 8, 9, 10, 11, 12:0",
            "1, 2, 3, 4, 5, 6:1, 8, 9, 10, 11, 12:1",
            "1, 2, 3, 4, 5, 6:1, 2, 9, 10, 11, 12:2",
            "1, 2, 3, 4, 5, 6:1, 2, 3, 10, 11, 12:3",
            "1, 2, 3, 4, 5, 6:1, 2, 3, 4, 11, 12:4",
            "1, 2, 3, 4, 5, 6:1, 2, 3, 4, 5, 12:5",
            "1, 2, 3, 4, 5, 6:1, 2, 3, 4, 5, 6:6",
        }, delimiter = ':')
    void matchLottoNumbersDynamic(String winning, String test, int match) {
        int bonusNumber = 7;
        LottoNumbers winningNumbers = new LottoNumbers()
                .createLottoNumbers(winning.split(NUMBER_DELIMITER));

        LottoNumbers testNumbers = new LottoNumbers()
                .createLottoNumbers(test.split(NUMBER_DELIMITER));
        Lotto testLotto = new Lotto(testNumbers);
        if(match >= 3) {
            assertThat(testLotto.matchLottoNumbers(winningNumbers, bonusNumber)
                    .getMatchNumber()).isEqualTo(match);
        } else {
            assertThat(testLotto.matchLottoNumbers(winningNumbers, bonusNumber)).isNull();
        }
    }
}
