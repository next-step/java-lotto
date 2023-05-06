package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("보너스 번호 객체 테스트")
class BonusNumberTest {

    @DisplayName("보너스 번호와 로또 번호 한개가 일치하는지 확인 할 수 있다")
    @Test
    void matchesBonusNumber() {
        BonusNumber bonusNumber = new BonusNumber(30);

        Assertions.assertThat(bonusNumber.matchesBonusNumber(new LottoNumber(30))).isTrue();
        Assertions.assertThat(bonusNumber.matchesBonusNumber(new LottoNumber(40))).isFalse();
    }

}
