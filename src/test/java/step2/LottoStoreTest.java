package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static step2.domain.LottoStore.priceToNumberOfLotto;

public class LottoStoreTest {

    @Test
    @DisplayName("구입 금액에 따라 로또 장수를 계산할 수 있다")
    public void price_to_count() {
        BigDecimal price = BigDecimal.valueOf(14000);
        assertThat(priceToNumberOfLotto(price)).isEqualTo(14);
    }

}
