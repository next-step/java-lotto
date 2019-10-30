package step3;

import org.junit.jupiter.api.*;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticResultTest {
    private List<Integer> resultMatching = new ArrayList<>();
    private Map<Integer, Integer> summaryResult = new HashMap<>();

    @BeforeEach
    void setUp(){
        resultMatching.add(0, 1);
        resultMatching.add(1, 4);
        resultMatching.add(2, 0);
        resultMatching.add(3, 4);
        resultMatching.add(4, 1);

        summaryResult.put(3, 0);
        summaryResult.put(4, 2);
        summaryResult.put(5, 0);
        summaryResult.put(6, 0);
    }

    @DisplayName("당첨 로또 요약정보 확인")
    @Test
    public void 당첨_로또_요약정보_확인() {
        Map<Integer, Integer> compareSummary = StatisticResult.lottosInRank(resultMatching);
        assertThat(summaryResult).isEqualTo(compareSummary);
    }
}
