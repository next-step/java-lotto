package lottosecond.domain.lotto;

import lottosecond.testutil.TestShuffler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosMakerTest {

    @Test
    @DisplayName("로또 금액이 1000의 배수여야 합니다.")
    void illegalLottoBuyMoney() {
        // given
        // when
        // then
        assertThatThrownBy(() -> LottosMaker.makeLottoList(new TestShuffler(), 1200))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구매 금액은 1000의 배수여야 합니다.");

    }

}