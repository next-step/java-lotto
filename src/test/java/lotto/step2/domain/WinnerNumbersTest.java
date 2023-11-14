package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnerNumbersTest {
    @Test
    @DisplayName("WinnerNumbers 객체를 생성할 때 당첨 번호를 ', '로 구분하여 입력하면, 해당 당첨번호를 가진 Set을 반환한다.")
    void testCreateWinnerNumbersWithCommaSeparatedInput() {
        // given
        String input = "10, 12, 30, 34, 40, 45";
        int bonusWinnerNumber = 7;
        WinnerNumbers winnerNumbers = new WinnerNumbers(input, bonusWinnerNumber);
        final String[] inputs = input.split(", ");
        Set<LottoNumber> expected = Arrays.stream(inputs)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        // when
        Set<LottoNumber> nums = winnerNumbers.nums();

        // then
        assertThat(nums)
                .hasSize(inputs.length)
                .containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    @DisplayName("WinnerNumbers 숫자를 수정하려고 하면, UnsupportedOperationException 예외가 발생한다.")
    void throwUnsupportedOperationExceptionWhenModifyNumbers() {
        // given
        int bonusWinnerNumber = 1;

        WinnerNumbers winnerNumbers = new WinnerNumbers("10, 12, 30, 34, 40, 45", bonusWinnerNumber);
        Set<LottoNumber> nums = winnerNumbers.nums();

        // when
        // then
        assertThatThrownBy(() -> nums.remove(10))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 12, 30, 34, 40, 45})
    @DisplayName("보너스 번호로 당첨 번호랑 중복되게 입력하면, IllegalArgumentException 예외가 발생한다.")
    void throwIllegalArgumentExceptionForDuplicateBonusNumber(final int bonusWinnerNumber) {
        // given, when, then
        assertThatThrownBy(() -> new WinnerNumbers("10, 12, 30, 34, 40, 45", bonusWinnerNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("bonus winner number must not be in winner nums");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "10, 12, 30, 34",
            "10, 12, 30, 34, 45",
            "10, 12, 30, 34, 40, 47",
            "10, 12, 30, 34, 40, -1",
            "10, 12, 30, 34, 40, 49, 50"
    })
    @DisplayName("WinnerNumbers 객체를 생성할 때 입력 번호로 1 ~ 45까지의 수를 중복되지 않게 6개를 입력하지 않으면, IllegalArgumentException 예외가 발생한다.")
    void testWinnerNumbersHasUniqueSixNumbers(final String winnerNumbers) {
        //given
        int bonusWinnerNumber = 1;

        //when, then
        assertThatThrownBy(() -> new WinnerNumbers(winnerNumbers, bonusWinnerNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("matchLottos 메서드의 입력으로 Lotto List를 넣으면, 입력한 Lotto List의 당첨 통계를 구한다. - 1등 [당첨 번호 6개]")
    void testCheckLottoWinningNumbers_LottoRank_FIRST() {
        //given
        int bonusWinnerNumber = 7;

        final WinnerNumbers winnerNumbers = new WinnerNumbers("1, 2, 3, 4, 5, 6", bonusWinnerNumber);
        final List<Lotto> lottos = List.of(new Lotto(Set.of(1, 2, 3, 4, 5, 6)));

        //when
        LottoResults lottoResults = winnerNumbers.matchLottos(lottos);

        //then
        assertThat(lottoResults.getCount(LottoRank.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("matchLottos 메서드의 입력으로 Lotto List를 넣으면, 입력한 Lotto List의 당첨 통계를 구한다. - 2등 [당첨 번호 5개, 보너스 번호 일치]")
    void testCheckLottoWinningNumbers_LottoRank_SECOND() {
        //given
        int bonusWinnerNumber = 7;

        final WinnerNumbers winnerNumbers = new WinnerNumbers("1, 2, 3, 4, 5, 6", bonusWinnerNumber);
        final List<Lotto> lottos = List.of(
                new Lotto(Set.of(1, 2, 3, 4, 5, 7)),
                new Lotto(Set.of(1, 2, 3, 4, 6, 7)));

        //when
        LottoResults lottoResults = winnerNumbers.matchLottos(lottos);

        //then
        assertThat(lottoResults.getCount(LottoRank.SECOND)).isEqualTo(2);
    }

    @Test
    @DisplayName("matchLottos 메서드의 입력으로 Lotto List를 넣으면, 입력한 Lotto List의 당첨 통계를 구한다. - 3등 [당첨 번호 5개, 보너스 번호 불일치]")
    void testCheckLottoWinningNumbers_LottoRank_THIRD() {
        //given
        int bonusWinnerNumber = 7;

        final WinnerNumbers winnerNumbers = new WinnerNumbers("1, 2, 3, 4, 5, 6", bonusWinnerNumber);
        final List<Lotto> lottos = List.of(
                new Lotto(Set.of(1, 2, 3, 4, 5, 8)),
                new Lotto(Set.of(1, 2, 3, 4, 6, 8)),
                new Lotto(Set.of(2, 3, 4, 5, 6, 8))
        );

        //when
        LottoResults lottoResults = winnerNumbers.matchLottos(lottos);

        //then
        assertThat(lottoResults.getCount(LottoRank.THIRD)).isEqualTo(3);
    }

    @Test
    @DisplayName("matchLottos 메서드의 입력으로 Lotto List를 넣으면, 입력한 Lotto List의 당첨 통계를 구한다. - 4등 [당첨 번호 4개]")
    void testCheckLottoWinningNumbers_LottoRank_FOURTH() {
        //given
        int bonusWinnerNumber = 7;

        final WinnerNumbers winnerNumbers = new WinnerNumbers("1, 2, 3, 4, 5, 6", bonusWinnerNumber);
        final List<Lotto> lottos = List.of(
                new Lotto(Set.of(1, 2, 3, 4, 7, 8)),
                new Lotto(Set.of(2, 3, 4, 6, 7, 8)),
                new Lotto(Set.of(1, 2, 3, 4, 10, 11)),
                new Lotto(Set.of(3, 4, 5, 6, 8, 10))
        );

        //when
        LottoResults lottoResults = winnerNumbers.matchLottos(lottos);

        //then
        assertThat(lottoResults.getCount(LottoRank.FOURTH)).isEqualTo(4);
    }

    @Test
    @DisplayName("matchLottos 메서드의 입력으로 Lotto List를 넣으면, 입력한 Lotto List의 당첨 통계를 구한다. - 5등 [당첨 번호 3개]")
    void testCheckLottoWinningNumbers_LottoRank_FIFTH() {
        //given
        int bonusWinnerNumber = 7;

        final WinnerNumbers winnerNumbers = new WinnerNumbers("1, 2, 3, 4, 5, 6", bonusWinnerNumber);
        final List<Lotto> lottos = List.of(
                new Lotto(Set.of(1, 2, 3, 7, 8, 10)),
                new Lotto(Set.of(2, 3, 4, 7, 8, 11)),
                new Lotto(Set.of(1, 2, 6, 7, 10, 11)),
                new Lotto(Set.of(3, 4, 6, 8, 10, 15)),
                new Lotto(Set.of(1, 3, 6, 10, 15, 33))
        );

        //when
        LottoResults lottoResults = winnerNumbers.matchLottos(lottos);

        //then
        assertThat(lottoResults.getCount(LottoRank.FIFTH)).isEqualTo(5);
    }
}
