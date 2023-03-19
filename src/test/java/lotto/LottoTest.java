package lotto;

import Order.LottoOrder;
import casino.Casino;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {
    @DisplayName("발급된 로또 번호는 1~45 사이의 값 중 6개 이다.")
    @Test
    void publicTicket() {
        Lotto lotto = LottoFactory.auto();
        List<LottoNumber> lottoNumber = lotto.getLottoNumbers();
        assertThat(lottoNumber.size()).isEqualTo(6);
        lottoNumber.forEach(i -> assertThat(i.getNumber()).isBetween(1, 45));
    }

    @DisplayName("카지노에서 로또를 살 수 있다.")
    @Test
    void buyLottery() {
        List<Lotto> lotto = Casino.buyLottery(1000);
        lotto.forEach(i -> assertThat(i).isInstanceOfAny(Lotto.class));
    }

    @ParameterizedTest
    @CsvSource(value = {"3500,3", "5000,5", "14000,14"})
    void 로또는_한장에_1000원(int money, int count) {
        List<Lotto> lottoTickets = Casino.buyLottery(money);
        assertThat(lottoTickets.size()).isEqualTo(count);
    }

    @DisplayName("카지노에서 로또를 1000원 미만의 돈으로 사면 에러를 낸다.")
    @ParameterizedTest
    @ValueSource(strings = {"900"})
    void 로또를_1000미만으로_사면_에러(int money) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Casino.buyLottery(money));
    }

    @Test
    void 일등() {
        List<Integer> userLottoNumber = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLottoNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Lotto userLotto = LottoFactory.manualLotto(userLottoNumber);
        WinningLotto winningLotto = LottoFactory.manualWinningLotto(winningLottoNumber, bonusNumber);
        assertThat(Casino.match(userLotto, winningLotto)).isEqualTo(1);
    }

    @Test
    void 이등() {
        List<Integer> userLottoNumber = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> winningLottoNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Lotto userLotto = LottoFactory.manualLotto(userLottoNumber);
        WinningLotto winningLotto = LottoFactory.manualWinningLotto(winningLottoNumber, bonusNumber);
        assertThat(Casino.match(userLotto, winningLotto)).isEqualTo(2);
    }

    @DisplayName("로또 번호가 유니크하게 발급되었는지 확인한다")
    @Test
    void uniqueCheck() {
        assertThatThrownBy(() ->
                LottoFactory.manualLotto(List.of(1,2,3,3,4,5))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 우승 번호에 포함 되지 않았는지 확인한다")
    @Test
    void bonusCheck() {
        assertThatThrownBy(() ->
                LottoFactory.manualWinningLotto(List.of(1,2,3,4,5,6), 6)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수동_티켓_음수면_에러() {
        List<Integer> userManualLottoNumber = List.of(-1, 2, 3, 4, 5, 7);
        assertThatThrownBy(() ->
                LottoFactory.manualLotto(userManualLottoNumber)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 티켓_가격_음수면_에러() {
        assertThatThrownBy(() ->
                Casino.buyLottery(-1000)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수동_구매_후_자동_구매() {
        int money = 14000;
        int manualLottoCount = 1;
        List<List<Integer>> userManualLottoNumber = List.of(List.of(1, 2, 3, 4, 5, 7));
        LottoOrder lottoOrder = new LottoOrder(money,manualLottoCount);
        List<Lotto> userLotto = Casino.buyLotteryWithManual(lottoOrder, userManualLottoNumber);
        userLotto.forEach(i ->
                System.out.println(i.printLottoNumber())
        );
        assertThat(userLotto.size()).isEqualTo(14);
    }

}
