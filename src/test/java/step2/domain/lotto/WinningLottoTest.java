package step2.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.rank.RankType;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoTest {

    public static final LottoRule LOTTO_RULE = new LottoRule(1, 45, 6);

    @DisplayName("6개 번호가 일치하면 1등")
    @Test
    void determineFirstRank() {
        // given
        WinningLotto winningLotto = fixture();
        Lotto actualLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6), LOTTO_RULE);

        // when
        RankType actual = winningLotto.determineRank(actualLotto);

        // then
        RankType expected = RankType.FIRST;
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("5개 번호와 보너스 숫자가 일치하면 2등")
    @Test
    void determineSecondRank() {
        // given
        WinningLotto winningLotto = fixture();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7), LOTTO_RULE);

        // when
        RankType actual = winningLotto.determineRank(lotto);

        // then
        RankType expected = RankType.SECOND;
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("5개 번호만 일치하면 3등")
    @Test
    void determineThirdRank() {
        // given
        WinningLotto winningLotto = fixture();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8), LOTTO_RULE);

        // when
        RankType actual = winningLotto.determineRank(lotto);

        // then
        RankType expected = RankType.THIRD;
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("4개 번호가 일치하면 4등")
    @Test
    void determineFourthRank() {
        // given
        WinningLotto winningLotto = fixture();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8), LOTTO_RULE);

        // when
        RankType actual = winningLotto.determineRank(lotto);

        // then
        RankType expected = RankType.FOURTH;
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("3개 번호가 일치하면 5등")
    @Test
    void determineFifthRank() {
        // given
        WinningLotto winningLotto = fixture();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 9, 7, 8), LOTTO_RULE);

        // when
        RankType actual = winningLotto.determineRank(lotto);

        // then
        RankType expected = RankType.FIFTH;
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("2개 이하로 일치하면 등수 없음")
    @ValueSource(strings = {"1,2,7,8,9,10", "1,7,8,9,10,11", "7,8,9,10,11,12"})
    @ParameterizedTest
    void determineNoRank(String lottoNumbersString) {
        // given
        WinningLotto winningLotto = fixture();
        List<Integer> lottoNumbers = getLottoNumbersFromString(lottoNumbersString);
        Lotto lotto = new Lotto(lottoNumbers, LOTTO_RULE);

        // when
        RankType actual = winningLotto.determineRank(lotto);

        // then
        RankType expected = RankType.NO_RANK;
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    private WinningLotto fixture() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6), LOTTO_RULE);
        return new WinningLotto(winningLotto, 7);
    }

    private List<Integer> getLottoNumbersFromString(String lottoNumbersString) {
        String[] split = lottoNumbersString.split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : split) {
            lottoNumbers.add(Integer.parseInt(number));
        }
        return lottoNumbers;
    }
}
