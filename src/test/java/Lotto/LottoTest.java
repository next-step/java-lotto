package Lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;


public class LottoTest {

    private static Stream<Arguments> lottoArgs() {
        return Stream.of(
                arguments(new int[] {1,2,3,4,5,6}, new int[] {1,2,3,4,5,10}, 5),
                arguments(new int[] {1,2,3,4,5,6}, new int[] {1,10,11,12,13,14}, 1),
                arguments(new int[] {45,44,43,3,2,1}, new int[] {1,2,3,43,44,45}, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("lottoArgs")
    @DisplayName("당첨된 번호가 몇개인지 확인한다")
    public void checkEqualLottoNumber(int[] numbers, int[] answers, int equalNum) {
        Lotto lotto = new Lotto(numbers);
        Assertions.assertThat(lotto.checkWinningLottoNumbers(answers)).isEqualTo(equalNum);
    }
}
