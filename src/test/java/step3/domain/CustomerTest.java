package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @DisplayName("구매한 로또 리스트 확인")
    @Test
    void BuyLotto() {
        Customer customer = new Customer();
        int numOfLotto = 4;
        ArrayList<ArrayList<Integer>> issuedLottoList = customer.buyLotto(numOfLotto);
        System.out.println(issuedLottoList);
        assertThat(issuedLottoList.size()).isEqualTo(numOfLotto);
        assertThat(issuedLottoList.get(0).size()).isEqualTo(6);
    }

    @DisplayName("당첨 번호와 로또 번호 비교 결과 확인")
    @Test
    void compare() {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        Customer customer = new Customer();
        customer.getMatchedNumber(list1, list2,4);

    }
}