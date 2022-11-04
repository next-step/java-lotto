package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTest {
    @Test
    @DisplayName("2개 일치")
    void test0() {
        // given
        // when
        // then
        assertThat(Winning.of(2, false)).isEmpty();
    }

    @Test
    @DisplayName("3개 일치")
    void test1() {
        // given
        // when
        // then
        assertThat(Winning.of(3, false)).isPresent()
                .get()
                .isEqualTo(Winning.THIRD);
    }

    @Test
    @DisplayName("4개 일치")
    void test2() {
        // given
        // when
        // then
        assertThat(Winning.of(4, false)).isPresent()
                .get()
                .isEqualTo(Winning.FOURTH);
    }

    @Test
    @DisplayName("5개 일치")
    void test3() {
        // given
        // when
        // then
        assertThat(Winning.of(5, false)).isPresent()
                .get()
                .isEqualTo(Winning.FIFTH);
    }

    @Test
    @DisplayName("5개 일치, 보너스볼 일치")
    void test4() {
        // given
        // when
        // then
        assertThat(Winning.of(5, true)).isPresent()
                .get()
                .isEqualTo(Winning.FIFTH_BONUS);
    }

    @Test
    @DisplayName("6개 일치")
    void test5() {
        // given
        // when
        // then
        assertThat(Winning.of(6, false)).isPresent()
                .get()
                .isEqualTo(Winning.SIXTH);
    }

}
