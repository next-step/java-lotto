package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    @DisplayName("모든 당첨경우를 1회씩 만족하는 LottoResult")
    void setUp() {
        lottoResult = new LottoResult(
                Arrays.asList(
                        new Lotto(1, 2, 3, 4, 5, 6),
                        new Lotto(2, 3, 4, 5, 6, 7),
                        new Lotto(3, 4, 5, 6, 7, 8),
                        new Lotto(4, 5, 6, 7, 8, 9),
                        new Lotto(5, 6, 7, 8, 9, 10),
                        new Lotto(6, 7, 8, 9, 10, 11),
                        new Lotto(7, 8, 9, 10, 11, 12)
                ),
                new Lotto(1, 2, 3, 4, 5, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorMethodSource")
    @DisplayName("로또와 당첨로또를 인자로 받아 결과를 저장해 놓을 수 있다.")
    void constructorMethod(List<Lotto> lottos, Lotto target) {
        assertThat(lottoResult).isEqualTo(new LottoResult(lottos, target));
    }

    static Stream<Arguments> constructorMethodSource() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(
                            new Lotto(1, 2, 3, 4, 5, 6),
                            new Lotto(2, 3, 4, 5, 6, 7),
                            new Lotto(3, 4, 5, 6, 7, 8),
                            new Lotto(4, 5, 6, 7, 8, 9),
                            new Lotto(5, 6, 7, 8, 9, 10),
                            new Lotto(6, 7, 8, 9, 10, 11),
                            new Lotto(7, 8, 9, 10, 11, 12)
                        ),
                        new Lotto(1, 2, 3, 4, 5, 6)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("resultMethodSource")
    @DisplayName("Prize 를 입력받아 몇장의 로또가 해당 Prize 에 당첨되었는지 반환한다.")
    void resultMethod (Prize input, int result) {
        assertThat(lottoResult.result(input)).isEqualTo(result);
    }

    static Stream<Arguments> resultMethodSource() {
        return Stream.of(
                Arguments.of(Prize.FIRST, 1),
                Arguments.of(Prize.SECOND, 1),
                Arguments.of(Prize.THIRD, 1),
                Arguments.of(Prize.FOURTH, 1),
                Arguments.of(Prize.FIFTH, 1),
                Arguments.of(Prize.SIXTH, 1),
                Arguments.of(Prize.LOSE, 1)
        );
    }

    @Test
    @DisplayName("로또 하나하나가 당첨된 금액을 모두 더한 금액에 총 로또 수를 나눈값")
    void yieldMethod() {
        double result = Arrays.stream(Prize.values())
                .mapToDouble(prize -> prize.money())
                .sum();

        assertThat(lottoResult.yield()).isEqualTo(result / Prize.values().length);
    }
}
