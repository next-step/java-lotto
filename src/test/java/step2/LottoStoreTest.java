package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.LottoNumbers;
import step2.domain.Lottos;
import step2.exception.InvalidPriceUnitException;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static step2.domain.LottoStore.lottos;
import static step2.domain.LottoStore.numberOfLotto;

public class LottoStoreTest {

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닐 경우 에러 발생한다")
    public void invalid_price_unit() {
        assertThatExceptionOfType(InvalidPriceUnitException.class)
            .isThrownBy(() -> {
                numberOfLotto(BigDecimal.valueOf(1200));
            }).withMessageMatching("구매 금액은 1000원 단위여야합니다");
    }

    @Test
    @DisplayName("구입 금액에 따라 로또 장수를 계산할 수 있다")
    public void price_to_count() {
        BigDecimal price = BigDecimal.valueOf(14000);
        assertThat(numberOfLotto(price)).isEqualTo(14);
    }

    @Test
    @DisplayName("주어진 로또 넘버대로 로또를 발급할 수 있다")
    public void lottos_issuance() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(8, 21, 23, 41, 42, 43));

        assertThat(lottos(Arrays.asList(lottoNumbers)))
            .extracting(Lottos::lottos)
            .asList()
            .first()
            .isEqualTo(new Lotto(lottoNumbers));
    }

}
