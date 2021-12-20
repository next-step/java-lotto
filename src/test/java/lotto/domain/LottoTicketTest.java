package lotto.domain;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {

    @DisplayName("LottoTicket의 LottoNumber수가 6개가 아니면 예외가 발생한다..")
    @MethodSource("providesValueOfFrom")
    @ParameterizedTest
    void from(List<LottoNumber> lottoNumbers) {
        assertThatThrownBy(() ->
                LottoTicket.from(lottoNumbers))
                .isInstanceOf(LottoException.class);
    }

    private static Stream<Arguments> providesValueOfFrom() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(
                                LottoNumber.from(1),
                                LottoNumber.from(2),
                                LottoNumber.from(3),
                                LottoNumber.from(4),
                                LottoNumber.from(5),
                                LottoNumber.from(6),
                                LottoNumber.from(7)
                        )),
                Arguments.of(
                        Arrays.asList(
                                LottoNumber.from(1),
                                LottoNumber.from(2),
                                LottoNumber.from(3),
                                LottoNumber.from(4),
                                LottoNumber.from(5)
                        ))
        );
    }

    @DisplayName("LottoTicket의 rank를 조회한다")
    @MethodSource("provideValueOfGetLottoRank")
    @ParameterizedTest
    void getLottoRank(String winningNumbers, String bonus, LottoTicket lottoTicket, LottoRank lottoRank) {
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from(winningNumbers, bonus);
        assertThat(
                lottoTicket.getLottoRank(lottoWinningNumbers)
        ).isEqualTo(lottoRank);
    }


    private static Stream<Arguments> provideValueOfGetLottoRank() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4, 5, 6", "45", LottoTicket.from(1, 2, 3, 4, 5, 6), LottoRank.FIRST),
                Arguments.of("1, 2, 3, 4, 5, 6", "45", LottoTicket.from(1, 2, 3, 4, 5, 45), LottoRank.SECOND),
                Arguments.of("1, 2, 3, 4, 5, 6", "45", LottoTicket.from(1, 2, 3, 4, 5, 43), LottoRank.THIRD),
                Arguments.of("1, 2, 3, 4, 5, 6", "45", LottoTicket.from(1, 2, 3, 4, 43, 44), LottoRank.FOURTH),
                Arguments.of("1, 2, 3, 4, 5, 6", "45", LottoTicket.from(1, 2, 3, 30, 31, 32), LottoRank.FIFTH),
                Arguments.of("1, 2, 3, 4, 5, 6", "45", LottoTicket.from(1, 2, 33, 30, 31, 32), LottoRank.MISS),
                Arguments.of("1, 2, 3, 4, 5, 6", "45", LottoTicket.from(1, 36, 33, 30, 31, 32), LottoRank.MISS),
                Arguments.of("1, 2, 3, 4, 5, 6", "45", LottoTicket.from(45, 43, 33, 30, 31, 32), LottoRank.MISS)

        );
    }

    @DisplayName("LottoTicket 로또 당첨 번호를 전달하면 일치하는 번호의 개수를 알 수 있다.")
    @Test
    void countOfMatch() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 45;
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from(winningNumbers, bonus);
        LottoTicket lottoTicket = LottoTicket.from(1, 2, 3, 4, 43, 45);
        int countOfMatch = lottoTicket.countOfMatch(lottoWinningNumbers);
        assertThat(countOfMatch).isEqualTo(4);

    }

    @DisplayName("LottoTicket이 보너스 숫자를 가지고 있는지 알 수 있다.")
    @CsvSource(value = {"45:true", "23:false"}, delimiter = ':')
    @ParameterizedTest
    void matchesBonus(int bonus, boolean matchesBonus) {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from(winningNumbers, bonus);
        LottoTicket lottoTicket = LottoTicket.from(1, 2, 3, 4, 5, 45);
        assertThat(lottoTicket.matchesBonus(lottoWinningNumbers)).isEqualTo(matchesBonus);
    }

}
