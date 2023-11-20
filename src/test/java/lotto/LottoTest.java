package lotto;


import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.ResultWinner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또 번호 확인 테스트")
    @Test
    public void 로또번호확인() {
        assertThatThrownBy(() -> {
            Set<Integer> numbers = new HashSet<Integer>();
            numbers.add(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("일등 확인 테스트")
    @Test
    public void 일등확인() {

        Set<Integer> numbers = new HashSet<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        Lotto lotto = new Lotto(numbers);

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
}
