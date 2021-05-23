package lotto.shop;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.lotto.Answer;
import lotto.lotto.LottoNumber;
import lotto.error.ErrorMessage;
import lotto.lotto.Lotto;
import lotto.lotto.LottoTicket;
import lotto.lotto.MatchedAnswer;

public class ShopTest {
    Shop shop;

    @BeforeEach
    void setup() {
        shop = new Shop();
    }

    @Test
    @DisplayName("구매 금액에 맞는 로또 구입 횟수")
    void buyLottoCount() {
        //given
        Money money = new Money(10000);
        //when
        int amount = shop.buyLotto(money);
        //then
        assertThat(amount).isEqualTo(10);
    }

    @Test
    @DisplayName("구매 금액이 부족한 경우")
    void buyFailed() {
        //given
        Money money = new Money(900);
        //when
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> shop.buyLotto(money)).withMessageContaining(ErrorMessage.NOT_ENOUGH_MONEY);
        //then
    }

    @Test
    @DisplayName("구매한 만큼 로또 구입")
    void butLotto() {
        //given
        Money money = new Money(10000);
        //when
        int lottoCount = shop.buyLotto(money);
        //then
        assertThat(lottoCount).isEqualTo(10);
    }

    @Test
    @DisplayName("로또 오토")
    void makeLottoAuto() {
        //given
        Money money = new Money(10000);
        //when
        int lottoCount = shop.buyLotto(money);
        LottoTicket lottoTicket = shop.selectAuto(lottoCount);
        //then
        assertThat(lottoTicket.tickets().size()).isEqualTo(10);
    }

    @Test
    @DisplayName("번호가 맞는지")
    void testAnswer() {
        //given
        LottoTicket lottoTicket = new LottoTicket();
        Set<LottoNumber> numbers = new HashSet<>();
        for (int i = 1; i < 7; i++) {
            LottoNumber lottoNumber = new LottoNumber(i);
            numbers.add(lottoNumber);
        }

        Answer answer = new Answer(numbers);

        Lotto lotto = new Lotto();
        lotto.addNumber(new LottoNumber(1));
        lotto.addNumber(new LottoNumber(2));
        lotto.addNumber(new LottoNumber(3));
        lotto.addNumber(new LottoNumber(10));
        lotto.addNumber(new LottoNumber(11));
        lotto.addNumber(new LottoNumber(12));
        lottoTicket.add(lotto);
        //when
        MatchedAnswer match = shop.matchAnswer(lottoTicket, answer);
        //then
        assertThat(match.count(3)).isEqualTo(1);
    }
}