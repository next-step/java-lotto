package lotto.domain;

import lotto.constant.MatchResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    WinningNumbers winningLottoNumbers;

    @BeforeEach
    void beforeEach() {
        TreeSet<LottoNumber> winningNumberTreeSet = new TreeSet<>();
        winningNumberTreeSet.add(LottoNumber.valueOf(1));
        winningNumberTreeSet.add(LottoNumber.valueOf(2));
        winningNumberTreeSet.add(LottoNumber.valueOf(3));
        winningNumberTreeSet.add(LottoNumber.valueOf(20));
        winningNumberTreeSet.add(LottoNumber.valueOf(21));
        winningNumberTreeSet.add(LottoNumber.valueOf(22));

        winningLottoNumbers = new WinningNumbers(winningNumberTreeSet);
    }


    @Test
    @DisplayName("3개의 복권 중 2개가 MatchResult.Three 경우 10000을 반환한다.")
    void calculateTotalWinPrice() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(new LottoMarkingNumbers(Arrays.asList(LottoNumber.valueOf(1), LottoNumber.valueOf(2), LottoNumber.valueOf(3), LottoNumber.valueOf(4), LottoNumber.valueOf(5), LottoNumber.valueOf(6)))));
        lottoList.add(new Lotto(new LottoMarkingNumbers(Arrays.asList(LottoNumber.valueOf(1), LottoNumber.valueOf(2), LottoNumber.valueOf(3), LottoNumber.valueOf(7), LottoNumber.valueOf(8), LottoNumber.valueOf(9)))));
        lottoList.add(new Lotto(new LottoMarkingNumbers(Arrays.asList(LottoNumber.valueOf(11), LottoNumber.valueOf(12), LottoNumber.valueOf(13), LottoNumber.valueOf(14), LottoNumber.valueOf(15), LottoNumber.valueOf(16)))));;

        Lottos lottos = new Lottos(lottoList);
        lottos.confirmAll(winningLottoNumbers);

        assertThat(lottos.calculateTotalWinPrice()).isEqualTo(10000);
    }

    @Test
    @DisplayName("3개의 복권 중 2개가 MatchResult.Three 일때 MatchResult.Three 개수를 구하면 2개를 반환한다.")
    void countMatchResult() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(new LottoMarkingNumbers(Arrays.asList(LottoNumber.valueOf(1), LottoNumber.valueOf(2), LottoNumber.valueOf(3), LottoNumber.valueOf(4), LottoNumber.valueOf(5), LottoNumber.valueOf(6)))));
        lottoList.add(new Lotto(new LottoMarkingNumbers(Arrays.asList(LottoNumber.valueOf(1), LottoNumber.valueOf(2), LottoNumber.valueOf(3), LottoNumber.valueOf(7), LottoNumber.valueOf(8), LottoNumber.valueOf(9)))));
        lottoList.add(new Lotto(new LottoMarkingNumbers(Arrays.asList(LottoNumber.valueOf(11), LottoNumber.valueOf(12), LottoNumber.valueOf(13), LottoNumber.valueOf(14), LottoNumber.valueOf(15), LottoNumber.valueOf(16)))));

        Lottos lottos = new Lottos(lottoList);
        lottos.confirmAll(winningLottoNumbers);

        assertThat(lottos.countMatchResult(MatchResult.THREE)).isEqualTo(2);
    }
}