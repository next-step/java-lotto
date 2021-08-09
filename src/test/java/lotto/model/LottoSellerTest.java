package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoSellerTest {
    @Test
    @DisplayName("돈의 액수만큼 Lotto 를 리턴한다")
    public void sell() {
        LottoSeller seller = new LottoSeller(new RandomLottoNumbersGenerator());
        Lottos lottos = seller.sell(new Money(2000));
        assertThat(lottos.size()).isEqualTo(2);
    }
}