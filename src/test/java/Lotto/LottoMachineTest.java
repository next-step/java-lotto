package Lotto;

import Lotto.domain.LottoMachine;
import Lotto.domain.WinningRankInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LottoMachineTest {

    private static Stream<Arguments> lottoWinningMaps() {
        return Stream.of(
                arguments(new HashMap<WinningRankInfo, Integer>()
                {{
                    put(WinningRankInfo.FIRST, 1);
                }}, 2000000000),
                arguments(new HashMap<WinningRankInfo, Integer>()
                {{
                    put(WinningRankInfo.SECOND, 1);
                }}, 1500000),
                arguments(new HashMap<WinningRankInfo, Integer>()
                {{
                    put(WinningRankInfo.FIRST, 1);
                    put(WinningRankInfo.SECOND, 1);
                }}, 2001500000),
                arguments(new HashMap<WinningRankInfo, Integer>()
                {{
                    put(WinningRankInfo.FIRST, 1);
                    put(WinningRankInfo.SECOND, 1);
                    put(WinningRankInfo.THIRD, 1);
                    put(WinningRankInfo.FOURTH, 1);
                }}, 2001555000)
        );
    }

    @ParameterizedTest
    @MethodSource("lottoWinningMaps")
    @DisplayName("총 당첨금액을 구한다")
    public void winningTotalMoneyTest(Map<WinningRankInfo, Integer> winningRanks, int winningTotalMoney) {
        Assertions.assertThat(LottoMachine.calcTotalWinningMoney(winningRanks)).isEqualTo(winningTotalMoney);
    }

    private static Stream<Arguments> totalWinningMoneyArgs() {
        return Stream.of(
                arguments(5000, 5000, 1.00),
                arguments(1000, 5000, 0.2),
                arguments(0, 500000, 0.0),
                arguments(5000, 500000, 0.01)
        );
    };

    @ParameterizedTest
    @MethodSource("totalWinningMoneyArgs")
    @DisplayName("이익률을 구한다.")
    public void test(int totalMoney, int buyMoney, double yield) {
        Assertions.assertThat(LottoMachine.calculateYield(totalMoney, buyMoney)).isEqualTo(yield);
    }
}
