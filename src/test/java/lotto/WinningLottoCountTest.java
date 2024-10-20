package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoCountTest {


    @ParameterizedTest
    @MethodSource("LottoMatchCount")
    void winningAmount(List<Integer> lottoNumberMatchList, int winningAmount) {
        WinningLottoCount winningLottoCount = new WinningLottoCount(lottoNumberMatchList);
        assertThat(winningLottoCount.winningAmount()).isEqualTo(winningAmount);
    }

    static Stream<Arguments> LottoMatchCount() {
        return Stream.of(
                Arguments.of(List.of(1,0,0,0),5000),
                Arguments.of(List.of(0,1,0,0),50000),
                Arguments.of(List.of(0,0,1,0),1500000),
                Arguments.of(List.of(0,0,0,1),2000000000)
        );
    }

}