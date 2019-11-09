package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.data.LottoNumbers;

public class VendingMachineTest {

    private VendingMachine vendingMachine;

    @DisplayName("buy_without_manual_lotto")
    @Test
    void buy_lotto() {
        vendingMachine = new VendingMachine(new Wallet(10000), Collections.emptyList());
        assertThat(vendingMachine.buy().getCount()).isEqualTo(10);
    }

    @DisplayName("buy_contains_manual_lotto")
    @Test
    void buy_lotto_manual() {
        assertThatThrownBy(() -> new VendingMachine(new Wallet(3999), Arrays.asList(
                new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))))
        )).isInstanceOf(RuntimeException.class);
    }
}
