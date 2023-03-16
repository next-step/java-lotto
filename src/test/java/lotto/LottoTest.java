package lotto;

import casino.Casino;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
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
        Casino casino = new Casino();
        List<Lotto> lotto = casino.buyLottery(1000);
        lotto.forEach(i -> assertThat(i).isInstanceOfAny(Lotto.class));
    }

    @ParameterizedTest
    @CsvSource(value = {"3500,3", "5000,5", "14000,14"})
    void 로또는_한장에_1000원(int money, int count) {
        Casino casino = new Casino();
        List<Lotto> lottoTickets = casino.buyLottery(money);
        assertThat(lottoTickets.size()).isEqualTo(count);
    }

    @DisplayName("카지노에서 로또를 1000원 미만의 돈으로 사면 에러를 낸다.")
    @ParameterizedTest
    @ValueSource(strings = {"900"})
    void 로또를_1000미만으로_사면_에러(int money) {
        Casino casino = new Casino();
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> casino.buyLottery(money));
    }

    @Test
    void 일등() {
        Casino casino = new Casino();
        List<Integer> userLottoNumber = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLottoNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Lotto userLotto = LottoFactory.manualLotto(userLottoNumber);
        WinningLotto winningLotto = LottoFactory.manualWinningLotto(winningLottoNumber, bonusNumber);
        assertThat(casino.match(userLotto, winningLotto)).isEqualTo(1);
    }

    @Test
    void 이등() {
        Casino casino = new Casino();
        List<Integer> userLottoNumber = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> winningLottoNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Lotto userLotto = LottoFactory.manualLotto(userLottoNumber);
        WinningLotto winningLotto = LottoFactory.manualWinningLotto(winningLottoNumber, bonusNumber);
        assertThat(casino.match(userLotto, winningLotto)).isEqualTo(2);
    }
}
