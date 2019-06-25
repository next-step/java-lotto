package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BonusNumberTest {
    @Test
    @DisplayName("인입된 번호가 보너스 번호가 맞는지 확인하여 return 한다.")
    void test() {
        //Given
        BonusNumber bonusNumber = new BonusNumber(1);
        //When
        boolean isMatchedBonusNumber = bonusNumber.isMatched(new LottoNumbers(
            Arrays.asList(
              new LottoNumber(1), 
              new LottoNumber(2), 
              new LottoNumber(3), 
              new LottoNumber(4), 
              new LottoNumber(5), 
              new LottoNumber(6)
            )
        ));
        //Then
        Assertions.assertThat(isMatchedBonusNumber).isTrue();
    }
}
