package lottoTest;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Store {
    private static final int LOTTO_PRICE = 1000;

    Store() {
    }

    public String buyLotto (int money) {
        if (money < LOTTO_PRICE)
            throw  new IllegalArgumentException("");
        Lotto lotto = new Lotto();
        return lotto.getLottoTicket2().toString();
    }
}


public class lottoTest {

    @DisplayName("로또는 번호는 1 - 45 까지다.")
    @Test
    void numbers() {
        Lotto lotto = new Lotto();
        int[] sample = IntStream.rangeClosed(1, 45).toArray();
        assertThat(lotto.getLottoNumber()).isEqualTo(sample);
    }

    @DisplayName("당첨 번호는 6개다.")
    @Test
    void getTicket() {
        Lotto lotto = new Lotto();
        List<Integer> ticket2 = lotto.getLottoTicket2();
  //      List<Integer> allNumber = lotto.getLottoNumber();
        assertThat(ticket2.size()).isEqualTo(6);
    }

    @DisplayName("로또 번호는 처음 선언된 번호 1~45개 중 6개이다.")
    @Test
    void getTicket2() {
        Lotto lotto = new Lotto();
        List<Integer> lottoNumber = lotto.getLottoTicket2();
        lottoNumber.forEach(i -> assertThat(i).isBetween(1, 45));
    }

    @DisplayName("당첨 번호는 6개다.")
    @Test
    void buyLotto() {
        Store store = new Store();
        assertThat(store.buyLotto(1000).length()).isGreaterThan(1);
    }
}
