package lotto.domain;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberGeneratorTest {

    private LottoNumberGenerator lottoNumberGenerator;

    @BeforeEach
    void setUp() {
        lottoNumberGenerator = new LottoNumberGenerator();
    }

    @Test
    @DisplayName("14,000원의 lotto를 구매하면, 1~45까지 6개의 번호를 14개 생성한다.")
    void should_return_lotto_numbers() {
        //Given & When
        Lottoes lottoes = lottoNumberGenerator.create(14_000);

        //Then
        assertThat(lottoes.getValue().size()).isEqualTo(14);
    }

    @Test
    @DisplayName("문자열로된 숫자들을 입력 받으면, LottoNumbers를 반환한다.")
    void should_return_lotto_numbers_when_enter_string() {
        //Given
        String numbers = "1, 2, 3, 4, 5, 6";

        //When
        List<Integer> lottoNumbers = lottoNumberGenerator.create(numbers).getValue()
                .stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toList());

        //Then
        assertThat(lottoNumbers).containsAll(Arrays.asList(1, 2, 3, 4, 5, 6));

    }

    @ParameterizedTest
    @DisplayName("빈 문자열을 받으면 Exception을 throw 한다.")
    @ValueSource(strings = {"", " "})
    void should_throw_illegal_argument_exception(String numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoNumberGenerator.create(numbers))
                .withMessage(ErrorMessage.WINNING_NUMBER_ERROR);
    }
}
