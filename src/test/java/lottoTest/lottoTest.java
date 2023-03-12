package lottoTest;

import lotto.Lotto;
import lotto.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import java.util.*;
import java.util.stream.IntStream;


class Store {
    private static final int LOTTO_PRICE = 1000;

    Store() {
    }

    public ArrayList<LottoTicket> buyLotto2 (int money) {
        ArrayList<LottoTicket> lottoTickets = new ArrayList<LottoTicket>();
        Lotto lotto = new Lotto();

        for (int ii = 0; ii < (money/LOTTO_PRICE); ii++)
            lottoTickets.add(lotto.getLottoTicket3());
        return lottoTickets;
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

    @DisplayName("로또 번호는 6개다.")
    @Test
    void getTicket() {
        Lotto lotto = new Lotto();
        LottoTicket lottoTickets = lotto.getLottoTicket3();
        assertThat(lottoTickets.getLottoNumber().split(",").length).isEqualTo(6);
    }

    @DisplayName("로또 번호는 처음 선언된 번호 1~45개 중 6개이다.")
    @Test
    void getTicket2() {
        Lotto lotto = new Lotto();
        List<Integer> lottoNumber = lotto.getLottoTicket2();
        lottoNumber.forEach(i -> assertThat(i).isBetween(1, 45));
    }

    @DisplayName("로또 1장은 1000원이다. 1000원 미만은 발급 되지 않는다. 구매 금액 만큼 로또를 구매한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "100, 0", "3000, 3"})
    void buyLotto(int money, int tickets) {
        Store store = new Store();
        assertThat(store.buyLotto2(money).size()).isEqualTo(tickets);
    }

    @DisplayName("각 번호는 유니크 하다.")
    @Test
    void getTicket3() {
        Lotto lotto = new Lotto();
        LottoTicket lottoTickets = lotto.getLottoTicket3();
        String[] numbers = lottoTickets.getLottoNumber().split(",");
        Set<String> set = new HashSet<>(Arrays.asList(numbers));

        assertThat(set.size()).isEqualTo(numbers.length);
    }

}
