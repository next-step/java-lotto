package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import step4.domain.Lottos;
import step4.domain.Shop;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ShopTest {
    @ParameterizedTest
    @DisplayName("금액으로 로또 구입 개수 찾기")
    @CsvSource(value = {"1000:1", "10000:10", "15000:15", "11500:11"}, delimiter = ':')
    public void buyLotto(int input, int expected) {
        //given, when
        Lottos lottos = Shop.buyLotto(input);

        //then
        assertThat(lottos.size()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("금액과 수동 로또 개수로 전체 구입 개수 찾기")
    @MethodSource("buyLottoSource")
    public void buyLottoManual(List<List<Integer>> manualLottoNums, int cost, int expected) {
        //given, when
        Lottos lottos = Shop.buyLotto(cost, manualLottoNums);

        //then
        assertThat(lottos.size()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("구매한 전체 로또 금액보다 수동으로 구매할 로또 카운트가 더 많을 경우")
    @MethodSource("buyLottoErrorSource")
    public void buyLottoError(List<List<Integer>> manualLottoNums, int cost) {
        //given, when, then
        assertThatThrownBy(() -> {
            Shop.buyLotto(cost, manualLottoNums);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @DisplayName("수동으로 구매한 로또 번호에 오류가 있을경우")
    @MethodSource("buyLottoRangeErrorSource")
    public void buyLottoRangeError(List<List<Integer>> manualLottoNums, int cost) {
        //given, when, then
        assertThatThrownBy(() -> {
            Shop.buyLotto(cost, manualLottoNums);
        }).isInstanceOf(RuntimeException.class);
    }

    static Stream<Arguments> buyLottoSource() {
        return Stream.of(Arguments.arguments(Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6),
            Arrays.asList(1, 2, 3, 4, 5, 6)
        ), 10000, 10), Arguments.arguments(
            Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6)
            ),
            10000,
            10
        ), Arguments.arguments(Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6),
            Arrays.asList(1, 2, 3, 4, 5, 6),
            Arrays.asList(1, 2, 3, 4, 5, 6),
            Arrays.asList(1, 2, 3, 4, 5, 6)
        ), 15000, 15));
    }

    static Stream<Arguments> buyLottoErrorSource() {
        return Stream.of(
            Arguments.arguments(Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6)), 1000),
            Arguments.arguments(
                Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6),
                    Arrays.asList(1, 2, 3, 4, 5, 6),
                    Arrays.asList(1, 2, 3, 4, 5, 6)
                ),
                2000
            ),
            Arguments.arguments(Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6)
            ), 3000)
        );
    }

    static Stream<Arguments> buyLottoRangeErrorSource() {
        return Stream.of(
            Arguments.arguments(Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6, 7), Arrays.asList(1, 2, 3, 4, 5, 6)), 2000),
            Arguments.arguments(
                Arrays.asList(Arrays.asList(1, 2, 3, 4, -5, 6),
                    Arrays.asList(1, 2, 3, 4, 5, 6),
                    Arrays.asList(1, 2, 3, 4, 5, 6)
                ),
                3000
            ),
            Arguments.arguments(Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(0, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6)
            ), 4000)
        );
    }
}
