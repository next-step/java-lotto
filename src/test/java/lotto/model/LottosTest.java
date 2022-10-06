package lotto.model;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    void shouldGetWinningMoney() {
        Lottos lottos = Lottos.getManualLottos(List.of(createSingleLotto(1, 2, 3, 4, 5, 6)));

        Integer winningMoney = lottos.getWinningMoney(new WinningLotto(createSingleLotto(1, 2, 3, 4, 99, 99), new LottoBall(5)));

        assertThat(winningMoney).isEqualTo(MatchNumber.FOURTH.getMoney());
    }

    @Test
    @DisplayName("보너스볼까지 일치된 경우, 맞는 등수에 속하는 개수를 반환해야 합니다.")
    void shouldGetMatchedNumbers() {
        Lottos lottos = Lottos.getManualLottos(List.of(createSingleLotto(1, 2, 3, 4, 5, 6)));

        Map<MatchNumber, Integer> matchNumbers = lottos.getMatchNumbers(new WinningLotto(createSingleLotto(1, 2, 3, 4, 5, 99), new LottoBall(6)));

        assertThat(matchNumbers.get(MatchNumber.SECOND)).isEqualTo(1);
    }


    @Test
    void shouldAddLottos() {
        Lottos lottosA = Lottos.getManualLottos(Lists.list(createSingleLotto(1, 2, 3, 4, 5, 6)));
        Lottos lottosB = Lottos.getManualLottos(Lists.list(createSingleLotto(7, 8, 9, 4, 5, 6)));
        lottosA.add(lottosB);

        assertThat(lottosA.size()).isEqualTo(2);
    }

    private Lotto createSingleLotto(Integer... param) {
        return new Lotto(Arrays.stream(param).map(LottoBall::new).collect(Collectors.toList()));
    }


}
