package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoMoneyTest {

    private LottoMoney lottoMoney;

    @Test
    @DisplayName("돈이 1000원 이하일 때")
    void validateMoney() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoMoney(500);
        });
    }

    @Test
    @DisplayName("지불한 돈에 따른 코인 개수 확인")
    void buyLotto() {
        lottoMoney = new LottoMoney(15000);
        assertThat(lottoMoney.getCoin()).isEqualTo(15);
    }

    @Test
    @DisplayName("거스름돈 확인")
    void remainMoney() {
        lottoMoney = new LottoMoney(15500);
        assertThat(lottoMoney.getRemainMoney()).isEqualTo(500);
    }
}
