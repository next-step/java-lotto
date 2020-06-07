package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {

    @DisplayName("3 ~ 6개가 일치하는 경우 적절한 Prize 객체가 반환")
    @ParameterizedTest
    @MethodSource("source_award_inRank_shouldSucceed")
    public void award_inRank_shouldSucceed(List<Integer> winNumberList, List<Integer> lottoNumberList, Prize expected) {
        Lotto winLotto = new Lotto(winNumberList);
        Lotto lotto = new Lotto(lottoNumberList);
        Prize result = Prize.award(winLotto, false, lotto);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> source_award_inRank_shouldSucceed() {
        return Stream.of(
                Arguments.of(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}), Arrays.asList(new Integer[]{1, 2, 3, 7, 8, 9}), Prize.FIFTH),
                Arguments.of(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}), Arrays.asList(new Integer[]{1, 2, 3, 4, 7, 8}), Prize.FOURTH),
                Arguments.of(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}), Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 7}), Prize.THIRD),
                Arguments.of(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}), Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}), Prize.FIRST));
    }

    @DisplayName("5개 + 보너스 넘버가 일치하는 경우 적절한 Second Prize 객체가 반환")
    @ParameterizedTest
    @MethodSource("source_secondPrize_shouldSucceed")
    public void secondPrize_shouldSucceed(List<Integer> winNumberList, List<Integer> lottoNumberList, Prize expected) {
        Lotto winLotto = new Lotto(winNumberList);
        Lotto lotto = new Lotto(lottoNumberList);
        Prize result = Prize.award(winLotto, true, lotto);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> source_secondPrize_shouldSucceed() {
        return Stream.of(
                Arguments.of(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}), Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 10}), Prize.SECOND),
                Arguments.of(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}), Arrays.asList(new Integer[]{1, 2, 20, 3, 5, 4}), Prize.SECOND));
    }

    @DisplayName("0 ~ 2개가 일치하는 경우 디폴트 Prize 객체(UNRANKED)가 반환")
    @ParameterizedTest
    @MethodSource("source_award_unRank_shouldSucceed")
    public void award_unRank_shouldSucceed(List<Integer> winNumberList, List<Integer> lottoNumberList, Prize expected) {
        Lotto winLotto = new Lotto(winNumberList);
        Lotto lotto = new Lotto(lottoNumberList);
        Prize result = Prize.award(winLotto, false, lotto);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> source_award_unRank_shouldSucceed() {
        return Stream.of(
                Arguments.of(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}), Arrays.asList(new Integer[]{10, 11, 12, 13, 14, 15}), Prize.UNRANKED),
                Arguments.of(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}), Arrays.asList(new Integer[]{1, 2, 10, 11, 12, 13}), Prize.UNRANKED),
                Arguments.of(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}), Arrays.asList(new Integer[]{1, 10, 11, 12, 13, 14}), Prize.UNRANKED));
    }
}
