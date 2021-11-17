package lotto.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("랜덤 로또번호 생성 - 6자리, 1~45, 중복값 x")
    void createLottoNumber() {
        for (int i = 0; i < 1000; i++) {
            Lotto lotto = new Lotto();
            List<Integer> numbers =  lotto.getNumbers();
            assertThat(numbers).size().isEqualTo(6);
            assertThat(numbers).doesNotContain(46);
            assertThat(numbers).doesNotContain(0);
            assertThat(numbers.stream().distinct().collect(toList())).size().isEqualTo(6);
        }
    }

    @ParameterizedTest
    @MethodSource("provideWiningNumbers")
    @DisplayName("당첨번호와 비교했을 때, 예상된 값이랑 맞는지 확인")
    void isMatchExpected(Lotto provided, int expected) {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 11, 12);
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.isCountOfMatch(provided, expected)).isTrue();
    }

    private static Stream<Arguments> provideWiningNumbers() {
        return Stream.of(
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 35, 37, 26)), 3),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 37, 26)), 4),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 11, 26)), 5),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 11, 12)), 6)
        );
    }

    @Test
    @DisplayName("입력된 당첨번호 6자리, 1~45 만족 못하면 -> IllegalArgumentException")
    void checkNumbers() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1,2,3,4,5,6,7)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1)))
                .hasMessage("6자리 입력 해주세요!!");
        assertThatThrownBy(() -> new Lotto(Arrays.asList(0,1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1,2,3,4,5,46)))
                .hasMessage("1~45 숫자를 입력해주세요!!");
        //정상입력
        assertThatCode(Lotto::new)
                .doesNotThrowAnyException();
        assertThatCode(() -> new Lotto(Arrays.asList(1,2,3,4,5,6)))
                .doesNotThrowAnyException();
    }

}