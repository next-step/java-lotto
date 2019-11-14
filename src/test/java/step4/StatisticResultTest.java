package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.LottoNumber;
import step4.StatisticResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticResultTest {
    private List<LottoNumber> resultMatching = new ArrayList<>();
    private Map<Integer, Integer> summaryResult = new HashMap<>();

    @BeforeEach
    void setUp(){
        resultMatching.add(0, new LottoNumber(1, false));
        resultMatching.add(1, new LottoNumber(4, false));
        resultMatching.add(2, new LottoNumber(0, false));
        resultMatching.add(3, new LottoNumber(4, false));
        resultMatching.add(4, new LottoNumber(1, false));

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
