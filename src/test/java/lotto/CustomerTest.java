package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class CustomerTest {

    @ParameterizedTest(name = "[{index}] {0}원 손님 생성")
    @CsvSource(value = {"0:0", "10000:10000"}, delimiter = ':')
    @DisplayName("Customer_생성_테스트")
    public void CUstomer_테스트(int money, int result) {
        Customer customer = new Customer(money);
        assertThat(customer.getMoney()).isEqualTo(result);
    }

    @ParameterizedTest(name = "[{index}] {0}치 로또 구매")
    @CsvSource(value = {"10000:10", "14000:14"}, delimiter = ':')
    @DisplayName("Customer_로또_구매")
    public void Customer_로또_구매(int money, int count) {
        Customer customer = new Customer(money);
        customer.buyLotto(0, new ArrayList<>());
        assertThat(customer.getAutoLotto()).hasSize(count);
    }

    @Test
    @DisplayName("Buy_Lotto_Manullay")
    public void Buy_Lotto_Manullay() {
        //given
        Customer customer = new Customer(3000);

        List<Set<Integer>> numberList = new ArrayList<>();
        numberList.add(Set.of(1, 2, 3, 4, 5, 6));
        numberList.add(Set.of(10, 11, 12, 13, 14, 15));

        customer.buyLotto(2, numberList);
        //when
        assertThat(customer.getManualLotto()).hasSize(2);
        //then
    }

    @Test
    @DisplayName("validate_buy_lotto_manually")
    public void validate_buy_lotto_manually() {
        Customer customer = new Customer(500);
        List<Set<Integer>> numberList = new ArrayList<>();
        numberList.add(Set.of(1, 2, 3, 4, 5, 6));
        assertThatIllegalStateException().isThrownBy(() -> {
            customer.buyLotto(1, numberList);
        });
    }

    @Test
    @DisplayName("validate_buy_lotto_manually2")
    public void validate_buy_lotto_manually2() {
        Customer customer = new Customer(3000);
        List<Set<Integer>> numberList = new ArrayList<>();
        numberList.add(Set.of(1, 2, 3, 4, 5, 6));
        assertThatIllegalArgumentException().isThrownBy(() -> {
            customer.buyLotto(2, numberList);
        });
    }

    @Test
    @DisplayName("validate_lotto_money_auto")
    public void validate_lotto_money() {
        Customer customer = new Customer(500);
        assertThatIllegalStateException().isThrownBy(() -> {
            customer.buyLotto(0, new ArrayList<>());
        });
    }
}
