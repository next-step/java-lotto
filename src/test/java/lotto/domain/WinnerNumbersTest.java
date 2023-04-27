package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinnerNumbersTest {

    @Test
    @DisplayName("보너스 볼의 번호는 로또번호에 포함되지 않은 번호여야 한다.")
    void test01() {
        LottoNumbers winnerLottoNumbers = LottoNumbers.ofTypeIntegers(1, 2, 3, 4, 5, 6);
        LottoNumber notDuplicatedBonusBall = new LottoNumber(7);
        LottoNumber duplicatedBonusBall = new LottoNumber(6);

        assertAll(
                () -> assertThatNoException()
                        .isThrownBy(() -> new WinnerNumbers(winnerLottoNumbers, notDuplicatedBonusBall)),
                () -> assertThatThrownBy(() -> new WinnerNumbers(winnerLottoNumbers, duplicatedBonusBall))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
}