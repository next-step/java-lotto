package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class LottoTest {

    @RepeatedTest(100)
    void 랜덤_숫자를_잘_획득하는지_확인() {
        Lotto lotto = new Lotto();
        lotto.getLottoTicket();

        for (Integer number : lotto.getLotto()) {
            assertThat(number).isBetween(1, 45);
        }
    }
}
