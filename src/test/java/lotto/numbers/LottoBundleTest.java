package lotto.numbers;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.enums.Ranks;

public class LottoBundleTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 7, 10, 16})
    public void generatorsAndSize(int purchaseCount) {
        LottoBundle lottoBundle = new LottoBundle(purchaseCount);
        assertThat(lottoBundle.getBundleSize()).isEqualTo(purchaseCount);
    }

    @ParameterizedTest
    @MethodSource("getRanksParam")
    public void getRanks(List<Integer> numbers, int bonusNumber) {
        LottoBundle lottoBundle = new LottoBundle(10);
        Map<Ranks, Integer> rankingMap = lottoBundle.getRanks(numbers, bonusNumber);
        assertThat(rankingMap.size()).isGreaterThan(0);
    }

    public static Stream<Arguments> getRanksParam() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7),
                Arguments.of(List.of(13, 26, 28, 33, 39, 44), 43),
                Arguments.of(List.of(2, 23, 34, 35, 41, 45), 7),
                Arguments.of(List.of(3, 38, 40, 41, 42, 43), 17),
                Arguments.of(List.of(4, 9, 16, 19, 26, 33), 40)
        );
    }
}
