package edu.nextstep.camp.lotto.domain;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RankTest {
    static Stream<Arguments> parseCreateArguments() {
        return Stream.of(
                Arguments.of(6, false, Prize.FIRST_PRIZE),
                Arguments.of(5, true, Prize.SECOND_PRIZE),
                Arguments.of(5, false, Prize.THIRD_PRIZE),
                Arguments.of(4, false, Prize.FOURTH_PRIZE),
                Arguments.of(3, false, Prize.FIFTH_PRIZE),
                Arguments.of(2, false, Prize.NO_PRIZE),
                Arguments.of(1, false, Prize.NO_PRIZE),
                Arguments.of(0, false, Prize.NO_PRIZE),
                // 4등 이하는 보너스 번호 매칭이 결과에 영향을 못줌
                Arguments.of(4, true, Prize.FOURTH_PRIZE),
                Arguments.of(3, true, Prize.FIFTH_PRIZE),
                Arguments.of(2, true, Prize.NO_PRIZE),
                Arguments.of(1, true, Prize.NO_PRIZE),
                Arguments.of(0, true, Prize.NO_PRIZE)
        );
    }

    @ParameterizedTest(name = "create Rank: {arguments}")
    @MethodSource("parseCreateArguments")
    public void create(int matched, boolean bonusMatched, Prize expected) {
        assertThat(Rank.valueOf(matched, bonusMatched).prize()).isEqualTo(expected);
    }


    static Stream<Arguments> parseCreateFailedArguments() {
        return Stream.of(
                Arguments.of(7, false),
                Arguments.of(7, true),
                Arguments.of(-1, false),
                Arguments.of(-1, true)
        );
    }

    @ParameterizedTest(name = "create Rank failed: {arguments}")
    @MethodSource("parseCreateFailedArguments")
    public void createFailed(int matched, boolean bonusMatched) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Rank.valueOf(matched, bonusMatched))
                .withMessageContaining("matched count must be 0 ~ 6.");
    }

    @Test
    @DisplayName("create Rank failed by 6 matched and bonus matched.")
    public void creatFailed6WithBonus() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Rank.valueOf(6, true))
                .withMessageContaining("bonus cannot be matched with all of 6 numbers");
    }
}
