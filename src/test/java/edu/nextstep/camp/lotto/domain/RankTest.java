package edu.nextstep.camp.lotto.domain;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RankTest {
    static Stream<Arguments> parseCreateArguments() {
        return Stream.of(
                Arguments.of(6, Prize.FIRST_PRIZE),
                Arguments.of(5, Prize.SECOND_PRIZE),
                Arguments.of(4, Prize.THIRD_PRIZE),
                Arguments.of(3, Prize.FOURTH_PRIZE),
                Arguments.of(2, Prize.NO_PRIZE),
                Arguments.of(1, Prize.NO_PRIZE),
                Arguments.of(0, Prize.NO_PRIZE)
        );
    }

    @ParameterizedTest(name = "create Rank: {arguments}")
    @MethodSource("parseCreateArguments")
    public void create(int matched, Prize expected) {
        assertThat(Rank.valueOf(matched).prize()).isEqualTo(expected);
    }

    @ParameterizedTest(name = "create Rank failed: {arguments}")
    @ValueSource(ints = {-1, 7})
    public void createFailed(int matched) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Rank.valueOf(matched))
                .withMessageContaining("matched count must be 0 ~ 6.");
    }
}
