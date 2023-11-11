package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnerNumbersTest {
    @Test
    @DisplayName("WinnerNumbers 객체를 생성할 때 당첨 번호를 ', '로 구분하여 입력하면, 해당 당첨번호를 가진 Set을 반환한다.")
    void testCreateWinnerNumbersWithCommaSeparatedInput() {
        // given
        String input = "10, 12, 30, 34, 40, 45";
        WinnerNumbers winnerNumbers = new WinnerNumbers(input);
        final String[] inputs = input.split(", ");
        Set<Integer> expected = Arrays.stream(inputs)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        // when
        Set<Integer> nums = winnerNumbers.nums();

        // then
        assertThat(nums)
                .hasSize(inputs.length)
                .containsExactlyInAnyOrderElementsOf(expected);
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
    void testWinnerNumbersHasUniqueSixNumbers(final String userInput) {
        //given, when, then
        assertThatThrownBy(() -> new WinnerNumbers(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("matchLottos 메서드의 입력으로 Lotto List를 넣으면, 입력한 Lotto List의 당첨 통계를 구한다.")
    void testCheckLottoWinningNumbers() {
        //given
        final WinnerNumbers winnerNumbers = new WinnerNumbers("1, 2, 3, 4, 5, 6");
        final Map<LottoRank, Integer> lottoRankInputCounter = generateLottoRankInputCounter();
        final List<Lotto> lottos = new ArrayList<>();

        addLottoToListUsingRankInputCounter(lottos, lottoRankInputCounter);

        //when
        LottoResults lottoResults = winnerNumbers.matchLottos(lottos);

        //then
        assertThat(lottoResults.getCount(LottoRank.FIRST)).isEqualTo(lottoRankInputCounter.get(LottoRank.FIRST));
        assertThat(lottoResults.getCount(LottoRank.SECOND)).isEqualTo(lottoRankInputCounter.get(LottoRank.SECOND));
        assertThat(lottoResults.getCount(LottoRank.THIRD)).isEqualTo(lottoRankInputCounter.get(LottoRank.THIRD));
        assertThat(lottoResults.getCount(LottoRank.FOURTH)).isEqualTo(lottoRankInputCounter.get(LottoRank.FOURTH));
    }

    private Map<LottoRank, Integer> generateLottoRankInputCounter() {
        Map<LottoRank, Integer> lottoInput = new EnumMap<>(LottoRank.class);

        lottoInput.put(LottoRank.FIRST, 1);
        lottoInput.put(LottoRank.SECOND, 2);
        lottoInput.put(LottoRank.THIRD, 3);
        lottoInput.put(LottoRank.FOURTH, 4);

        return lottoInput;
    }

    private void addLottoToListUsingRankInputCounter(final List<Lotto> lottos, final Map<LottoRank, Integer> inputFixture) {
        addFirstRankLotto(lottos, inputFixture.get(LottoRank.FIRST));
        addSecondRankLotto(lottos, inputFixture.get(LottoRank.SECOND));
        addThirdRankLotto(lottos, inputFixture.get(LottoRank.THIRD));
        addFourthRankLotto(lottos, inputFixture.get(LottoRank.FOURTH));
    }

    private void addFirstRankLotto(final List<Lotto> lottos, final Integer integer) {
        for (int i = 0; i < integer; i++) {
            lottos.add(new Lotto(Set.of(1, 2, 3, 4, 5, 6)));
        }
    }

    private void addSecondRankLotto(final List<Lotto> lottos, final Integer integer) {
        for (int i = 0; i < integer; i++) {
            lottos.add(new Lotto(Set.of(1, 2, 3, 4, 5, 7)));
        }
    }

    private void addThirdRankLotto(final List<Lotto> lottos, final Integer integer) {
        for (int i = 0; i < integer; i++) {
            lottos.add(new Lotto(Set.of(1, 2, 3, 4, 7, 8)));
        }
    }

    private void addFourthRankLotto(final List<Lotto> lottos, final Integer integer) {
        for (int i = 0; i < integer; i++) {
            lottos.add(new Lotto(Set.of(1, 2, 3, 7, 8, 9)));
        }
    }
}
