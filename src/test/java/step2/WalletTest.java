package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WalletTest {

    @Test
    void _10000원이_있는_지갑에서_5000원을_인출_할_수_있다() {
        // given
        int givenMoney = 10000;
        int expectedWithDrawnMoney = 5000;
        Wallet wallet = Wallet.save(givenMoney);

        // when
        Integer money = wallet.withDraw(5000);

        // then
        assertThat(money).isEqualTo(expectedWithDrawnMoney);
    }

}