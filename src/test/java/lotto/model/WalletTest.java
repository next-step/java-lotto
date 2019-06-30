package lotto.model;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.model.LottoTest.ofLotto;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class WalletTest {

    @DisplayName("잔액 부족으로 로또 구매 실패")
    @Test
    void buyLottoFail() {
        Wallet wallet = new Wallet(Money.won(500));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoStore.buy(wallet,
                        () -> List.of(ofLotto(1, 2, 3, 4, 5, 6))));
    }
}