package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoAnalyzerTest {

    private int round = 1;
    private LottoAnalyzer lottoAnalyzer;

    @BeforeEach
    void setUp(){
        LottoGame lottoGame = new LottoGame();
        lottoGame.add(round, WinningLotto.of(LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6))));

        lottoAnalyzer = new LottoAnalyzer(lottoGame);
    }

    @MethodSource("generate_lotto_tickets_with_expected_count")
    @ParameterizedTest
    @DisplayName("로또 게임 1회차의 당첨 개수를 검증한다.")
    void 로또_게임_당첨_갯수_테스트(LottoTicket lotto, int expected) {
        long count = lottoAnalyzer.matchingCount(round, lotto);
        assertThat(count).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 6})
    @DisplayName("로또 게임에 존재하지 않는 라운드는 예외가 발생한다.")
    void 로또_게임_matching_count_예외_테스트(int round) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoAnalyzer.matchingCount(round, LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))));
    }

    @ParameterizedTest
    @MethodSource("generate_lotto_tickets")
    @DisplayName("로또 티켓의 순위 결과를 반환한다.")
    void 로또_랭크_변환_테스트(List<LottoTicket> lottoTickets) {
        List<LottoRank> lottoRanks = lottoAnalyzer.gradeTicket(round, lottoTickets);
        assertThat(lottoRanks).hasSize(lottoTickets.size());
    }

    @ParameterizedTest
    @MethodSource("generate_lotto_tickets_with_revenue_rate")
    @DisplayName("내 로또 티켓의 수익률을 계산한다.")
    void 수익률_계산_테스트(List<LottoTicket> lottoTickets, double expected) {
        double revenueRate = lottoAnalyzer.calculateRevenueRate(round, lottoTickets);
        assertThat(revenueRate).isEqualTo(expected);
    }

    private static Stream<Arguments> generate_lotto_tickets() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(
                                LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                LottoTicket.of(Arrays.asList(1, 2, 3, 4, 6, 8)),
                                LottoTicket.of(Arrays.asList(1, 2, 3, 4, 7, 8))
                        )
                )
        );
    }

    private static Stream<Arguments> generate_lotto_tickets_with_revenue_rate() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(
                                LottoTicket.of(Arrays.asList(1, 2, 3, 7, 8, 9)),
                                LottoTicket.of(Arrays.asList(10, 11, 12, 13, 14, 15)),
                                LottoTicket.of(Arrays.asList(10, 11, 12, 13, 14, 15)),
                                LottoTicket.of(Arrays.asList(10, 11, 12, 13, 14, 15)),
                                LottoTicket.of(Arrays.asList(10, 11, 12, 13, 14, 15))
                        ), 1.0),
                Arguments.of(
                        Arrays.asList(
                                LottoTicket.of(Arrays.asList(1, 2, 3, 7, 8, 9)),
                                LottoTicket.of(Arrays.asList(10, 11, 12, 13, 14, 15)),
                                LottoTicket.of(Arrays.asList(10, 11, 12, 13, 14, 15)),
                                LottoTicket.of(Arrays.asList(10, 11, 12, 13, 14, 15)),
                                LottoTicket.of(Arrays.asList(10, 11, 12, 13, 14, 15)),
                                LottoTicket.of(Arrays.asList(10, 11, 12, 13, 14, 15)),
                                LottoTicket.of(Arrays.asList(10, 11, 12, 13, 14, 15)),
                                LottoTicket.of(Arrays.asList(10, 11, 12, 13, 14, 15))
                        ), 0.625)
        );
    }

    private static Stream<Arguments> generate_lotto_tickets_with_expected_count() {
        return Stream.of(
                Arguments.of(LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6)), 6),
                Arguments.of(LottoTicket.of(Arrays.asList(23, 45, 32, 14, 2, 3)), 2),
                Arguments.of(LottoTicket.of(Arrays.asList(6, 1, 32, 14, 2, 3)), 4)
        );
    }
}
