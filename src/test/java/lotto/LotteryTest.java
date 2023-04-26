package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {

    @Test
    @DisplayName("입력받은 구매 금액을 로또 가격으로 나눈 금액 만큼 로또를 생성한다.")
    void generate_lottery() {
        // given
        int inputMoney = 14000;

        // when
        Lottery lotto = new Lottery(inputMoney);

        // then
        int lotteryCount = lotto.getCount();
        assertThat(lotteryCount).isEqualTo(14);
    }
}
