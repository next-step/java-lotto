package com.hskim.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameNumberTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        GameNumber gameNumber = new GameNumber(5);

        // when & then
        assertThat(gameNumber).isEqualTo(new GameNumber(5));
    }

    @DisplayName("playGame() 테스트")
    @Test
    void playGame() {
        // given
        GameNumber gameNumber = new GameNumber(5);
        gameNumber.playGame();
        gameNumber.playGame();

        // when & then
        assertThat(gameNumber).isEqualTo(new GameNumber(3));
    }

    @DisplayName("isPlayable() 테스트")
    @ParameterizedTest
    @MethodSource("provideGameNum")
    void isPlayable(int num, boolean expected) {
        // given
        GameNumber gameNumber = new GameNumber(num);

        // when & then
        assertThat(gameNumber.isPlayable()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideGameNum() {
        return Stream.of(
                Arguments.of(0, false),
                Arguments.of(1, true),
                Arguments.of(3, true),
                Arguments.of(10, true)
        );
    }
}
