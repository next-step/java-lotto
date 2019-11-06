package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoPaper;
import lotto.domain.CreatableLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private LottoPaper lottoPaper;
    private List<Integer> numbers;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
        lottoPaper = new LottoPaper(3);
        numbers = lotto.selectLottoNumber(new CreatableLotto() {
            @Override
            public List<Integer> makeLotto() {
                List<Integer> list = new ArrayList<>();
                list.add(4);
                list.add(5);
                list.add(6);
                list.add(1);
                list.add(2);
                list.add(3);
                return list;
            }
        });
    }

    @Test
    void lottoTest() {
        assertThat(numbers).hasSize(6);
    }

    @Test
    void sortTest() {
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getLottoNumber()).containsExactly(1,2,3,4,5,6);
    }

    @Test
    void checkLottoGrade() {
        int[] winNumber = new int[] {1,2,3,4,5,6};
        Lotto lotto = new Lotto(numbers);
        lottoPaper.applyLotto(lotto);
        lottoPaper.checkLottoGrade(winNumber);
        assertThat(lotto.getHitCount(1)).isEqualTo(6);
    }
}