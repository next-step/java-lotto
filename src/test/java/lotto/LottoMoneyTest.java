package lotto;

import lotto.entity.LottoMoney;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMoneyTest {
    private LottoMoney lottoMoney;

    @BeforeEach
    void setUp() {
        lottoMoney = new LottoMoney();
    }

    @Test
    @DisplayName("금액에 따른 로또 갯수를 확인")
    void 로또_발행_장수() {
        int totalAmount = 14000;
        assertThat(lottoMoney.makeLottoGamePapers(totalAmount)).isEqualTo(14);
    }
}
