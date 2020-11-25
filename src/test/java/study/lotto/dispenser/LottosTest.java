package study.lotto.dispenser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.lotto.core.Lotto;
import study.lotto.core.LottoNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private Set<LottoNumber> lottoNumbers;

    @BeforeEach
    public void createLottoNumbers() {
        this.lottoNumbers = new HashSet<>(Arrays.asList(LottoNumber.of(1)
                , LottoNumber.of(2)
                , LottoNumber.of(3)
                , LottoNumber.of(4)
                , LottoNumber.of(5)
                , LottoNumber.of(6)));
    }

    @Test
    void test_getTotalCount() {
        // Given
        Lotto lotto = new Lotto(lottoNumbers);

        Lottos lottos
                = new Lottos(Arrays.asList(new Lotto(lottoNumbers), new Lotto(lottoNumbers)));

        // When
        int totalCount = lottos.getTotalCount();

        // Then
        assertThat(totalCount).isEqualTo(2);
    }

    @Test
    void test_getTotalPurchaseAmount() {
        // Given
        Lotto lotto = new Lotto(lottoNumbers);

        Lottos lottos
                = new Lottos(Arrays.asList(new Lotto(lottoNumbers), new Lotto(lottoNumbers)));

        // When
        int totalPurchaseAmount = lottos.getTotalPurchaseAmount();

        // Then
        assertThat(totalPurchaseAmount).isEqualTo(2 * Lotto.PRICE_PER_LOTTO);
    }


}