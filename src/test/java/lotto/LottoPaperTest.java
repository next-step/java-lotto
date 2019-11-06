package lotto;

import lotto.domain.CreatableLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoPaper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPaperTest {
    private LottoPaper lottoPaper;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        lotto = new Lotto(numbers);
        lottoPaper = new LottoPaper();

        lottoPaper.applyLotto(lotto);
        lottoPaper.getWinningLottoRanks(new int[] {1,2,3,4,5,6}, 7);
    }

    @Test
    void checkLottoWinNumber() {
        assertThat(lotto.getLottoNumber()).contains(1,2,3,4,5,6);
    }

    @Test
    void checkLottoRankTest() {
        int[] winNumber = new int[] {1,2,3,4,5,6};
        lottoPaper.applyLotto(lotto);
        assertThat(lottoPaper.getWinningLottoRanks(winNumber, 10)).contains(Rank.FIRST);
    }

}
