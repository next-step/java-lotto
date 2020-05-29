package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoStoreTest {

    private static final int PRICE_PER_ONE =  1000;

    @DisplayName("지불금액만큼 로또가 구매된다.")
    @ParameterizedTest
    @ValueSource(ints = {10000, 1500, 2000})
    public void buyTest(int price) {
        List<Lotto> lottos = LottoStore.buy(price);
        final int count = (int) Math.floor(price / PRICE_PER_ONE);

        assertThat(lottos.size()).isEqualTo(count);
    }

    @DisplayName("로또금액은 1000원 미만으로 입력될 경우 IllegalArgument 예외가 발생한다.")
    @Test
    public void validateBuyTest() {
        int price = 500;

        assertThatThrownBy(() -> {
            List<Lotto> lottos = LottoStore.buy(price);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
