package step2.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class LotteryTest {

    @Test
    void 로또_정상_생성_테스트() {
        Set<Integer> case1 = new HashSet<>();
        Set<Integer> case2 = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            case1.add(i);
        }
        for (int i = 0; i < 6; i++) {
            case2.add(i);
        }
        assertThatThrownBy(() -> Lottery.of(case1)).isInstanceOf(IllegalArgumentException.class);
        assertThat(Lottery.of(case2)).isInstanceOf(Lottery.class);
    }
}
