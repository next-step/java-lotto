package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {
    @Test
    @DisplayName("랜덤볼 결과 확정")
    void randomBall() {
        LottoMachine lottoMachine = new LottoMachine() {
            @Override
            public List<Integer> randomBall() {
                return List.of(1, 2, 3, 4, 5, 6);
            }
        };

        List<Integer> winnerBall = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoMachine.randomBall()).isEqualTo(winnerBall);
    }

    @Test
    @DisplayName("로또 기게 랜덤볼 수")
    public void totalLotto() {
        LottoMachine lottoMachine = new LottoMachine();
        assertThat(lottoMachine.randomBall().size()).isEqualTo(6);
    }
}