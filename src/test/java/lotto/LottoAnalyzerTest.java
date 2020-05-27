package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAnalyzerTest {

    private int round = 1;
    private LottoAnalyzer lottoAnalyzer;

    @BeforeEach
    void setUp(){
        LottoGame lottoGame = new LottoGame();
        lottoGame.add(round, WinningLotto.of(LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6)), 8));

        lottoAnalyzer = new LottoAnalyzer(lottoGame);
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

    @ParameterizedTest
    @MethodSource("generate_lotto_tickets_with_revenue_rate_and_include_bonus_number")
    @DisplayName("보너스 번호 포함 2등 티켓의 수익률을 계산한다.")
    void 보너스번호_포함_수익률_계산_테스트(List<LottoTicket> lottoTickets, double expected) {
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

    private static Stream<Arguments> generate_lotto_tickets_with_revenue_rate_and_include_bonus_number() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(
                                LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 8)),
                                LottoTicket.of(Arrays.asList(10, 11, 12, 13, 14, 15)),
                                LottoTicket.of(Arrays.asList(10, 11, 12, 13, 14, 15)),
                                LottoTicket.of(Arrays.asList(10, 11, 12, 13, 14, 15)),
                                LottoTicket.of(Arrays.asList(10, 11, 12, 13, 14, 15))
                        ), 6000.0)
        );
    }
}
