package lotto;

import lotto.domain.AnswerSheet;
import lotto.domain.Lotto;
import lotto.match.LottoResult;
import lotto.prize.StandardPrizeRate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class LottoResultTest {

    private LottoResult lottoResult;
    private final int lottoPrice = 1000;

    @BeforeEach
    public void setUp() {
        List<Lotto> lottos = List.of(new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12)));
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        AnswerSheet answerSheet = new AnswerSheet(numbers, 9);
        lottoResult = new LottoResult(lottos, answerSheet);
    }

    @Test
    @DisplayName("정답에 따라 올바른 텍스트를 가지고 있는다.")
    public void getWinningWordsContainsWord() {
        assertThat( lottoResult.getWinningWords()).contains("3개 일치 (5000원)- 1개\n");
    }

    @Test
    @DisplayName("번돈과 소비한돈을 나누어 수익률을 반환한다.")
    public void getWinningPercentByEarningAndSpent() {
        assertThat(lottoResult.getWinningPercent(new StandardPrizeRate(),lottoPrice)).isEqualTo(5);
    }

}