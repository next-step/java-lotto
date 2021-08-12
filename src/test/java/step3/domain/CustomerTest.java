package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @DisplayName("구매한 로또 리스트 확인")
    @Test
    void BuyLotto() {
        Customer customer = new Customer();
        int numOfLotto = 4;
        ArrayList<ArrayList<Integer>> issuedLottoList = customer.buyLotto(numOfLotto);
        System.out.println(issuedLottoList);
        Assertions.assertThat(issuedLottoList.size()).isEqualTo(numOfLotto);
        Assertions.assertThat(issuedLottoList.get(0).size()).isEqualTo(6);
    }
}