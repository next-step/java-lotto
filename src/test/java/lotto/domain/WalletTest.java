package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WalletTest {

    @Test
    @DisplayName("지갑에 보유 금액을 저장할 수 있다.")
    void saveMoneyTest() {

        // given
        int money = 10_000;

        // when
        Wallet wallet = new Wallet(money);

        // then
        assertThat(wallet.money()).isEqualTo(money);
    }

}