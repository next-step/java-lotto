package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("로또 번호가 얼마나 일치하는가")
    void numberCheck() {
        List<LottoBall> winner = new ArrayList<>();
        winner.add(LottoBall.ball(1));
        winner.add(LottoBall.ball(4));
        winner.add(LottoBall.ball(10));
        winner.add(LottoBall.ball(11));

        List<LottoBall> myBall = new ArrayList<>();
        myBall.add(LottoBall.ball(10));
        myBall.add(LottoBall.ball(11));

        Lotto mylotto = new Lotto(myBall);
        Lotto winlotto = new Lotto(myBall);
        assertThat(mylotto.numberCheck(winlotto)).isEqualTo(2);
    }
}