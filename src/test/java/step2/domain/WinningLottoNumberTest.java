package step2.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class WinningLottoNumberTest {

    @Test
    @DisplayName(value = "WinningLottoNumber 생성 테스트")
    void create() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,45);
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(list);

        assertThat(winningLottoNumber.getNumbers().size()).isEqualTo(6);
        assertThat(winningLottoNumber.getNumbers()).containsAll(list);
    }

    @ParameterizedTest
    @MethodSource("isNotMatchLottoNumbers_ShouldIllegalArgumentException")
    @DisplayName(value = "잘못된 숫자 리스트를 입력하면 IllegalArgumentException 발생")
    void numberValid_IllegalArgumentException(List<Integer> numbers) {
        assertThatThrownBy(() -> new WinningLottoNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> isNotMatchLottoNumbers_ShouldIllegalArgumentException() {
        return Stream.of(
                Arguments.of(Lists.newArrayList(1,2,3,4,5,46)),
                Arguments.of(Lists.newArrayList(0,2,3,4,5,45)),
                Arguments.of(Lists.newArrayList(1,2,3,4,5))
        );
    }

    @Test
    @DisplayName("당첨번호와 겹치는 보너스 숫자를 입력하면 Exception을 발생시킴.")
    void addBonusNumber_isNotContainsWinningNumber_ShouldException() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,10);
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(list);

        assertThatThrownBy(() -> winningLottoNumber.addBonusNumber(10))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
