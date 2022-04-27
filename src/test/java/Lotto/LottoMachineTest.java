package Lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LottoMachineTest {

    private static Stream<Arguments> lottoWinningRankArgs() {
        return Stream.of(
                arguments(new String[] {"1th"}, 2000000000),
                arguments(new String[] {"2th"}, 1500000),
                arguments(new String[] {"3th"}, 50000),
                arguments(new String[] {"1th","2th"}, 2001500000),
                arguments(new String[] {"1th","2th","3th"}, 2001550000),
                arguments(new String[] {"1th","2th","3th","4th"}, 2001555000)
        );
    }

    @ParameterizedTest
    @MethodSource("lottoWinningRankArgs")
    @DisplayName("로또 여러장들의 당첨금액을 합산한다")
    public void test(String [] winningRanks, int winningSumPrice) {
        LottoMachine lottoMachine = new LottoMachine(winningRanks);

        Assertions.assertThat(lottoMachine.getWinningSumPrice()).isEqualTo(winningSumPrice);
    }
}
