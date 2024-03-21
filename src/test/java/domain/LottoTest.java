package domain;

import domain.Lotto;
import domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("로또를 발급한다.")
    @Test
    void test01() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = new Lotto(numbers);

        // then
        assertThat(lotto.numbers()).isEqualTo(numbers);
    }

    @DisplayName("로또 생성 시 파라미터로 넘기는 리스트가 6자리가 아니거나, 6자리지만 중복 숫자가 있는 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("testFixture")
    void test02(List<Integer> numbers, Class<Exception> expected) {
        // when / then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(expected);
    }

    public static Stream<Arguments> testFixture() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5), IllegalArgumentException.class),
                Arguments.of(List.of(1, 1, 2, 3, 4, 5), IllegalArgumentException.class)
        );
    }

    @DisplayName("리스트를 기반으로 로또 생성 시 정렬된다.")
    @Test
    void test03() {
        // given
        List<Integer> numbers = List.of(5, 6, 1, 2, 3, 4);

        // when
        Lotto lotto = new Lotto(numbers);

        // then
        assertThat(lotto.numbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("랭킹을 구한다.")
    @Test
    void test04() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        Rank rank = lotto.rank(winningLotto);

        // then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("보너스 번호를 가지고 랭킹 2등을 구한다.")
    @Test
    void test05() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        int bonusNumber = 6;

        // when
        Rank rank = lotto.rank(winningLotto, bonusNumber);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}
