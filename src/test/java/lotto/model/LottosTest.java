package lotto.model;

import lotto.service.LottoNumberPicker;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    void shouldGetWinningMoney() {
        int lottoNumber = 3;
        Lottos lottos = new Lottos(lottoNumber, getNumberPicker());

        Integer winningMoney = lottos.getWinningMoney(new WinningLotto(getLotto(List.of(1, 2, 3, 4, 99, 99)), new LottoBall(5)));

        assertThat(winningMoney).isEqualTo(MatchNumber.FOURTH.getMoney() * lottoNumber);
    }

    @Test
    void shouldGetMatchedNumbers() {
        int lottoNumber = 3;
        Lottos lottos = new Lottos(lottoNumber, getNumberPicker());

        Map<MatchNumber, Integer> matchNumbers = lottos.getMatchNumbers(new WinningLotto(getLotto(List.of(1, 2, 3, 4, 5, 99)), new LottoBall(6)));

        assertThat(matchNumbers.get(MatchNumber.SECOND)).isEqualTo(lottoNumber);
    }


    private LottoNumberPicker getNumberPicker() {
        return () -> List.of(1, 2, 3, 4, 5, 6).stream().map(LottoBall::new).collect(Collectors.toList());
    }

    private Lotto getLotto(List<Integer> lottoBalls) {
        return new Lotto(lottoBalls.stream().map(LottoBall::new).collect(Collectors.toList()));
    }
}
