package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void shouldValidateLotto() {
        assertThatThrownBy(() -> getLotto(List.of(1, 1, 1, 1, 1, 1, 1))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldReturnMatchedCount() {
        assertThat(getLotto(List.of(1, 2, 3, 4, 5, 6)).getMatchedCount(getLotto(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
        assertThat(getLotto(List.of(1, 2, 3, 4, 5, 6)).getMatchedCount(getLotto(List.of(1, 2, 3, 4, 5, 7)))).isEqualTo(5);
        assertThat(getLotto(List.of(1, 2, 3, 4,99,99)).getMatchedCount(getLotto(List.of(1, 2, 3, 4, 8, 9)))).isEqualTo(4);
        assertThatThrownBy(() ->getLotto(List.of(1, 1, 1, 1, 1, 1, 1))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldReturnDifference() {
        assertThat(getLotto(List.of(1, 2, 3, 4, 5, 6)).getDifference(getLotto(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(getLotto(List.of(6)));
        assertThat(getLotto(List.of(1, 2, 3, 4, 5, 6)).getDifference(getLotto(List.of(1, 2, 3, 4, 5, 7)))).isEqualTo(getLotto(List.of(5,7)));
        assertThat(getLotto(List.of(1, 2, 3, 4,99,99)).getDifference(getLotto(List.of(1, 2, 3, 4, 8, 9)))).isEqualTo(getLotto(List.of(4,8,9)));
    }

    @Test
    void shouldAddBonusBall(){
        Lotto lotto = getLotto(List.of(1,2,3,4,5,6));
        lotto.addBonusBall(LottoBall.bonusBall(7));
        assertThat(lotto.getLotto().size()).isEqualTo(7);
    }

    private Lotto getLotto(List<Integer> lottoBalls){
        return new Lotto(lottoBalls.stream().map(LottoBall::noBonusBall).collect(Collectors.toList()));
    }
}
