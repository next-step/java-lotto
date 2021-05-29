package lotto.shop;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import lotto.enums.Prize;
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
        LottoTicket lottoTicket = shop.buyAutoLotto(new LottoTicket(), money);
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
                .isThrownBy(() -> shop.buyAutoLotto(new LottoTicket(), money)).withMessageContaining(ErrorMessage.NOT_ENOUGH_MONEY);
        //then
    }

    @Test
    @DisplayName("구매한 만큼 로또 구입")
    void buyLotto() {
        //given
        Money money = new Money(10000);
        //when
        LottoTicket lottoTicket = shop.buyAutoLotto(new LottoTicket(), money);
        //then
        assertThat(lottoTicket.matchingCount()).isEqualTo(10);
    }

    @Test
    @DisplayName("로또 오토")
    void makeLottoAuto() {
        //given
        Money money = new Money(10000);
        //when
        LottoTicket lottoTicket = shop.buyAutoLotto(new LottoTicket(), money);
        //then
        assertThat(lottoTicket.matchingCount()).isEqualTo(10);
    }

    @Test
    @DisplayName("번호가 맞는지")
    void testAnswer() {
        //given
        LottoTicket lottoTicket = new LottoTicket();
        WinningNumber winningNumber = new WinningNumber(initWinningNumbers());

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 33, 34, 34));
        lottoTicket.add(lotto);
        LottoNumber bonusNumber = LottoNumber.of(5);
        //when
        LottoResult match = shop.lottoResult(lottoTicket, winningNumber, bonusNumber);
        //then
        assertThat(match.count(Prize.FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("2등 당첨")
    void testSecond() {
        //given
        LottoTicket lottoTicket = new LottoTicket();
        WinningNumber winningNumber = new WinningNumber(initWinningNumbers());

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 16));
        lottoTicket.add(lotto);
        LottoNumber bonusNumber = LottoNumber.of(16);
        //when
        LottoResult match = shop.lottoResult(lottoTicket, winningNumber, bonusNumber);

        //then
        assertThat(match.count(Prize.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("보너스 넘버가 중복 될 경우 에러")
    void checkDuplicateBonusNumber() {
        //given
        WinningNumber winningNumber = new WinningNumber(initWinningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(1);
        Shop shop = new Shop();
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> shop.checkDuplicateBonusNumber(winningNumber, bonusNumber))
                .withMessageContaining(ErrorMessage.DUPLICATE_BONUS_NUMBER);
    }

    @Test
    @DisplayName("셀프 로또 구매 확인")
    void buySelfLottoAmount() {
        //given
        Money money = shop.buySelfLotto(new Money(10000), 7);
        //then
        assertThat(money.amount()).isEqualTo(3000);
    }

    @Test
    @DisplayName("셀프 로또 금액 부족")
    void buySelfLottoFailed() {
        //given
        //when
        //then
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> shop.buySelfLotto(new Money(10000), 100))
                .withMessageContaining(ErrorMessage.NOT_ENOUGH_MONEY);
    }

    @Test
    @DisplayName("셀프 구매후 자동 구매")
    void buySelfAutoLotto() {
        //given
        //when
        Money money = shop.buySelfLotto(new Money(10000), 5);
        LottoTicket lottoTicket = new LottoTicket();
        for (int i = 0; i < 5; i++) {
            lottoTicket.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        }
        LottoTicket lottoTicket1 = shop.buyAutoLotto(lottoTicket, money);
        //then
        assertThat(lottoTicket1.tickets().size()).isEqualTo(10);
    }

    private Set<LottoNumber> initWinningNumbers() {
        Set<LottoNumber> numbers = new HashSet<>();
        for (int i = 1; i < 7; i++) {
            LottoNumber lottoNumber = LottoNumber.of(i);
            numbers.add(lottoNumber);
        }
        return numbers;
    }
}