package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoMoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 100, 999})
    @DisplayName("구입금액 부족")
    void lackOfMoney(int amount) {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoMoney.of(amount))
                .withMessageMatching("금액이 부족합니다. 최소 1000 원 이상의 금액을 입력해 주세요.");
    }

    @Test
    @DisplayName("로또 구입수량")
    void purchaseCount() {
        // given when
        LottoMoney lottoMoney = LottoMoney.of(2500);

        // then
        assertThat(lottoMoney.purchaseCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("수량 기반 구입금액")
    void money_fromPurchaseCount() {
        // given when
        LottoMoney lottoMoney = LottoMoney.fromCount(5);

        // then
        assertThat(lottoMoney.purchaseCount()).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("수량기반 구입금액 - 구매수량 부족")
    void lackOfPurchaseCount(int purchaseCount) {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoMoney.fromCount(purchaseCount))
                .withMessageMatching("구매 수량을 입력해 주세요.");
    }

    @Test
    @DisplayName("로또금액 비교")
    void compare() {
        // given
        LottoMoney money3000 = LottoMoney.of(3000);
        LottoMoney money3000_1 = LottoMoney.of(3000);
        LottoMoney money5000 = LottoMoney.of(5000);
        LottoMoney money2000 = LottoMoney.of(2000);

        // when then
        assertThat(money3000).isGreaterThan(money2000);
        assertThat(money3000).isLessThan(money5000);
        assertThat(money3000).isEqualByComparingTo(money3000_1);
    }

    @Test
    @DisplayName("로또금액 뺄셈")
    void subtract() {
        // given
        LottoMoney money5000 = LottoMoney.of(5000);
        LottoMoney money2000 = LottoMoney.of(2000);

        // when
        LottoMoney money3000 = money5000.subtract(money2000);

        // then
        assertThat(money3000.purchaseCount()).isEqualTo(3);
        assertThat(money3000).isEqualByComparingTo(LottoMoney.of(3000));
    }

    @Test
    @DisplayName("로또금액 뺄셈 - 감수가 더 큰 경우")
    void subtract_negative() {
        // given
        LottoMoney money5000 = LottoMoney.of(5000);
        LottoMoney money2000 = LottoMoney.of(2000);

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> money2000.subtract(money5000))
                .withMessageMatching("금액은 음수가 될 수 없습니다. 감수를 확인해 주세요.");
    }
}