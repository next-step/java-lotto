package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Wallet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WalletTest {
    @Test
    void spend() {
        Wallet wallet = new Wallet(1000);
        int change = wallet.spend(1000, 1);

        assertThat(wallet).isEqualTo(new Wallet(0));
        assertThat(change).isEqualTo(0);
    }

    @Test
    void spendWithException() {
        assertThatThrownBy(() -> {
            new Wallet(0).spend(1000, 1);
        });
    }
}
