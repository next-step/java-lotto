package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoWinnerNumberTest {

    private LottoWinnerNumber lottoWinnerNumber;

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    @DisplayName("당첨번호 생성")
    void createWinnerNumbers(int number) {
        lottoWinnerNumber = new LottoWinnerNumber("1,2,3,4,5,6",7);
        assertThat(lottoWinnerNumber.validateContainsNumber(LottoNumber.of(number))).isTrue();
    }

    @Test
    @DisplayName("당첨번호와 보너스번호 중복 체크")
    void bonusOverlapCheck() {
        assertThrows(RuntimeException.class, () -> {
            lottoWinnerNumber = new LottoWinnerNumber("1,2,3,4,5,6",6);
        });
    }
}