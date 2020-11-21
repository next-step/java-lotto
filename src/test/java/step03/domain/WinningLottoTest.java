package step03.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    Lotto winningLotto;

    @BeforeEach
    void setup() {
        winningLotto = Lotto.intOf(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("생성자")
    @Test
    void test_constructor() {
        BonusBall bonusBall = BonusBall.of(LottoBall.valueOf(7));
        assertThat(WinningLotto.of(winningLotto, bonusBall)).isEqualTo(WinningLotto.of(winningLotto, bonusBall));
    }

//        - 당첨로또에 보너스 볼 번호를 추가하는 기능
//    - 보너스 볼이 당첨로또에 포함되지 않는지 검사


}
