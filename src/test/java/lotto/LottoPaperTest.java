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
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
        lottoPaper = new LottoPaper();
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
        lottoPaper.applyLotto(new Lotto(numbers));
        lottoPaper.checkLottoGrade(new int[] {1,2,3,4,5,6});
    }

    @Test
    void checkInsightsTest() {
        assertThat(lottoPaper.checkInsights(0).get(0).getCount()).isEqualTo(1);
        assertThat(lottoPaper.checkInsights(1).get(1).getCount()).isEqualTo(2);
        assertThat(lottoPaper.checkInsights(2).get(2).getCount()).isEqualTo(3);
        assertThat(lottoPaper.checkInsights(3).get(3).getCount()).isEqualTo(1);
    }

    @Test
    void getInsightsTest() {
        assertThat(lottoPaper.getInsights().get(6).getCount()).isEqualTo(1);
        assertThat(lottoPaper.getInsights().get(5).getCount()).isEqualTo(0);
    }

    @Test
    void insightsIncreaseCountTest() {
        Insights.insights.get(3).increaseCount();
        assertThat(Insights.insights.get(3).getCount()).isEqualTo(1);
    }

}
