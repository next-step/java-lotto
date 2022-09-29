package lotto.model;

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
    void shouldReturnMatchedCount() {
        assertThat(getLotto(List.of(1, 2, 3, 4, 5, 6)).getSameLottoBalls(getLotto(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(getLottoBalls(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void shouldReturnSameBall() {
        List<LottoBall> resultA = getLotto(List.of(1, 2, 3, 4, 5, 6)).getSameLottoBalls(getLotto(List.of(1, 2, 3, 4, 5, 6)));
        List<LottoBall> resultB = getLotto(List.of(1, 2, 3, 4, 5, 6)).getSameLottoBalls(getLotto(List.of(1, 2, 3, 4, 5, 7)));
        List<LottoBall> resultC = getLotto(List.of(1, 2, 3, 4, 99, 99)).getSameLottoBalls(getLotto(List.of(1, 2, 3, 4, 8, 9)));

        assertThat(resultA.size()).isEqualTo(6);
        assertThat(resultB.size()).isEqualTo(5);
        assertThat(resultC.size()).isEqualTo(4);
        assertThat(resultC).containsExactly(LottoBall.noBonusBall(1), LottoBall.noBonusBall(2), LottoBall.noBonusBall(3), LottoBall.noBonusBall(4));
    }

    @Test
    void shouldAddBonusBall() {
        Lotto lotto = getLotto(List.of(1, 2, 3, 4, 5, 6));
        lotto.addBonusBall(LottoBall.bonusBall(7));
        assertThat(lotto.getLotto().size()).isEqualTo(7);
    }

    private Lotto getLotto(List<Integer> lottoBalls) {
        return new Lotto(lottoBalls.stream().map(LottoBall::noBonusBall).collect(Collectors.toList()));
    }

    private List<LottoBall> getLottoBalls(List<Integer> lottoBalls) {
        return lottoBalls.stream().map(LottoBall::noBonusBall).collect(Collectors.toList());
    }
}
