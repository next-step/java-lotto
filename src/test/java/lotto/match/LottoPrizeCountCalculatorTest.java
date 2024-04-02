package lotto.match;

import lotto.domain.AnswerSheet;
import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoNumber;
import lotto.prize.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottoPrizeCountCalculatorTest {

    @Test
    @DisplayName("로또와 정답지를 기반으로 결과를 반환한다.")
    void getLottoPrizeCount() {

        AnswerSheet answerSheet = new AnswerSheet(new Lotto(1, 2, 3, 4, 5, 6), LottoNumber.from(7));
        LottoList lottoList = new LottoList(List.of(new Lotto(1, 2, 3, 4, 8, 9)));

        LottoPrizeCountCalculator calculator = new LottoPrizeCountCalculator(lottoList, answerSheet);

        List<LottoPrizeCount> lottoPrizeCount = calculator.getLottoPrizeCount();
        assertThat(lottoPrizeCount).contains(new LottoPrizeCount(LottoPrize.MATCH_4,1));
    }
}