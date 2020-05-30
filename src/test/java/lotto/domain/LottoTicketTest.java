package lotto.domain;

import lotto.matcher.LottoMatcher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @ParameterizedTest
    @MethodSource("provideLottoNumberAndWinnerNumbers")
    @DisplayName("로또 번호 당첨 결과 테스트")
    void calculateLottoMatchNumber(List<Lotto> lotto, List<Lotto> winners, int matchCount, int bonusNumber, boolean matchBonusBall) {
        LottoTicket lottoTicket = this.createLottoNumbers(lotto);
        LottoMatcher lottoMatcher = lottoTicket.findLottoMatchResult(createLottoWinnerNumbers(winners, bonusNumber));
        assertThat(lottoMatcher.getMatchingCount()).isEqualTo(matchCount);
        assertThat(lottoMatcher.isMatchBonusBall()).isEqualTo(matchBonusBall);
    }

    private static Stream<Arguments> provideLottoNumberAndWinnerNumbers() {
        return Stream.of(
                Arguments.of(createLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)), createLottoNumber(Arrays.asList(4, 5, 6, 7, 8, 9)), 3, 10, false),
                Arguments.of(createLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)), createLottoNumber(Arrays.asList(3, 4, 5, 6, 7, 8)), 4, 10, false),
                Arguments.of(createLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)), createLottoNumber(Arrays.asList(2, 3, 4, 5, 6, 7)), 5, 1, true),
                Arguments.of(createLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)), createLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)), 6, 7, false)
        );
    }

    private LottoTicket createLottoNumbers(List<Lotto> lottos) {
        return new LottoTicket(lottos);
    }

    private static List<Lotto> createLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> new Lotto(number))
                .collect(Collectors.toList());
    }

    private LottoWinnerNumber createLottoWinnerNumbers(List<Lotto> winnerNumbers, int bonusBall) {
        return new LottoWinnerNumber(winnerNumbers, new Lotto(bonusBall));
    }

}