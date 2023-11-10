package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.Lottos;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static step2.domain.LottoStore.lottos;
import static step2.domain.LottoStore.numberOfLotto;

public class LottoStoreTest {

    @Test
    @DisplayName("구입 금액에 따라 로또 장수를 계산할 수 있다")
    public void price_to_count() {
        BigDecimal price = BigDecimal.valueOf(14000);
        assertThat(numberOfLotto(price)).isEqualTo(14);
    }

    @Test
    @DisplayName("주어진 로또 넘버대로 로또를 발급할 수 있다")
    public void lottos_issuance() {
        List<Integer> lottoNumbers = Arrays.asList(8, 21, 23, 41, 42, 43);

        assertThat(lottos(Arrays.asList(lottoNumbers)))
            .extracting(Lottos::lottos)
            .asList()
            .first()
            .isEqualTo(new Lotto(lottoNumbers));
    }

}
