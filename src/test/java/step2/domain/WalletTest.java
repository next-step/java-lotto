package step2.domain;

import org.junit.jupiter.api.Test;
import step2.domain.money.Cache;
import step2.domain.money.Money;
import step2.domain.user.Wallet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WalletTest {

    @Test
    void _10000원이_있는_지갑에서_5000원을_인출_할_수_있다() {
        // given
        Wallet expectedWallet = new Wallet(new Cache(5000));

        Cache withDrawCache = new Cache(5000);

        // when
        Money actualMoney = expectedWallet.withDraw(withDrawCache);

        // then
        assertThat(actualMoney).isEqualTo(expectedWallet.currentMoney());
    }

}