package lotto;

import lotto.model.LottoSeller;
import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoSellerTest {

    LottoSeller lottoSeller = new LottoSeller(new Money(15000), 10);

    @DisplayName("총 로또 구매개수를 출력한다.")
    @Test
    void 총_로또_구매_갯수() {
        assertThat(lottoSeller.getNumberOfLotto()).isEqualTo(15);
    }

    @DisplayName("수동 로또 개수를 출력한다.")
    @Test
    void 수동_로또_개수() {
        assertThat(lottoSeller.getNumberofManual()).isEqualTo(10);
    }

    @DisplayName("자동 로또 개수를 출력한다.")
    @Test
    void 자동_로또_개수() {
        assertThat(lottoSeller.getNumberOfAuto()).isEqualTo(5);
    }
}
