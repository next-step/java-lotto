package lotto.shop;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.lotto.WinningNumber;
import lotto.lotto.LottoNumber;
import lotto.error.ErrorMessage;
import lotto.lotto.Lotto;
import lotto.lotto.LottoTicket;
import lotto.lotto.LottoResult;

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
        LottoTicket lottoTicket = shop.buyAutoLotto(money);
        //then
        assertThat(lottoTicket.matchingCount()).isEqualTo(10);
    }

    @Test
    @DisplayName("구매 금액이 부족한 경우")
    void buyFailed() {
        //given
        Money money = new Money(900);
        //when
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> shop.buyAutoLotto(money)).withMessageContaining(ErrorMessage.NOT_ENOUGH_MONEY);
        //then
    }

    @Test
    @DisplayName("구매한 만큼 로또 구입")
    void buyLotto() {
        //given
        Money money = new Money(10000);
        //when
        LottoTicket lottoTicket = shop.buyAutoLotto(money);
        //then
        assertThat(lottoTicket.matchingCount()).isEqualTo(10);
    }

    @Test
    @DisplayName("로또 오토")
    void makeLottoAuto() {
        //given
        Money money = new Money(10000);
        //when
        LottoTicket lottoTicket = shop.buyAutoLotto(money);
        //then
        assertThat(lottoTicket.matchingCount()).isEqualTo(10);
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

        WinningNumber winningNumber = new WinningNumber(numbers);

        Lotto lotto = new Lotto(new int[]{1, 2, 3, 33, 34, 34});
        lottoTicket.add(lotto);
        //when
        LottoResult match = shop.lottoResult(lottoTicket, winningNumber);
        //then
        assertThat(match.count(3)).isEqualTo(1);
    }
}