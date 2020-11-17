package study.lotto.dispenser;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.core.Lotto;
import study.lotto.core.LottoNumber;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    public void createLottoNumbers() {
        this.lottoNumbers = Arrays.asList(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(5)
                , new LottoNumber(6));
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