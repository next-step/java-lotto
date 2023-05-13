package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoGeneratorTest {

    @ParameterizedTest
    @MethodSource("generateArgs")
    void generateTest(Integer money, Lottos manualLottos, Integer expected) {
        assertThat(new LottoGenerator(money).generate(manualLottos)
            .size())
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("generateManualArgs")
    void generateManualTest(Integer money, Lottos manualLottos) {
        assertThat(new LottoGenerator(money).generate(manualLottos)
            .getLottos()
            .subList(0, manualLottos.size())
        ).isEqualTo(manualLottos.getLottos());
    }

    @ParameterizedTest
    @MethodSource("generateExceptionArgs")
    void generateExceptionTest(Integer money, Lottos manualLottos) {
        assertThatThrownBy(() -> new LottoGenerator(money).generate(manualLottos))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Illegal Arguments In LottoGenerator generate()");
    }

    static Stream<Arguments> generateArgs() {
        return Stream.of(
            Arguments.of(1000, new Lottos(Collections.emptyList()), 1),
            Arguments.of(1000, new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)))), 1),
            Arguments.of(5000, new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18))
            )), 5)
        );
    }

    static Stream<Arguments> generateManualArgs() {
        return Stream.of(
            Arguments.of(1000, new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))))),
            Arguments.of(2000, new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
            ))),
            Arguments.of(5000, new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18))
            )))
        );
    }

    static Stream<Arguments> generateExceptionArgs() {
        return Stream.of(
            Arguments.of(1000, null),
            Arguments.of(1000, new Lottos(
                List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)))))
        );
    }

}
