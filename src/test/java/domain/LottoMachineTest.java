package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertSame;

class LottoMachineTest {
    @Test
    @DisplayName("랜덤볼 결과 확정")
    void randomBall() {

        List<LottoBall> lottoBalls = new ArrayList<>();
        LottoMachine lottoMachine = new LottoMachine() {
            @Override
            public List<LottoBall> randomBall(int ballCount) {
                return lottoBalls;
            }
        };

        List<LottoBall> winnerBall = new ArrayList<>();
        assertThat(lottoMachine.randomBall(6)).isEqualTo(winnerBall);
    }
    @Test
    @DisplayName("로또 기게 랜덤볼 수")
    public void totalLotto() {
        LottoMachine lottoMachine = new LottoMachine();
        assertThat(lottoMachine.randomBall(6).size()).isEqualTo(6);
    }
}