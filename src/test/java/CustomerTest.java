import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    @ParameterizedTest(name = "[{index}] {0}원 손님 생성")
    @CsvSource(value = {"0:0", "10000:10000"}, delimiter = ':')
    @DisplayName("Customer_생성_테스트")
    public void CUstomer_테스트(int money, int result) {
        Customer customer = new Customer(money);
        assertThat(customer.getMoney()).isEqualTo(result);
    }

    @ParameterizedTest(name = "[{index}] {0}치 로또 구매")
    @CsvSource(value = {"0:0", "14000:14"}, delimiter = ':')
    @DisplayName("Customer_로또_구매")
    public void Customer_로또_구매(int money, int count){
        Customer customer = new Customer(money);

        customer.buyLotto(new KLottoGenerator());

        assertThat(customer.getLottos()).hasSize(count);
    }
}
