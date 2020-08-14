package com.hskim.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameNumTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        GameNum gameNum = new GameNum(5);

        // when & then
        assertThat(gameNum).isEqualTo(new GameNum(5));
    }

    @DisplayName("playGame() 테스트")
    @Test
    void playGame() {
        // given
        GameNum gameNum = new GameNum(5);
        gameNum.playGame();
        gameNum.playGame();

        // when & then
        assertThat(gameNum).isEqualTo(new GameNum(3));
    }

    @DisplayName("isPlayable() 테스트")
    @ParameterizedTest
    @MethodSource("provideGameNum")
    void isPlayable(int num, boolean expected) {
        // given
        GameNum gameNum = new GameNum(num);

        // when & then
        assertThat(gameNum.isPlayable()).isEqualTo(expected);
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
