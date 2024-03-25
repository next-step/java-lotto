package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    @Test
    @DisplayName("Money를 통해 로또들을 구매할 수 있다.")
    void buy() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoStore lottoStore = new LottoStore();
        Money money = new Money(1000);

        PickedLottoNumbers pickedLottoNumbers = lottoStore.buy(money, new RandomLottoStrategy());

        assertThat(pickedLottoNumbers).containsExactly(lottoNumbers);
    }
}