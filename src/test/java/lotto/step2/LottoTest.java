package lotto.step2;

import lotto.step2.domain.Lotto;
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

class LottoTest {

    @Test
    @DisplayName("로또 번호는 6개 랜덤값을 가지고 있다.")
    void createLottoNumber() {
        Lotto lotto = new Lotto();
        List<Integer> numbers =  lotto.getNumbers().getNumbers();
        assertThat(numbers).size().isEqualTo(6);
    }

    @ParameterizedTest
    @MethodSource("provideWiningNumbers")
    @DisplayName("당첨번호와 비교했을 때, 예상된 값이랑 맞는지 확인")
    void isMatchExpected(List<Integer> provided, int expected) {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 11, 12);
        Lotto lotto = new Lotto(new Numbers(lottoNumbers));
        assertThat(lotto.isMatchExpected(provided, expected)).isTrue();
    }

    private static Stream<Arguments> provideWiningNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 35, 37, 26), 3),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 37, 26), 4),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 11, 26), 5),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 11, 12), 6)
        );
    }


}