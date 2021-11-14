package lotto.step2;

import lotto.step2.domain.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @Test
    @DisplayName("랜덤넘버 생성 - 6자리, 1~46")
    void createNumbers() {
        Numbers number = new Numbers();
        System.out.println(number);
        assertThat(number.getNumbers()).size().isEqualTo(6);
        assertThat(number.getNumbers()).doesNotContain(47);
        assertThat(number.getNumbers()).doesNotContain(0);
    }

    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    @DisplayName("로또번호 == 당첨번호 => 몇개 번호가 당첨되었나?")
    void getCountOfMatch(List<Integer> provided, int expected) {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Numbers lottoNumbers = new Numbers(provided);
        assertThat(lottoNumbers.getCountOfMatch(winningNumbers)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 35, 37, 26), 3),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 37, 26), 4),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 26), 5),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6)
        );
    }

}