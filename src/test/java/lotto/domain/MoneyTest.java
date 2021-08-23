package lotto.domain;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("NonAsciiCharacters")
class MoneyTest {

    @DisplayName("객체생성")
    @Test
    void create() {
        assertThat(new Money(2000)).isInstanceOf(Money.class);
    }

    @DisplayName("0원 이하일 경우 에러 발생")
    @Test
    void create_0원_이하일_경우_에러() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Money(-1000);
        }).withMessageMatching("금액이 음수입니다.");
    }

    @DisplayName("잔액 이상으로 구입할 경우 에러 발생")
    @Test
    void spendMoneyToBuyLotto_잔액_이상으로_구입할_경우_에러() {
        Money money = new Money(5000);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            money.spendMoneyToBuyLotto(6);
        }).withMessageMatching("잔액이 부족합니다.");
    }

    @DisplayName("잔액에 맞게 구입할 경우 객체생성")
    @Test
    void spendMoneyToBuyLotto_잔액에_맞게_구입할_경우_객체생성() {
        Money money = new Money(6000);
        assertThat(money.spendMoneyToBuyLotto(5)).isEqualTo(new Money(1000));
    }

    @DisplayName("구입 가능한 복권의 갯수를 반환")
    @Test
    void getNumberOfLottoAvailableForPurchases_구입_가능한_복권의_갯수_반환() {
        Money money = new Money(10000);
        assertThat(money.getNumberOfLottoAvailableForPurchases()).isEqualTo(10);
    }

}
