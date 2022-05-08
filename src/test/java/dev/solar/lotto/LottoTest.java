package dev.solar.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
    }

    @DisplayName("로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급한다.")
    @CsvSource(value = {"14000:14", "13500:13", "0:0"}, delimiter = ':')
    @ParameterizedTest
    void issue_lotto_equal_purchase_amount(int purchaseAmount, int amountOfLotto) {
        assertThat(lotto.buyLotto(purchaseAmount)).isEqualTo(amountOfLotto);
    }
}
