package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    @DisplayName("입력된 로또와 당첨 로또의 일치하는 번호 갯수를 리턴한다")
    public void matchLottoNumberReturnsCountOfMatches() {
        List<Integer> lotto = Arrays.asList(1, 2, 3, 10, 11, 12);
        List<Integer> winningLotto = Arrays.asList(1, 2, 3, 4, 5, 6);

        int result = LottoGame.match(lotto, winningLotto);

        assertThat(result).isEqualTo(3);

        lotto = Arrays.asList(1, 2, 3, 10, 11, 12);
        winningLotto = Arrays.asList(1, 2, 3, 5, 6, 10);

        result = LottoGame.match(lotto, winningLotto);

        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("일치한 번호 갯수를 입력하면 등수를 리턴한다")
    public void getRankReturnsRankOfLotto() {
        List<Integer> lotto = Arrays.asList(1, 2, 3, 10, 11, 12);
        List<Integer> winningLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        int matchCount = LottoGame.match(lotto, winningLotto);

        Rank result = LottoGame.getRank(matchCount);

        assertThat(result).isEqualTo(FOURTH);

        lotto = Arrays.asList(1, 2, 3, 10, 11, 12);
        winningLotto = Arrays.asList(1, 2, 3, 4, 5, 10);
        matchCount = LottoGame.match(lotto, winningLotto);

        result = LottoGame.getRank(matchCount);

        assertThat(result).isEqualTo(THIRD);
    }
}
