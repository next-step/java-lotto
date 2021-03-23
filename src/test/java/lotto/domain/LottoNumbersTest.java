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
public class LottoNumbersTest {
    public List<Integer> createLottoNumber() {
        return IntStream.range(1,7)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> createLottoNumber2() {
        return IntStream.range(2,8)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> stringToIntegers(String input) {
        return InputView.stringToIntegers(input);
    }

    @Test
    @DisplayName("번호 사이즈 6개 확인")
    public void numberSizeSixTest() throws Exception {
        //given
        LottoNumbers numbers = new LottoNumbers(createLottoNumber());

        //when

        //then
        assertThat(numbers.readOnlyNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("번호 일치 확인")
    public void numberTrueTest() throws Exception {
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
    public void numberFalseTest() throws Exception {
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
    public void numberSizeSixDownExceptionTest(String input) throws Exception {
        //given

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoMachine.createLottoTicket(stringToIntegers(input));
        });

        //then
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5", "1,1,1,1,1,1"})
    @DisplayName("로또 번호 중복 예외 확인")
    public void numberDuplicateExceptionTest(String input) throws Exception {
        //given

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoMachine.createLottoTicket(stringToIntegers(input));
        });
    }
}
