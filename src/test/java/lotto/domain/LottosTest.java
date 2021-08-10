package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LottosTest {

    @Test
    public void 로또와_그_원소들이_주어졌을_때_앞6자리를_추첨번호로_간주하고_가져올_수_있다(){
        //given
        Lottos lottos = new Lottos();
        //when
        List<Integer> lotteryNumbers = lottos.getLotteryNumbers();
        //then
        assertAll(
                () -> assertEquals(6, lotteryNumbers.size()),
                () -> assertEquals(lotteryNumbers, Arrays.asList(1, 2, 3, 4, 5, 6))
        );
    }

    @Test
    public void 로또를_섞은_후_그_결과를_확인할_수_있다(){
        //given
        Lottos lottos = new Lottos(){
            @Override
            public Lottos shuffle() {
                return this;
            }
        };
        //when
        Lottos shuffledLottos = lottos.shuffle();
        //then
        assertEquals(shuffledLottos.getLotteryNumbers(), Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}
