package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void shouldValidateLotto() {
        assertThatThrownBy(() -> getLotto(List.of(1, 1, 1, 1, 1))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스볼이 아닌, 추첨 번호와 일치된 숫자를 반환해야 합니다.")
    void shouldReturnMatchedCountOfWinnnigLotto() {
        Lotto lotto = getLotto(List.of(1, 2, 3, 4, 5, 6));

        int matchCountA = lotto.getMatchCount(new WinningLotto(getLotto(List.of(1, 2, 3, 4, 5, 8)), new LottoBall(99)));
        int matchCountB = lotto.getMatchCount(new WinningLotto(getLotto(List.of(1, 2, 3, 4, 5, 8)), new LottoBall(6)));

        assertThat(matchCountA).isEqualTo(5);
        assertThat(matchCountB).isEqualTo(5);
    }


    @Test
    void shouldReturnHasBall() {
        Lotto lottoA = getLotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lottoA.hasLottoBall(new LottoBall(1))).isTrue();
        assertThat(lottoA.hasLottoBall(new LottoBall(99))).isFalse();
    }

    private Lotto getLotto(List<Integer> lottoBalls) {
        return new Lotto(lottoBalls.stream().map(LottoBall::new).collect(Collectors.toList()));
    }

}
