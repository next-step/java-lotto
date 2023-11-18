package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyWalletTest {

    @DisplayName("입금")
    @Test
    void deposit(){
        MoneyWallet wallet = new MoneyWallet();
        assertThat(wallet.deposit(100000).balance()).isEqualTo(100000);
    }

    @DisplayName("출금 - 성공")
    @Test
    void withdrawSuccess(){
        MoneyWallet wallet = new MoneyWallet(1000);
        assertThat(wallet.withdraw(500).balance()).isEqualTo(500);
    }

    @DisplayName("출금 - 실패")
    @Test
    void withdrawFail(){
        MoneyWallet wallet = new MoneyWallet(1000);
        assertThatIllegalArgumentException().isThrownBy(()->wallet.withdraw(5000));
    }
}
