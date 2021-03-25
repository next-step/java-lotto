package lotto.domain;

import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("번호 그룹")
class LottoNumbersTest {
    List<Integer> createLottoNumber() {
        return IntStream.range(1,7)
                .boxed()
                .collect(Collectors.toList());
    }

    List<Integer> createLottoNumber2() {
        return IntStream.range(2,8)
                .boxed()
                .collect(Collectors.toList());
    }

    List<Integer> stringToIntegers(String input) {
        return InputView.stringToIntegers(input);
    }

    @Test
    @DisplayName("번호 사이즈 6개 확인")
    void numberSizeSixTest() {
        //given
        LottoNumbers numbers = new LottoNumbers(createLottoNumber());

        //when

        //then
        assertThat(numbers.readOnlyNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("번호 일치 확인")
    void numberTrueTest() {
        //given
        List<Integer> intList = createLottoNumber();
        LottoNumbers numbers = new LottoNumbers(intList);
        LottoNumbers numbers2 = new LottoNumbers(intList);

        //when

        //then
        assertThat(numbers.equals(numbers2)).isTrue();
    }

    @Test
    @DisplayName("번호 불일치 확인")
    void numberFalseTest() {
        //given
        LottoNumbers numbers = new LottoNumbers(createLottoNumber());
        LottoNumbers numbers2 = new LottoNumbers(createLottoNumber2());

        //when

        //then
        assertThat(numbers.equals(numbers2)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2,3,", "1,2,3,4,5"})
    @DisplayName("번호 6개 미만 예외 확인")
    void numberSizeSixDownExceptionTest(String input) {
        //given

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(stringToIntegers(input));
        });

        //then
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5", "1,1,1,1,1,1"})
    @DisplayName("로또 번호 중복 예외 확인")
    void numberDuplicateExceptionTest(String input) {
        //given

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(stringToIntegers(input));
        });
    }
}
