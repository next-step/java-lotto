package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import step2.domain.strategy.TestLottoGeneratorStrategy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("로또 티켓 테스트")
class LottoTicketTest {

    private int lottoAmount = 3;
    private LottoTicket lottoTicket = new LottoTicket(Stream.generate(Lotto::new)
            .limit(lottoAmount)
            .collect(Collectors.toList()),
            new TestLottoGeneratorStrategy(1));

    @DisplayName("로또 당첨 횟수 확인")
    @ParameterizedTest
    @MethodSource("winningNumbersProvider")
    void getWinLottoCountByMatchCount(Optional<WinningNumbers> winningNumbers, HashMap<Integer, Integer> winCounts) {
        assertThat(lottoTicket.getWinLottoCount(winningNumbers)).isEqualTo(winCounts);
    }

    @ParameterizedTest
    @MethodSource("winningPriceProvider")
    void calculateTotalPrice(Optional<WinningNumbers> winningNumbers, int totalPrice) {
        lottoTicket.getWinLottoCount(winningNumbers);
        assertThat(lottoTicket.calculateTotalPrice()).isEqualTo(totalPrice);
    }

    @DisplayName("로또 수익률 계산")
    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {"15000:5.00","0:0","300000:100.00"})
    void calculateWinnerRatio(int totalPrice, float ratio) {
        assertThat(lottoTicket.calculateWinnerRatio(lottoAmount, totalPrice)).isEqualTo(ratio);
    }

    private static Stream<Arguments> winningNumbersProvider() {
        return Stream.of(
                Arguments.of(Optional.of(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))), new HashMap<Integer, Integer>(){
                    {
                        put(6,1);
                    }
                }),
                Arguments.of(Optional.of(new WinningNumbers(Arrays.asList(4, 5, 6, 23, 24, 25))), new HashMap<Integer, Integer>(){
                    {
                        put(3,1);
                    }
                })
        );
    }

    private static Stream<Arguments> winningPriceProvider() {
        return Stream.of(
                Arguments.of(Optional.of(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))), 2000000000),
                Arguments.of(Optional.of(new WinningNumbers(Arrays.asList(4, 5, 6, 23, 24, 25))), 5000)
        );
    }
}
