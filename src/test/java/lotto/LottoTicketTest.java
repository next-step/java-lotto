package lotto;

import lotto.domain.CustomLottoTicket;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.util.ListConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTicketTest {

    @ParameterizedTest
    @DisplayName("생성한 로또 번호의 갯수가 6이 아니면 Fail")
    @MethodSource("provideInvalidLottoSize")
    void FailIfLottoNumbersSizeIsNotSix(List<LottoNumber> input) {
        assertThatThrownBy(() -> new CustomLottoTicket(input))
                .isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> provideInvalidLottoSize() {
        return Stream.of(
                Arguments.of(ListConverter.convertCommaStringToLottoNumbers("1,2,3,4,5,6,7")),
                Arguments.of(ListConverter.convertCommaStringToLottoNumbers("1,2,3,4,5")),
                Arguments.of(ListConverter.convertCommaStringToLottoNumbers("1,2,3")),
                Arguments.of(ListConverter.convertCommaStringToLottoNumbers("1,2"))
        );
    }

    @ParameterizedTest
    @DisplayName("생성한 로또 번호에 중복이 있으면 Fail")
    @MethodSource("provideDuplicateLottoNumber")
    void FailIfDuplicateNumberExistInLotto(List<LottoNumber> input) {
        assertThatThrownBy(() -> new CustomLottoTicket(input))
                .isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> provideDuplicateLottoNumber() {
        return Stream.of(
                Arguments.of(ListConverter.convertCommaStringToLottoNumbers("1,1,2,3,4,5")),
                Arguments.of(ListConverter.convertCommaStringToLottoNumbers("1,2,2,2,5,6")),
                Arguments.of(ListConverter.convertCommaStringToLottoNumbers("3,3,3,4,6,6")),
                Arguments.of(ListConverter.convertCommaStringToLottoNumbers("1,1,3,3,6,6"))
        );
    }

    @ParameterizedTest
    @DisplayName("당첨 로또의 갯수에 맞는 Rank를 반환하는지 테스트")
    @MethodSource("provideLottoTicketForRank")
    void IsRankEqualWithMatchingCountOfLottoNumbers(List<LottoNumber> left, List<LottoNumber> right, LottoNumber bonusNumber, Rank expected) {
        CustomLottoTicket buyingLottoTicket = new CustomLottoTicket(left);
        CustomLottoTicket winningLottoTicket = new CustomLottoTicket(right);

        Rank actual = buyingLottoTicket.getRankBy(winningLottoTicket, bonusNumber);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottoTicketForRank() {
        List<LottoNumber> lottoNumbersOneToSix = ListConverter.convertCommaStringToLottoNumbers("1,2,3,4,5,6");
        return Stream.of(
                Arguments.of(ListConverter.convertCommaStringToLottoNumbers("1,2,3,4,5,6"),
                        lottoNumbersOneToSix, new LottoNumber(45), Rank.FIRST),
                Arguments.of(ListConverter.convertCommaStringToLottoNumbers("1,2,3,4,5,16"),
                        lottoNumbersOneToSix, new LottoNumber(16), Rank.SECOND),
                Arguments.of(ListConverter.convertCommaStringToLottoNumbers("1,2,3,4,5,16"),
                        lottoNumbersOneToSix, new LottoNumber(26), Rank.THIRD),
                Arguments.of(ListConverter.convertCommaStringToLottoNumbers("1,2,3,4,15,16"),
                        lottoNumbersOneToSix, new LottoNumber(45), Rank.FOURTH),
                Arguments.of(ListConverter.convertCommaStringToLottoNumbers("1,2,3,14,15,16"),
                        lottoNumbersOneToSix, new LottoNumber(45), Rank.FIFTH),
                Arguments.of(ListConverter.convertCommaStringToLottoNumbers("1,2,13,14,15,16"),
                        lottoNumbersOneToSix, new LottoNumber(45), Rank.MISS)
        );
    }

}
