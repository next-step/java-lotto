package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WalletTest {
    private Wallet wallet;

    @DisplayName("input parameter validation")
    @Test
    void validate() {
        assertThatThrownBy(() -> new Wallet(999)).isInstanceOf(IllegalArgumentException.class);
        assertThat(new Wallet(1000)).isInstanceOf(Wallet.class);
    }

    @Test
    void isBuyAvailable() {
        int budget = 1999;
        wallet = new Wallet(budget);
        assertThat(wallet.isEnoughBudget()).isTrue();
        assertThat(wallet.isEnoughBudget()).isFalse();
    }
}
