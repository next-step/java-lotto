package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private List<Integer> winningLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
    private Lotto lotto1;
    private Lotto lotto2;
    private Lotto lotto3;
    private Lotto lotto4;


    @BeforeEach
    void setUp() {
        lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8));
        lotto3 = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        lotto4 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9));
    }

    @Test
    void findCountOfThreeNumMatchingTest() {
        //given
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2, lotto3, lotto4));

        //when
        int countOfThreeNumMatching = lottos.findCountOfThreeNumMatching(winningLotto);

        //then
        assertThat(countOfThreeNumMatching).isEqualTo(1);
    }
}
