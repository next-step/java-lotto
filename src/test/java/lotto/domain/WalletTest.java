package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class WalletTest {

    @Test
    void hasAmount() {
        assertThat(new Wallet(Money.ZERO).hasAmount(Money.ZERO)).isTrue();
        assertThat(new Wallet(Money.ZERO).hasAmount(Money.ONE)).isFalse();
        assertThat(new Wallet(Money.ONE).hasAmount(Money.ZERO)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 50, 99})
    void getUsedAmount_useZero(final int initialAmount) {
        final Wallet wallet = new Wallet(Money.wons(initialAmount));
        wallet.minusAmount(Money.ZERO);
        assertThat(wallet.getUsedAmount()).isEqualTo(Money.ZERO);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "3:1", "3:2", "10:5"}, delimiter = ':')
    void getUsedAmount_useNonZero(final int initialAmount, final int usedAmount) {
        final Wallet wallet = new Wallet(Money.wons(initialAmount));
        wallet.minusAmount(Money.wons(usedAmount));
        assertThat(wallet.getUsedAmount()).isEqualTo(Money.wons(usedAmount));
    }
}