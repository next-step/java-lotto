package deprecatedlotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinnerTest {

    public static final List<Integer> LOTTO_WINNER_NUMBER_LIST = List.of(1, 2, 3, 4, 5, 6);
    public static final List<Integer> LOTTO_NUMBER_LIST = List.of(4, 5, 6, 7, 8, 9);
    public static final Map<Integer, Integer> TEST_MATCHING_COUNT_MAP = Map.of(1,0,2,0,3,0,4,1);
    public static final int EXPECTED_MATCHING_COUNT = 3;

    @Test
    public void 일치횟수판단_테스트() {
        List<Integer> lottoWinnerNumberList = LOTTO_WINNER_NUMBER_LIST;
        List<Integer> lottoNumberList = LOTTO_NUMBER_LIST;
        LottoWinner lottoWinner = new LottoWinner(lottoWinnerNumberList);
        assertThat(lottoWinner.diffLottoAndWinningLotto(lottoNumberList)).isEqualTo(EXPECTED_MATCHING_COUNT);

    }

    @Test
    public void 일치횟수저장_테스트() {
        List<Integer> lottoWinnerNumberList = LOTTO_WINNER_NUMBER_LIST;
        List<Integer> lottoNumberList = LOTTO_NUMBER_LIST;

        LottoWinner lottoWinner = new LottoWinner(lottoWinnerNumberList);
        int matchingCount = lottoWinner.diffLottoAndWinningLotto(lottoNumberList);
        lottoWinner.recordWinningCount(matchingCount);
        assertThat(lottoWinner).isEqualTo(new LottoWinner(lottoWinnerNumberList,TEST_MATCHING_COUNT_MAP));
    }
}
