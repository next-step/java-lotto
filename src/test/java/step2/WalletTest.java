package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WalletTest {

    @Test
    void _10000원이_있는_지갑에서_5000원을_인출_할_수_있다() {
        // given
        Wallet expectedWallet = Wallet.save(5000);

        int givenMoney = 10000;
        int withDrawMoney = 5000;
        Wallet wallet = Wallet.save(givenMoney);

        // when
        Wallet actualMoney = wallet.withDraw(withDrawMoney);

        // then
        assertThat(actualMoney).isEqualTo(expectedWallet);
    }

}