package lotto;


import lotto.domain.*;
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
            Set<LottoNumber> numbers = new HashSet<LottoNumber>();
            numbers.add(new LottoNumber(46));
        }).isInstanceOf(IllegalArgumentException.class);
    }

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
}
