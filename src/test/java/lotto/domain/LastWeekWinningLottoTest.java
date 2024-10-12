package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LastWeekWinningLottoTest {
    final Lotto otherLotto = new Lotto(
        List.of(
            new LottoNumber(1), new LottoNumber(2),
            new LottoNumber(3), new LottoNumber(4),
            new LottoNumber(5), new LottoNumber(6)
        )
    );

    @Test
    @DisplayName("지난주 당첨번호에 있는 번호를 보너스번호로 지정하는 경우 예외가 발생한다.")
    void shouldThrowExceptionWhenBonusNumberIsInWinningNumbers() {
        final List<LottoNumber> matchNumber = List.of(
            new LottoNumber(1), new LottoNumber(2),
            new LottoNumber(3), new LottoNumber(4),
            new LottoNumber(5), new LottoNumber(6)
        );
        final List<LottoNumber> nonMatchNumber = List.of();
        final LottoNumber bonusNumber = new LottoNumber(1);
        final Lotto winningLotto = new Lotto(merge(matchNumber, nonMatchNumber));

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new LastWeekWinningLotto(winningLotto, bonusNumber));
    }

    @Test
    @DisplayName("모든 번호가 일치하는 경우 1등을 반환한다.")
    void shouldCalculateFirstRankWhenAllNumbersMatch() {
        final List<LottoNumber> matchNumber = List.of(
            new LottoNumber(1), new LottoNumber(2),
            new LottoNumber(3), new LottoNumber(4),
            new LottoNumber(5), new LottoNumber(6)
        );
        final List<LottoNumber> nonMatchNumber = List.of();
        final LottoNumber bonusNumber = new LottoNumber(45);
        final Lotto winningLotto = new Lotto(merge(matchNumber, nonMatchNumber));
        final LastWeekWinningLotto lastWeekWinningLotto = new LastWeekWinningLotto(winningLotto, bonusNumber);

        assertThat(lastWeekWinningLotto.calculateLottoRank(otherLotto)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("5개의 번호와 보너스 번호가 일치하는 경우 2등을 반환한다")
    void shouldCalculateSecondRankWhenFiveNumbersAndBonusMatch() {
        final List<LottoNumber> matchNumber = List.of(
            new LottoNumber(1), new LottoNumber(2),
            new LottoNumber(3), new LottoNumber(4),
            new LottoNumber(5)
        );
        final List<LottoNumber> nonMatchNumber = List.of(new LottoNumber(45));
        final LottoNumber bonusNumber = new LottoNumber(6);
        final Lotto winningLotto = new Lotto(merge(matchNumber, nonMatchNumber));
        final LastWeekWinningLotto lastWeekWinningLotto = new LastWeekWinningLotto(winningLotto, bonusNumber);

        assertThat(lastWeekWinningLotto.calculateLottoRank(otherLotto)).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("5개의 번호만 일치하는 경우 3등을 반환한다")
    void shouldCalculateThirdRankWhenFiveNumbersMatch() {
        final List<LottoNumber> matchNumber = List.of(
            new LottoNumber(1), new LottoNumber(2),
            new LottoNumber(3), new LottoNumber(4),
            new LottoNumber(5)
        );
        final List<LottoNumber> nonMatchNumber = List.of(new LottoNumber(45));
        final LottoNumber bonusNumber = new LottoNumber(9);
        final Lotto winningLotto = new Lotto(merge(matchNumber, nonMatchNumber));
        final LastWeekWinningLotto lastWeekWinningLotto = new LastWeekWinningLotto(winningLotto, bonusNumber);

        assertThat(lastWeekWinningLotto.calculateLottoRank(otherLotto)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("4개의 번호만 일치하는 경우 4등을 반환한다")
    void shouldCalculateFourthRankWhenFourNumbersMatch() {
        final List<LottoNumber> matchNumber = List.of(
            new LottoNumber(1), new LottoNumber(2),
            new LottoNumber(3), new LottoNumber(4)
        );
        final List<LottoNumber> nonMatchNumber = List.of(
            new LottoNumber(44), new LottoNumber(45)
        );
        final LottoNumber bonusNumber = new LottoNumber(9);
        final Lotto winningLotto = new Lotto(merge(matchNumber, nonMatchNumber));
        final LastWeekWinningLotto lastWeekWinningLotto = new LastWeekWinningLotto(winningLotto, bonusNumber);

        assertThat(lastWeekWinningLotto.calculateLottoRank(otherLotto)).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    @DisplayName("3개의 번호만 일치하는 경우 5등을 반환한다")
    void shouldCalculateFifthRankWhenThreeNumbersMatch() {
        final List<LottoNumber> matchNumber = List.of(
            new LottoNumber(1), new LottoNumber(2),
            new LottoNumber(3)
        );
        final List<LottoNumber> nonMatchNumber = List.of(
            new LottoNumber(43), new LottoNumber(44),
            new LottoNumber(45)
        );
        final LottoNumber bonusNumber = new LottoNumber(9);
        final Lotto winningLotto = new Lotto(merge(matchNumber, nonMatchNumber));
        final LastWeekWinningLotto lastWeekWinningLotto = new LastWeekWinningLotto(winningLotto, bonusNumber);

        assertThat(lastWeekWinningLotto.calculateLottoRank(otherLotto)).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    @DisplayName("2개의 이하의 번호가 일치하는 경우 NONE 를 반환한다.")
    void shouldReturnNoneRankWhenTwoOrFewerNumbersMatch() {
        final List<LottoNumber> matchNumber = List.of(
            new LottoNumber(1), new LottoNumber(2)
        );
        final List<LottoNumber> nonMatchNumber = List.of(
            new LottoNumber(42), new LottoNumber(43),
            new LottoNumber(44), new LottoNumber(45)
        );
        final LottoNumber bonusNumber = new LottoNumber(9);
        final Lotto winningLotto = new Lotto(merge(matchNumber, nonMatchNumber));
        final LastWeekWinningLotto lastWeekWinningLotto = new LastWeekWinningLotto(winningLotto, bonusNumber);

        assertThat(lastWeekWinningLotto.calculateLottoRank(otherLotto)).isEqualTo(LottoRank.NONE);
    }

    private static List<LottoNumber> merge(final List<LottoNumber> matchNumber, final List<LottoNumber> nonMatchNumber) {
        return Stream
            .concat(matchNumber.stream(), nonMatchNumber.stream())
            .collect(Collectors.toList());
    }

}