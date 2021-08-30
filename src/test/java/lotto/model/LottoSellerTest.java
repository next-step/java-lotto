package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoSellerTest {
    @Test
    @DisplayName("돈의 액수만큼 Lotto 를 리턴한다")
    public void sell() {
        LottoSeller seller = new LottoSeller(new RandomLottoNumbersGenerator());
        Lottos lottos = seller.sell(new Money(2000), new ManualNumbers(Collections.emptyList()));
        assertThat(lottos.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("수동 로또숫자가 입력되면 해당 넘버를 포함한 Lotto를 리턴한다")
    public void sellManual() {
        LottoSeller seller = new LottoSeller(new RandomLottoNumbersGenerator());
        Lottos lottos = seller.sell(new Money(5000), new ManualNumbers(Arrays.asList(Arrays.asList(1, 2 ,3, 4, 5, 6))));
        assertThat(lottos.size()).isEqualTo(5);
    }
}