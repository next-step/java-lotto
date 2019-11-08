package lottery.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMoneyTest {

    @Test
    void 무효한_구입금액_입력테스트() {
        assertThatIllegalArgumentException().isThrownBy(()->{
            new LottoMoney(-1);
        }).withMessage("구매 금액은 0보다 커야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10, 100, 999})
    void 모자란_돈으로_구매가능한_티켓_매수확인테스트(int purchaseAmount) {
        assertThatIllegalArgumentException().isThrownBy(()->{
            new LottoMoney(purchaseAmount).getNumberOfTickets();
        }).withMessage("로또 구입 금액이 부족합니다.");
    }
}