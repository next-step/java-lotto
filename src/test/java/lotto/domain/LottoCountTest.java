package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoCountTest {
    private LottoCount lottoCount;

    @BeforeEach
    void setUp() {
        lottoCount = LottoCount.of(3);
    }

    @DisplayName("로또 1미만의 수 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(ints = {200, -500, 900})
    void notValidIssueCountTest(int price) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoCount.purchaseCount(price));
    }

    @DisplayName("입력한 금액에 따른 로또 갯수 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 13500, 30000})
    void divideMoneyToLottoPriceTest(int price) {
        assertThat(lottoCount.calculateCount(price))
                .isEqualTo((price / LottoStore.LOTTO_PRICE) - lottoCount.getCount());
    }
}