package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoGameTest {

    private LottoGame lottoGame = new LottoGame();
    private int[] winningNumbers;
    private int round = 1;

    @BeforeEach
    void setUp() {
        winningNumbers = new int[]{1, 2, 3, 4, 5, 6};
        lottoGame.add(round, winningNumbers);
    }

    @Test
    @DisplayName("로또 게임을 생성하는데 어떤 예외도 발생하지 않는다.")
    void 로또_게임_생성_테스트() {
        assertThatCode(() -> new LottoGame()).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 게임을 추가하고, 결과 값을 검증한다.")
    void 로또_게임_라운드_get_테스트() {
        List<Integer> getNumbers = lottoGame.get(round);
        assertThat(getNumbers).hasSize(winningNumbers.length);
    }


    @MethodSource("generate_lotto_tickets_with_expected_count")
    @ParameterizedTest
    @DisplayName("로또 게임 1회차의 당첨 개수를 검증한다.")
    void 로또_게임_당첨_갯수_테스트(LottoTicket lotto, int expected) {
        long count = lottoGame.matchingCount(round, lotto);
        assertThat(count).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 6})
    @DisplayName("로또 게임에 존재하지 않는 라운드는 예외가 발생한다.")
    void 로또_게임_matching_count_예외_테스트(int round) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoGame.matchingCount(round, LottoTicket.of(Arrays.asList(1,2,3,4,5,6,7))));
    }

    @ParameterizedTest
    @MethodSource("generate_lotto_tickets")
    @DisplayName("로또 티켓의 순위 결과를 반환한다.")
    void 로또_랭크_변환_테스트(List<LottoTicket> lottoTickets){
        List<LottoRank> lottoRanks = lottoGame.lottoRanks(round, lottoTickets);
        assertThat(lottoRanks).hasSize(lottoTickets.size());
    }


    private static Stream<Arguments> generate_lotto_tickets() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(
                            LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                            LottoTicket.of(Arrays.asList(1, 2, 3, 4, 2, 6)),
                            LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                            LottoTicket.of(Arrays.asList(1, 2, 3, 4, 6, 6)),
                            LottoTicket.of(Arrays.asList(1, 2, 3, 4, 3, 4))
                        )
                )
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
