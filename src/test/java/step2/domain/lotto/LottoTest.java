package step2.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

public class LottoTest {

    @DisplayName("6개 번호가 일치하면 1등")
    @Test
    void determineFirstRank() {
        // given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        Rank actual = lotto.determineRank(winningLotto);

        // then
        Rank expected = Rank.FIRST;
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("5개 번호가 일치하면 2등")
    @Test
    void determineSecondRank() {
        // given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        // when
        Rank actual = lotto.determineRank(winningLotto);

        // then
        Rank expected = Rank.SECOND;
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("4개 번호가 일치하면 3등")
    @Test
    void determineThirdRank() {
        // given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));

        // when
        Rank actual = lotto.determineRank(winningLotto);

        // then
        Rank expected = Rank.THIRD;
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("3개 번호가 일치하면 4등")
    @Test
    void determineFourthRank() {
        // given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 9, 7, 8));

        // when
        Rank actual = lotto.determineRank(winningLotto);

        // then
        Rank expected = Rank.FOURTH;
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("2개 이하로 일치하면 등수 없음")
    @ValueSource(strings = {"1,2,7,8,9,10", "1,7,8,9,10,11", "7,8,9,10,11,12"})
    @ParameterizedTest
    void determineNoRank(String lottoNumbersString) {
        // given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> lottoNumbers = getLottoNumbersFromString(lottoNumbersString);
        Lotto lotto = new Lotto(lottoNumbers);

        // when
        Rank actual = lotto.determineRank(winningLotto);

        // then
        Rank expected = Rank.NO_RANK;
        Assertions.assertThat(actual).isEqualTo(expected);
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
