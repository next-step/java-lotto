package lotto.domain;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class LottoWinnerNumberTest {

    private LottoWinnerNumber lottoWinnerNumber;

    @BeforeEach
    void setUp() {
        lottoWinnerNumber = new LottoWinnerNumber();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    @DisplayName("당첨번호 생성")
    void createWinnerNumbers(int number) {
        lottoWinnerNumber.splitStringNumbers("1,2,3,4,5,6");
        assertThat(lottoWinnerNumber.validateContainsNumber(LottoNumber.of(number))).isTrue();
    }

    @Test
    @DisplayName("당첨 번호 입력 값 길이를 검사")
    void validateInputNumberLength() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoWinnerNumber.splitStringNumbers("1,2,3,4,5,6,7");
        });
    }

    @Test
    @DisplayName("당첨번호와 보너스번호 중복 체크")
    void bonusOverlapCheck() {
        assertThrows(RuntimeException.class, () -> {
            lottoWinnerNumber = new LottoWinnerNumber("1,2,3,4,5,6",6);
        });
    }
}