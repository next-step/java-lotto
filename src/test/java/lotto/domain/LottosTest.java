package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.Ball;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.Prizes;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    @DisplayName("당첨번호와 3개 일치하는 개수를 센다")
    void judge() {
        Lottos lottos = makeLottos(
            makeLotto(1, 2, 3, 45, 44, 43),
            makeLotto(4, 5, 6, 45, 44, 43),
            makeLotto(45, 44, 43, 42, 41, 40)
        );

        WinningLotto winningLotto = makeWinningLotto(1, 1, 2, 3, 4, 5, 6);
        Prizes judge = lottos.judge(winningLotto);

        assertThat(judge.count(Prize.FIFTH_PLACE)).isEqualTo(2);
    }

    private WinningLotto makeWinningLotto(int bonusBallNumber, int... _balls) {
        Set<Ball> balls = Arrays.stream(_balls)
            .mapToObj(Ball::new)
            .collect(Collectors.toSet());
        Ball bonusBall = new Ball(bonusBallNumber);
        return new WinningLotto(balls, bonusBall);
    }

    private Lottos makeLottos(Lotto... _lottos) {
        List<Lotto> lottos = Arrays.stream(_lottos)
            .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    private Lotto makeLotto(int... _balls) {
        Set<Ball> balls = Arrays.stream(_balls)
            .mapToObj(Ball::new)
            .collect(Collectors.toSet());
        return new Lotto(balls);
    }
}
