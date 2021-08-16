package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.money.Cache;
import step4.domain.money.Money;
import step4.domain.user.Wallet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WalletTest {

    @DisplayName("10000원이 있는 지갑에서 5000원을 인출하면 5000원이 나온다")
    @Test
    void withDraw() {
        // given
        Wallet expectedWallet = new Wallet(new Cache(5000));
        Cache withDrawCache = new Cache(5000);
        Cache expectedRemainMoney = new Cache(5000);

        // when
        Money actualMoney = expectedWallet.withDraw(withDrawCache);

        // then
        assertThat(actualMoney).isEqualTo(expectedRemainMoney);
    }

    @DisplayName("10000원이 있는 지갑에서 7000원을 인출하면 지갑에 3000원이 있다")
    @Test
    void withDarw() {
        // given
        Wallet expectedWallet = new Wallet(new Cache(10000));
        Cache withDrawCache = new Cache(3000);
        Cache expectedRemainMoney = new Cache(7000);

        // when
        expectedWallet.withDraw(withDrawCache);

        // then
        assertThat(expectedWallet.currentMoney()).isEqualTo(expectedRemainMoney);
    }

}