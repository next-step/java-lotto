package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {
    private String inputWinners;

    @BeforeEach
    public void setUp() {
        inputWinners = "1,2,3,4,5,6";
    }

    private LottoNumbers createWinner(String input) {
        return new LottoNumbers(input);
    }

    public List<LottoNumber> createLottoNumber() {
        return IntStream.range(1,6)
                .mapToObj(i -> new LottoNumber(i))
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("번호 사이즈 6개 확인")
    public void numberSizeSixTest() throws Exception {
        //given
        LottoNumbers numbers = new LottoNumbers();

        //when

        //then
        assertThat(numbers.readOnlyNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("번호 일치 확인")
    public void numberTrueTest() throws Exception {
        //given
        List<LottoNumber> intList = createLottoNumber();
        LottoNumbers numbers = new LottoNumbers(intList);

        //when

        //then
        assertThat(numbers.checkNumbers(intList)).isTrue();
    }

    @Test
    @DisplayName("번호 불일치 확인")
    public void numberFalseTest() throws Exception {
        //given
        List<LottoNumber> intList = createLottoNumber();
        LottoNumbers numbers = new LottoNumbers();

        //when

        //then
        assertThat(numbers.checkNumbers(intList)).isFalse();
    }


    @Test
    @DisplayName("당첨 번호 6개 사이즈 확인")
    public void winnerNumberSizeSixTest() throws Exception {
        //given
        LottoNumbers winnerNumber = new LottoNumbers(inputWinners);

        //when

        //then
        assertThat(winnerNumber.readOnlyNumbers().size()).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2,3,", "1,2,3,4,5"})
    @DisplayName("당첨 번호 6개 미만 예외 확인")
    public void winnerNumberSizeSixDownExceptionTest(String input) throws Exception {
        //given

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            createWinner(input);
        });

        //then
    }

    @Test
    @DisplayName("로또 번호 중복 확인")
    public void winnerNumberDuplicateTest() throws Exception {
        //given
        String input = "1,1,2,3,4,5";

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            createWinner(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,45", "1,2,3,4,5,46"})
    @DisplayName("로또 번호 1 ~ 45 벗어날 시 예외 확인")
    public void winnerNumberRangeExceptionTest(String input) throws Exception {
        //given

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            createWinner(input);
        });
    }

    @Test
    @DisplayName("로또 번호 중복 예외 확인")
    public void winnerNumberDuplicateExceptionTest() throws Exception {
        //given
        String input = "1,1,1,1,1,1";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            createWinner(input);
        });
    }
}
