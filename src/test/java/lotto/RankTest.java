package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.*;

class RankTest {

    @TestFactory
    Stream<DynamicTest> 맞춘_개수_예외_테스트() {
        return Stream.of(
                dynamicTest("1보다 작으면 예외", () -> {
                    // given
                    int countOfMatch = -1;

                    // then
                    assertThatThrownBy(() -> {
                        // when
                        Rank.valueOf(countOfMatch, false);
                    }).isInstanceOf(IllegalArgumentException.class);
                }),

                dynamicTest("6보다 크면 예외", () -> {
                    // given
                    int countOfMatch = 7;

                    // then
                    assertThatThrownBy(() -> {
                        // when
                        Rank.valueOf(countOfMatch, false);
                    }).isInstanceOf(IllegalArgumentException.class);
                })
        );
    }

    @DisplayName(value = "맞춘 개수가 3미만 이면, MISS를 반환")
    @ParameterizedTest
    @ValueSource(ints = {2, 1, 0})
    void 맞춘_개수가_3미만_이면_MISS(int countOfMatch) {
        // when
        Rank rank = Rank.valueOf(countOfMatch, false);

        // then
        assertThat(rank).isEqualTo(Rank.MISS);
    }

    @Test
    void 맞춘_개수가_3개_이면_FIFTH() {
        // given
        int countOfMatch = 3;

        // when
        Rank rank = Rank.valueOf(countOfMatch, false);

        // then
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    void 맞춘_개수가_4개_이면_FOURTH() {
        // given
        int countOfMatch = 4;

        // when
        Rank rank = Rank.valueOf(countOfMatch, false);

        // then
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    void 맞춘_개수가_6개_이면_FIRST() {
        // given
        int countOfMatch = 6;

        // when
        Rank rank = Rank.valueOf(countOfMatch, false);

        // then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName(value = "보너스 번호를 제외하고, 맞춘 번호가 5개일 경우 테스트")
    @TestFactory
    Stream<DynamicTest> 맞춘_개수가_5개() {
        int countOfMatch = 5;

        return Stream.of(
                dynamicTest("보너스 번호가 틀리면, THIRD 반환", () -> {
                    // when
                    Rank rank = Rank.valueOf(countOfMatch, false);

                    // then
                    assertThat(rank).isEqualTo(Rank.THIRD);
                }),

                dynamicTest("보너스 번호가 맞으면, SECOND 반환", () -> {
                    // when
                    Rank rank = Rank.valueOf(countOfMatch, true);

                    // then
                    assertThat(rank).isEqualTo(Rank.SECOND);
                })
        );
    }
}