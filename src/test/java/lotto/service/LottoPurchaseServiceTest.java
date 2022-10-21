package lotto.service;

import lotto.domain.Amount;
import lotto.domain.money.Money;
import lotto.domain.lotto.Lotto;
import lotto.domain.lottonumber.LottoNumberSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPurchaseServiceTest {

    private LottoPurchaseService lottoPurchaseService;

    @BeforeEach
    void setUp() {
        this.lottoPurchaseService = new LottoPurchaseService();
    }

    @DisplayName("Money를 넘기면 1000원짜리 로또를 몇개 구입했는지 반환한다.")
    @Test
    void lotto_purchase_count() {
        assertThat(lottoPurchaseService.purchaseNumber(new Money(3000))).isEqualTo(new Amount(3));
    }

    @ParameterizedTest(name = "Amount를 넘기면 Amount수 만큼 Lotto를 구매한다.")
    @ValueSource(ints = {1, 333, 666, 9999})
    void purchase_lotto_amount(int amount) {
        assertThat(lottoPurchaseService.purchaseLotto(new Amount(amount)).size()).isEqualTo(amount);
    }

    @DisplayName("로또 번호로 로또를 구매한다.")
    @Test
    void purchase_lotto_lottonumberset() {
        LottoNumberSet lottoNumbers = new LottoNumberSet(1, 2, 3, 4, 5, 6);
        String actual = lottoPurchaseService.purchaseLotto(Arrays.asList(lottoNumbers)).get(0).toString();

        assertThat(actual).isEqualTo(new Lotto(1, 2, 3, 4, 5, 6).toString());
    }
}
