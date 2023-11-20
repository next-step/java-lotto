package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.ResultWinner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {


    @DisplayName("일등 확인 테스트")
    @Test
    public void 일등확인() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);

        Lottos lottos = new Lottos(lottoList);
        List<String> lastWeekWinner = Arrays.asList("1", "2", "3", "4", "5", "6");

        ResultWinner winner = new ResultWinner();
        assertThat(winner.countOfWinner(lottos, lastWeekWinner, "7").get(Rank.FIRST)).isEqualTo(1);
    }

    @DisplayName("이등 확인 테스트")
    @Test
    public void 이등확인() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);

        Lottos lottos = new Lottos(lottoList);
        List<String> lastWeekWinner = Arrays.asList("1", "2", "3", "4", "5", "7");

        ResultWinner winner = new ResultWinner();
        assertThat(winner.countOfWinner(lottos, lastWeekWinner, "6").get(Rank.SECOND)).isEqualTo(1);
    }

    @DisplayName("삼등 확인 테스트")
    @Test
    public void 삼등확인() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);

        Lottos lottos = new Lottos(lottoList);
        List<String> lastWeekWinner = Arrays.asList("1", "2", "3", "4", "5", "10");

        ResultWinner winner = new ResultWinner();
        assertThat(winner.countOfWinner(lottos, lastWeekWinner, "7").get(Rank.THIRD)).isEqualTo(1);
    }

    @DisplayName("사등 확인 테스트")
    @Test
    public void 사등확인() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);

        Lottos lottos = new Lottos(lottoList);
        List<String> lastWeekWinner = Arrays.asList("1", "2", "3", "4", "9", "10");

        ResultWinner winner = new ResultWinner();
        assertThat(winner.countOfWinner(lottos, lastWeekWinner, "7").get(Rank.FOURTH)).isEqualTo(1);
    }

}
