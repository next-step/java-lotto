package lotto.model;

import lotto.service.LottoNumberPicker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class LottosTest {

    @Test
    void shouldGetWinningMoney() {
        int lottoNumber = 3;
        Lottos lottos = new Lottos(lottoNumber, getNumberPicker());

        Integer winningMoney = lottos.getWinningMoney(getLotto(List.of(1, 2, 3, 99, 99, 99)));

        assertThat(winningMoney).isEqualTo(MatchNumber.THREE.getMoney() * lottoNumber);
    }

    @Test
    void shouldGetMatchedNumbers() {
        int lottoNumber = 3;
        Lottos lottos = new Lottos(lottoNumber, getNumberPicker());

        Map<MatchNumber, Integer> matchNumbers = lottos.getMatchNumbers(getLotto(List.of(1, 2, 3, 99, 99, 99)));

        assertThat(matchNumbers.get(MatchNumber.THREE)).isEqualTo(lottoNumber);
    }


    private LottoNumberPicker getNumberPicker() {
        return () -> List.of(1, 2, 3, 4, 5, 6).stream().map(LottoBall::new).collect(Collectors.toList());
    }

    private Lotto getLotto(List<Integer> lottoBalls){
        return new Lotto(lottoBalls.stream().map(LottoBall::new).collect(Collectors.toList()));
    }
}
