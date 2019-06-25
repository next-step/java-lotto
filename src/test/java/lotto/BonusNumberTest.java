package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BonusNumberTest {
    @Test
    @DisplayName("BonusNumber 가 들어있는 LottoNumber 를 반환한다.")
    void test() {
        //Given
        BonusNumber bonusNumber = new BonusNumber(1);
        //When
        LottoNumber lottoBonusNumber = bonusNumber.getLottoNumber();
        //Then
        Assertions.assertThat(lottoBonusNumber.isEqualsTo(1)).isTrue();
    }
}
