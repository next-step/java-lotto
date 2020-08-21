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

public class LottoTicketsTest {
    private static final LottoTicketMaker LOTTO_TICKET_RANDOM_MAKER = new LottoTicketRandomMaker();

    @DisplayName("로또 구매금액에 따라 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5000:5", "20000:20", "210000:210"}, delimiter = ':')
    void create_tickets_random(String lottoMoney, int expectedBuyCount) {
        BuyCount buyCount = BuyCount.of(lottoMoney);
        LottoTickets lottoTickets = LottoTickets.of(buyCount, LOTTO_TICKET_RANDOM_MAKER);

        assertThat(lottoTickets.number()).isEqualTo(expectedBuyCount);
    }

    @DisplayName("LottoTickets - WinningResult 생성 테스트")
    @ParameterizedTest
    @MethodSource("makeForGettingWinningResultData")
    void getWinningResult(BuyCount buyCount, String selectedLottoNumber,
                          String winningLottoNumbers, String bonusNumber,
                          LottoRank rank, long rankCount, double expectedWinningRate) {
        LottoTickets lottoTickets = LottoTickets.of(buyCount, new LottoTicketOneSelectMaker(selectedLottoNumber));

        WinningLotto winningLotto = WinningLotto.of(winningLottoNumbers, bonusNumber);
        WinningResult winningResult = lottoTickets.getWinningResult(winningLotto);

        assertThat(winningResult.getRankCount(rank)).isEqualTo(rankCount);
        assertThat(winningResult.calculateWinningRate()).isEqualTo(expectedWinningRate);
    }

    private static Stream<Arguments> makeForGettingWinningResultData() {
        return Stream.of(
                Arguments.of(BuyCount.of("3000"), "1,2,3,4,11,12", "1,2,3,4,5,6", "7"
                        , LottoRank.THIRD, 3, (50_000*3)/3000.0),
                Arguments.of(BuyCount.of("1000"), "1,2,3,4,11,12", "1,2,3,4,5,6", "7"
                        , LottoRank.FIRST, 0, 50_000/1000.0),
                Arguments.of(BuyCount.of("1000"), "1,2,3,4,5,7", "1,2,3,4,5,6", "7"
                        , LottoRank.SECOND_BONUS, 1, 30_000_000/1000.0),
                Arguments.of(BuyCount.of("5000"), "1,2,10,11,12,13", "1,2,3,4,5,6", "7"
                        , LottoRank.DROP, 5, 0/5000.0)
        );
    }

    @DisplayName("LottoTickets merge 테스트")
    @ParameterizedTest
    @MethodSource("makeLottoTicketsMergeData")
    void merge(BuyCount buyCount1, BuyCount buyCount2, List<String> lottoNumbers1, List<String> lottoNumbers2) {
        LottoTickets lottoTicket1 = LottoTickets.of(buyCount1, new LottoTicketSelectMaker(lottoNumbers1));
        LottoTickets lottoTicket2 = LottoTickets.of(buyCount2, new LottoTicketSelectMaker(lottoNumbers2));

        LottoTickets mergedLottoTickets = LottoTickets.merge(lottoTicket1, lottoTicket2);

        assertThat(mergedLottoTickets.number()).isEqualTo(lottoNumbers1.size() + lottoNumbers2.size());
        assertThat(mergedLottoTickets.getLottoTickets()).containsAll(lottoTicket1.getLottoTickets());
        assertThat(mergedLottoTickets.getLottoTickets()).containsAll(lottoTicket2.getLottoTickets());
    }

    private static Stream<Arguments> makeLottoTicketsMergeData() {
        return Stream.of(
                Arguments.of(BuyCount.of(1), BuyCount.of(2)
                        , Arrays.asList("9,10,17,2,31,33"), Arrays.asList("41,23,19,26,44,42", "1,2,3,4,5,6")),
                Arguments.of(BuyCount.of(3), BuyCount.of(1)
                        , Arrays.asList("1,2,3,4,5,6", "31,4,5,22,37,11", "18,33,41,45,6,7"), Arrays.asList("1,2,3,4,5,6"))
        );
    }

}
