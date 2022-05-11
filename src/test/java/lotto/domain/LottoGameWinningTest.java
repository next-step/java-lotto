package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameWinningTest {
    @ParameterizedTest
    @CsvSource(value = {
            "7,8,9,11,12,13=MISS",
            "1,8,9,11,12,13=MISS",
            "1,2,9,11,12,13=MISS",
            "1,2,3,11,12,13=FIFTH",
            "1,2,3,10,12,13=FOURTH",
            "1,2,3,10,20,13=THIRD",
            "1,2,3,10,20,30=FIRST",
    }, delimiter = '=')
    @DisplayName("당첨번호와 로또번호가 0개에서 6개까지 일치한다.")
    void winningLottoMatch(String lottoNumber, Rank rank) {
        List<Lotto> lottoNumbers = new ArrayList<>(List.of(new Lotto("1, 2, 3, 10, 20, 30")));
        //WinningLotto winningLotto = new WinningLotto(lottoNumber, new LottoGame("1000", new UserLotto(lottoNumbers)));
        //assertThat(winningLotto.getWinningCount(rank)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또를 14,000원 구매하고 5등이 2개면 수익율은 약 0.35 이다")
    void returnRate() {
        List<Lotto> lottoNumbers = new ArrayList<>(Arrays.asList(
                new Lotto("1, 2, 3, 7, 8, 9"),
                new Lotto("33, 34, 45, 11, 22, 19")));
       // WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6",
       //         new LottoGame("14000", new UserLotto(lottoNumbers)));

        //double returnRate = winningLotto.getReturnRate();
        //assertThat(returnRate).isBetween(0.35, 0.36);
    }

    //TODO: 14000원인데 2개만 있을 때
}
