package lotto;

import lotto.domain.CustomLottoTicket;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTicketTest {

    @ParameterizedTest
    @DisplayName("생성한 로또 번호의 갯수가 6이 아니면 Fail")
    @MethodSource("provideInvalidLottoSize")
    void FailIfLottoNumbersSizeIsNotSix(List<Integer> input) {
        assertThatThrownBy(() -> new CustomLottoTicket(input))
                .isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> provideInvalidLottoSize() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6,7)),
                Arguments.of(Arrays.asList(1,2,3,4,5)),
                Arguments.of(Arrays.asList(1,2,3)),
                Arguments.of(Arrays.asList(1,2))
        );
    }

    @ParameterizedTest
    @DisplayName("생성한 로또 번호에 중복이 있으면 Fail")
    @MethodSource("provideDuplicateLottoNumber")
    void FailIfDuplicateNumberExistInLotto(List<Integer> input) {
        assertThatThrownBy(() -> new CustomLottoTicket(input))
                .isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> provideDuplicateLottoNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,1,2,3,4,5)),
                Arguments.of(Arrays.asList(1,2,2,2,5,6)),
                Arguments.of(Arrays.asList(3,3,3,4,6,6)),
                Arguments.of(Arrays.asList(1,1,3,3,6,6))
        );
    }

    @ParameterizedTest
    @DisplayName("로또에서 사용하는 번호가 아니면 Fail")
    @MethodSource("provideOutOfBoundLottoNumber")
    void FailIfLottoNumberIsNotLottoUsageNumber(List<Integer> input) {
        assertThatThrownBy(() -> new CustomLottoTicket(input))
                .isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> provideOutOfBoundLottoNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(0,1,2,3,4,45)),
                Arguments.of(Arrays.asList(1,2,3,4,5,46)),
                Arguments.of(Arrays.asList(0,2,3,4,5,46)),
                Arguments.of(Arrays.asList(100,1,3,3,6,6))
        );
    }

    @ParameterizedTest
    @DisplayName("당첨 로또의 갯수에 맞는 Rank를 반환하는지 테스트")
    @MethodSource("provideLottoTicketForRank")
    void IsRankEqualWithMatchingCountOfLottoNumbers(List<Integer> left, List<Integer> right, int bonusNumber, Rank expected) {
        CustomLottoTicket buyingLottoTicket = new CustomLottoTicket(left);
        CustomLottoTicket winningLottoTicket = new CustomLottoTicket(right);

        Rank actual = buyingLottoTicket.getRankBy(winningLottoTicket, bonusNumber);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottoTicketForRank() {
        return Stream.of(
                Arguments.of(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)), new ArrayList<>(Arrays.asList(1,2,3,4,5,6)), 7, Rank.FIRST),
                Arguments.of(new ArrayList<>(Arrays.asList(1,2,3,4,5,7)), new ArrayList<>(Arrays.asList(1,2,3,4,5,6)), 7, Rank.SECOND),
                Arguments.of(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)), new ArrayList<>(Arrays.asList(1,2,3,4,5,45)), 7, Rank.THIRD),
                Arguments.of(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)), new ArrayList<>(Arrays.asList(1,2,3,4,43,45)), 7, Rank.FOURTH),
                Arguments.of(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)), new ArrayList<>(Arrays.asList(1,2,3,42,43,45)), 7, Rank.FIFTH),
                Arguments.of(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)), new ArrayList<>(Arrays.asList(1,2,41,42,43,45)), 7, Rank.MISS)
        );
    }

}
