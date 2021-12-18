package lotto.domain;

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

public class LottoTicketTest {

    @DisplayName("생성된 로또 번호는 6개다.")
    @Test
    void generate() {
        LottoTicket lottoTicket = LottoTicketFactory.generate();
        int size = lottoTicket.size();
        assertThat(size).isEqualTo(6);
    }

    @DisplayName("LottoTicket의 rank를 조회한다")
    @MethodSource("provideLottoRankSource")
    @ParameterizedTest
    void getLottoRank(String winningNumbers, String bonus, LottoTicket lottoTicket, LottoRank lottoRank) {
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from(winningNumbers, bonus);
        assertThat(
                lottoTicket.getLottoRank(lottoWinningNumbers)
        ).isEqualTo(lottoRank);
    }


    private static Stream<Arguments> provideLottoRankSource() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4, 5, 6", "45", LottoTicket.from(1, 2, 3, 4, 5, 6), LottoRank.FIRST),
                Arguments.of("1, 2, 3, 4, 5, 6", "45", LottoTicket.from(1, 2, 3, 4, 5, 45), LottoRank.SECOND),
                Arguments.of("1, 2, 3, 4, 5, 6", "45", LottoTicket.from(1, 2, 3, 4, 5, 43), LottoRank.THIRD),
                Arguments.of("1, 2, 3, 4, 5, 6", "45", LottoTicket.from(1, 2, 3, 4, 43, 44), LottoRank.FOURTH),
                Arguments.of("1, 2, 3, 4, 5, 6", "45", LottoTicket.from(1, 2, 3, 30, 31, 32), LottoRank.FIFTH),
                Arguments.of("1, 2, 3, 4, 5, 6", "45", LottoTicket.from(1, 2, 33, 30, 31, 32), LottoRank.MISS)

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
