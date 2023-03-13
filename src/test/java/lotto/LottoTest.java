package lotto;

import casino.Casino;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest {
    @DisplayName("로또는 번호는 1 - 45 까지다.")
    @Test
    void numbers() {
        Lotto lotto = new Lotto();
        int[] sample = IntStream.rangeClosed(1, 45).toArray();
        assertThat(lotto.getLotteryRange()).isEqualTo(sample);
    }

    @DisplayName("발급된 로또 번호는 1~45 사이의 값 중 6개 이다.")
    @Test
    void publicTicket() {
        Lotto lotto = new Lotto();
        HashSet<Integer> lottoNumber = lotto.getLotteryNumbers();
        assertThat(lottoNumber.size()).isEqualTo(6);
        lottoNumber.forEach(i -> assertThat(i).isBetween(1, 45));
    }

    @DisplayName("카지노에서 로또를 살 수 있다.")
    @Test
    void buyLottery() {
        Casino casino = new Casino();
        Lotto lotto = casino.buyLottery2();
        assertThat(lotto).isInstanceOfAny(Lotto.class);
    }

    @DisplayName("카지노에서 로또는 1장에 1000원이다.")
    @ParameterizedTest
    @CsvSource(value = {"3500,3", "5000,5", "14000,14"})
    void buyLottery2(int money, int count) {
        Casino casino = new Casino();
        List<Lotto> lottoTickets = casino.buyLottery(money);
        assertThat(lottoTickets.size()).isEqualTo(count);
    }

    @DisplayName("카지노에서 로또를 1000원 미만의 돈으로 사면 에러를 낸다.")
    @ParameterizedTest
    @ValueSource(strings = {"900"})
    void buyLottery2(int money) {
        Casino casino = new Casino();
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> casino.buyLottery(money));
    }

    @DisplayName("카지노에서 당첨 번호를 입력 받아 당첨 번호가 있는지 확인한다.")
    @Test
    void setLuckyNumber() {
        Casino casino = new Casino();
        HashSet<Integer> winningNumber = new HashSet<>(Arrays.asList(3, 4, 45, 6, 32, 12));
        int bonusNumber = 3;
        List<Lotto> lottoTickets = casino.buyLottery(14000);
        for(Lotto lotto : lottoTickets) {
            casino.lotteryStart(winningNumber, lotto, bonusNumber);
        }
        lottoTickets.forEach(i -> {
                    assertThat(i.getMatchingCount()).isGreaterThan(-1);
                });
    }

    @Test
    void 일등() {
        Casino casino = new Casino();
        HashSet<Integer> userLotto = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        HashSet<Integer> winningNumber = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 3;
        Lotto lotto = new Lotto(userLotto);
        assertThat(lotto.match(winningNumber, bonusNumber)).isEqualTo(1);
    }

    @Test
    void 이등() {
        Casino casino = new Casino();
        HashSet<Integer> userLotto = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        HashSet<Integer> winningNumber = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        Lotto lotto = new Lotto(userLotto);
        assertThat(lotto.match(winningNumber, bonusNumber)).isEqualTo(2);
    }
}
