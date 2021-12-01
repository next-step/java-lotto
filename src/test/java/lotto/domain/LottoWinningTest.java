package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinningTest {

    private LottoTicket initTicket;

    @BeforeEach
    @DisplayName("테스트용 로또 티켓 생성")
    void setUp() {
        List<Integer> lottoNumbers1 = Arrays.asList(1, 2, 3, 41, 15, 16);
        List<Integer> lottoNumbers2 = Arrays.asList(10, 21, 31, 41, 12, 23);
        List<Integer> lottoNumbers3 = Arrays.asList(12, 13, 14, 15, 17, 19);

        initTicket = LottoTicket.from(Arrays.asList(Lotto.winningFrom(lottoNumbers1),
                Lotto.winningFrom(lottoNumbers2), Lotto.winningFrom(lottoNumbers3)));

    }

    @Test
    @DisplayName("당첨 번호 입력시 생성 테스트")
    void createTest() {
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        LottoWinning lottoWinning = LottoWinning.from(winningNumbers,"30");

        assertThat(lottoWinning).isEqualTo(LottoWinning.from(winningNumbers, "30"));
    }

    @Test
    @DisplayName("당첨 번호 입력 시 사이즈 확인 예외 검증")
    void exceptionTest() {
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6,7);
        assertThatThrownBy(() ->
                LottoWinning.from(winningNumbers, "30")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호와 로또티켓을 비교하여 수익률 계산 검증 테스트")
    void profitTest() {
        LottoWinning lottoWinning = LottoWinning.from(Arrays.asList(1,2,3,4,5,6), "30");
        Map<Rank, Integer> prizeWinnersRepository = lottoWinning.createRepository(initTicket);

        double profit = lottoWinning.calculateRateOfProfit(prizeWinnersRepository, 3000);
        assertThat(profit).isEqualTo(1.66);
    }

    @Test
    @DisplayName("보너스 번호가 당첨번호에 포함되어 있을 때 예외 검증")
    void bonusException() {
        assertThatThrownBy(() ->
                LottoWinning.from(Arrays.asList(1,2,3,4,5,6), "5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideWinnerNumberCount")
    @DisplayName("당첨번호를 입력했을 때 맞는 갯수 카운트 검증")
    void createRepository(List<Integer> winningNumbers, Rank key, int value) {

        List<Integer> lottoNumbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers2 = Arrays.asList(1, 2, 3, 4, 10, 20);
        List<Integer> lottoNumbers3 = Arrays.asList(1, 2, 3, 10, 20, 30);

        initTicket = LottoTicket.from(Arrays.asList(Lotto.winningFrom(lottoNumbers1),
                Lotto.winningFrom(lottoNumbers2), Lotto.winningFrom(lottoNumbers3)));

        LottoWinning lottoWinning = LottoWinning.from(winningNumbers, "30");
        Map<Rank, Integer> repository = lottoWinning.createRepository(initTicket);
        assertThat(repository.get(key)).isEqualTo(value);
    }

    private static Stream<Arguments> provideWinnerNumberCount() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Rank.FIRST, 1),
                Arguments.of(Arrays.asList(1, 2, 3, 10, 20, 37), Rank.SECOND, 1),
                Arguments.of(Arrays.asList(1, 2, 3, 10, 20, 37), Rank.THIRD, 1),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 44, 45), Rank.FOURTH, 2),
                Arguments.of(Arrays.asList(7, 8, 9, 10, 20, 2), Rank.FIFTH, 2)
        );
    }
}
