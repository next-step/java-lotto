package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WalletTest {

    @Test
    @DisplayName("Wallet 객체가 잘 생성되어야 한다.")
    void createTest() throws NoSuchFieldException, IllegalAccessException {
        Wallet wallet = new Wallet(1000);
        int moneyByReflection = getMoneyByReflection(wallet);
        assertThat(moneyByReflection).isEqualTo(1000);
    }

    @Test
    @DisplayName("Wallet 객체 생성시, 음수가 들어가면 Exception이 발생한다.")
    void walletCreateExceptionTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Wallet(-1000));
    }

    @Test
    @DisplayName("LottoTicket이 1000원 이라면, 구매가능한 Ticket이 갯수가 정상적으로 반환된다.")
    void getNumberOfBuyAvailableLottoTicketTest() {
        Wallet wallet = new Wallet(10000);
        assertThat(wallet.getNumberOfBuyAvailableLottoTicket()).isEqualTo(10);
    }

    private int getMoneyByReflection(Wallet wallet)
        throws NoSuchFieldException, IllegalAccessException {
        Field walletField = Wallet.class.getDeclaredField("money");
        walletField.setAccessible(true);
        return (int) walletField.get(wallet);
    }
}