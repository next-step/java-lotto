package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @DisplayName("요청받은대로 구매가 잘되는지")
    @ParameterizedTest(name = "[{index}] autoLineCount: {0}, publishDetails: {1}")
    @MethodSource("publishArguments")
    void publish(int expectedAutoLineCount, PublishDetails publishDetails) {
        LottoTicket lottoTicket = LottoTicket.publish(publishDetails, noShuffleStrategy());

        List<LottoNumbers> expectedAutoLines = nCopies(expectedAutoLineCount, LottoNumbers.of(asList(1, 2, 3, 4, 5, 6)));
        assertThat(lottoTicket).isEqualTo(new LottoTicket(expectedAutoLines, publishDetails.manualLottoLines()));
    }

    private static Stream<Arguments> publishArguments() {
        Dollars dollars = new Dollars(10000);
        LottoNumbers manualLottoLine = LottoNumbers.of(asList(11, 12, 13, 14, 15, 16));
        return Stream.of(
                Arguments.of(10, new PublishDetails(dollars, emptyList())),
                Arguments.of(7, new PublishDetails(dollars, nCopies(3, manualLottoLine))),
                Arguments.of(0, new PublishDetails(dollars, nCopies(10, manualLottoLine)))
        );
    }

    @DisplayName("통계가 잘구해지는지")
    @Test
    void rank() {
        //given
        int bonusNumber = 40;
        LottoNumbers fiveMatchedAndBonus = LottoNumbers.of(asList(1, 2, 3, 4, 5, bonusNumber));
        LottoNumbers sixMatched = LottoNumbers.of(asList(1, 2, 3, 4, 5, 6));
        LottoNumbers fiveMatched = LottoNumbers.of(asList(1, 2, 3, 4, 5, 7));
        LottoNumbers fiveMatched2 = LottoNumbers.of(asList(1, 2, 3, 4, 5, 10));
        LottoNumbers threeMatched = LottoNumbers.of(asList(1, 2, 3, 9, 8, 7));
        List<LottoNumbers> autoLottoLines = asList(sixMatched, fiveMatched, fiveMatched2, threeMatched, fiveMatchedAndBonus);

        LottoNumbers twoMatched = LottoNumbers.of(asList(1, 2, 10, 9, 8, 7));
        List<LottoNumbers> manualLottoLines = singletonList(twoMatched);

        LottoTicket lottoTicket = new LottoTicket(autoLottoLines, manualLottoLines);

        //when
        LottoNumbers winningNumbers = LottoNumbers.of(asList(1, 2, 3, 4, 5, 6));
        Statistics statistics = lottoTicket.rank(winningNumbers, new LottoNumber(bonusNumber));

        //then
        Map<Grade, Long> expectedGrades = new HashMap<>();
        expectedGrades.put(Grade.FIRST, 1L);
        expectedGrades.put(Grade.SECOND, 2L);
        expectedGrades.put(Grade.BONUS, 1L);
        expectedGrades.put(Grade.THIRD, 0L);
        expectedGrades.put(Grade.FOURTH, 1L);

        Statistics expected = new Statistics(expectedGrades, new Dollars(6000));
        assertThat(statistics).isEqualTo(expected);
    }

    private ShuffleStrategy noShuffleStrategy() {
        return lottoNumbers -> {};
    }

}
