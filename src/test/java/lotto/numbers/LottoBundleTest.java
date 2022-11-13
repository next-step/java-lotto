package lotto.numbers;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoBundleTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 7, 10, 16})
    public void generatorsAndSize(int purchaseCount) {
        LottoBundle lottoBundle = new LottoBundle(purchaseCount);
        assertThat(lottoBundle.getBundleSize()).isEqualTo(purchaseCount);
    }

    @ParameterizedTest
    @MethodSource("getLottoByIndexSuccessParam")
    public void getLottoByIndexSuccess(int purchaseCount, int index) {
        LottoBundle lottoBundle = new LottoBundle(purchaseCount);
        assertThat(lottoBundle.getLottoByIndex(index)).isNotNull();
        assertThat(lottoBundle.getLottoByIndex(index)).isInstanceOf(Lotto.class);
    }

    @ParameterizedTest
    @MethodSource("getLottoByIndexFailedParam")
    public void getLottoByIndexFailed(int purchaseCount, int index) {
        assertThatThrownBy(() -> {
            LottoBundle lottoBundle = new LottoBundle(purchaseCount);
            lottoBundle.getLottoByIndex(index);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("잘못된 인덱스 번호입니다.");
    }

    public static Stream<Arguments> getLottoByIndexSuccessParam() {
        return Stream.of(
                Arguments.of(1, 0),
                Arguments.of(5, 3),
                Arguments.of(7, 6),
                Arguments.of(10, 3),
                Arguments.of(16, 11)
        );
    }

    public static Stream<Arguments> getLottoByIndexFailedParam() {
        return Stream.of(
                Arguments.of(1, -1),
                Arguments.of(5, 5),
                Arguments.of(7, 8),
                Arguments.of(10, -4),
                Arguments.of(16, 16)
        );
    }
}
