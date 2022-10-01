package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    @DisplayName("보너스 볼을 가지고 있는지 여부를 검사해야 합니다.")
    void shouldReturnHasBonusBall() {
        int bonusBallNumber = 99;
        WinningLotto winningLotto = new WinningLotto(getLotto(List.of(1, 2, 3, 4, 5, 6)), new LottoBall(bonusBallNumber));


        assertThat(winningLotto.hasBonusBall(getLotto(List.of(bonusBallNumber, 1, 3, 6, 42, 12)))).isTrue();
        assertThat(winningLotto.hasBonusBall(getLotto(List.of(0, 1, 3, 6, 42, 12)))).isFalse();
    }

    private Lotto getLotto(List<Integer> lottoBalls) {
        return new Lotto(lottoBalls.stream().map(LottoBall::new).collect(Collectors.toList()));
    }

}
