package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.money.Cache;
import step4.domain.money.Money;
import step4.domain.user.Wallet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WalletTest {

    @Test
    void _10000원이_있는_지갑에서_5000원을_인출하면_5000원이_나온다() {
        // given
        Wallet expectedWallet = new Wallet(new Cache(5000));
        Cache withDrawCache = new Cache(5000);
        Cache expectedRemainMoney = new Cache(5000);

        // when
        Money actualMoney = expectedWallet.withDraw(withDrawCache);

        // then
        assertThat(actualMoney).isEqualTo(expectedRemainMoney);
    }

    @DisplayName("10000원이_있는_지갑에서_7000원을_인출하면_지갑에_3000원이_있다")
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