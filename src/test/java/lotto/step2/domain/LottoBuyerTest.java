package lotto.step2.domain;

import lotto.step2.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoBuyerTest {

    @DisplayName("최소 구매가격인 1000원을 안지켰을 경우 에러처리")
    @ParameterizedTest
    @ValueSource(ints = {900, 500, 999, 700})
    void lottoPurchaseUnderMin(int lottoPurchaseAmount) {
        assertThatThrownBy(() -> {
            LottoBuyer.of(lottoPurchaseAmount);
        }).isInstanceOf(LottoException.class)
                .hasMessage("로또의 최소 구매금액은 1000원입니다.");
    }

    @DisplayName("1000원 단위로 구매를 하지 않았을 경우 에러처리")
    @ParameterizedTest
    @ValueSource(ints = {1001, 2002, 3010, 4099})
    void lottoPurchaseAmountUnit(int lottoPurchaseAmount) {
        assertThatThrownBy(() -> {
            LottoBuyer.of(lottoPurchaseAmount);
        }).isInstanceOf(LottoException.class)
                .hasMessage("구매금액은 1000원 단위로 입력해주세요.");
    }

    @DisplayName("로또 구입금액 확인")
    @ParameterizedTest
    @CsvSource(value = {"14000:14", "20000:20", "30000:30"}, delimiter = ':')
    void LottoQuantity(int lottoPurchaseAmount, int lottoQuantity) {
        LottoBuyer lottoBuyer = LottoBuyer.of(lottoPurchaseAmount);
        assertThat(lottoBuyer.getLottoQuantity()).isEqualTo(lottoQuantity);
    }
}
