package deprecatedlotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoCountTest {


    @ParameterizedTest
    @MethodSource("LottoMatchCount")
    void winningAmount( Map<Integer, Integer> winningLottoCountMap, int winningAmount) {
        WinningLottoCount winningLottoCount = new WinningLottoCount(winningLottoCountMap);
        assertThat(winningLottoCount.winningAmount()).isEqualTo(winningAmount);
    }

    static Stream<Arguments> LottoMatchCount() {
        return Stream.of(
                Arguments.of(Map.of(1,0,2,0,3,0,4,1),5000),
                Arguments.of(Map.of(1,0,2,0,3,1,4,0),50000),
                Arguments.of(Map.of(1,0,2,1,3,0,4,0),1500000),
                Arguments.of(Map.of(1,1,2,0,3,0,4,0),2000000000)
        );
    }

}