package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WalletTest {

    @Test
    @DisplayName("지갑에 보유 금액을 저장할 수 있다.")
    void saveMoneyTest() {

        // given
        Money money = new Money(1_000);

        // when
        Wallet wallet = new Wallet(money);

        // then
        assertThat(wallet.money()).isEqualTo(money);
    }

    @Test
    @DisplayName("보유금액을 가지고 로또를 최대한 구매할 수 있다.")
    void purchaseLottoTest() {

        // given
        Money money = new Money(10_000);
        Wallet wallet = new Wallet(money);
        Money expected = new Money(0);

        // when
        Wallet result = wallet.purchaseLotto();

        // then
        assertThat(result.money()).isEqualTo(expected);
        assertThat(result.lottosCount()).isEqualTo(10);
    }

}