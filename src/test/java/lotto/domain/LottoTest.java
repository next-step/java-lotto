package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    Lotto lotto = new Lotto();
    List<Integer> list = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    List<Integer> target = new ArrayList<>();
    LottoNumbers lottoNumbers;
    @BeforeEach
    void setup() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        lotto.addLottoNumbers(new LottoNumbers(list));

        list2.add(2);
        list2.add(3);
        list2.add(5);
        lotto.addLottoNumbers(new LottoNumbers(list2));

        target.add(1);
        target.add(2);
        target.add(3);
        target.add(4);
        target.add(5);
        lottoNumbers = new LottoNumbers(target);
    }

    @Test
    void getRank_test() {
        List<Match> matchOf = new ArrayList<>();
        matchOf.add(Match.getMatchInfo(5));
        matchOf.add(Match.getMatchInfo(3));

        assertThat(lotto.getMatch(lottoNumbers.getLottoNumbers())).isEqualTo(matchOf);
    }

    @Test
    void matchLottoCount_test() {
        assertThat(lotto.getMatchLottoCount(target).size()).isEqualTo(2);
    }
}