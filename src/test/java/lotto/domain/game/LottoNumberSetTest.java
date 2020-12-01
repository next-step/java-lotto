package lotto.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created By mand2 on 2020-11-19.
 */
class LottoNumberSetTest {

    @org.junit.jupiter.api.Test
    @DisplayName("로또번호는 오름차순으로 정렬이 된다.")
    void is_lotto_number_ascending() {
        // given
        List<LottoNumber> numbers = Arrays.asList(41, 22, 3, 4, 5, 6).stream()
                .map(LottoNumber::from).collect(Collectors.toList());

        // when
        LottoNumberSet lottoNumberSet = LottoNumberSet.of(numbers);

        // then
        assertThat(lottoNumberSet.value())
                .isEqualTo(Arrays.asList(3, 4, 5, 6, 22, 41)
                        .stream()
                        .map(LottoNumber::from)
                        .collect(Collectors.toSet()));
    }

    @ParameterizedTest
    @DisplayName("로또번호가 6개로 이루어진 세트가 아니면 예외를 던진다")
    @ValueSource(ints = {1, 2, 33})
    void is_lotto_number_valid_size(int inputLottoNumber) {

        // given
        List<LottoNumber> numbers = Arrays.asList(41, 22, 3, 4, inputLottoNumber).stream()
                .map(LottoNumber::from).collect(Collectors.toList());;

        assertThatThrownBy(() -> LottoNumberSet.of(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(LottoNumberSet.MESSAGE_VALID_SIZE,
                        LottoNumberSet.VALID_LOTTO_SIZE));
    }

    @ParameterizedTest
    @DisplayName("로또번호가 1~45 사이의 수가 아니면 예외를 던진다")
    @ValueSource(ints = {0, -1, 46})
    void is_lotto_number_valid_number(int inputLottoNumber) {

        // given
        List<Integer> numbers = Arrays.asList(41, 22, 3, 4, 5, inputLottoNumber);


        assertThatThrownBy(() -> numbers.stream().map(LottoNumber::from).collect(Collectors.toList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(LottoNumber.MESSAGE_VALID_NUMBER,
                        LottoNumber.VALID_MIN_NUMBER, LottoNumber.VALID_MAX_NUMBER));
    }

    @ParameterizedTest
    @DisplayName("로또번호에 중복된 숫자가 있다면 예외를 던진다")
    @ValueSource(ints = {22, 3, 4})
    void is_lotto_number_repeated(int inputLottoNumber) {

        // given
        List<Integer> numbers = Arrays.asList(41, 22, 3, 4, 5, inputLottoNumber);

        // when
        List<LottoNumber> lottoNumbers = numbers.stream().map(LottoNumber::from).collect(Collectors.toList());

        assertThatThrownBy(() -> LottoNumberSet.of(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(LottoNumberSet.MESSAGE_VALID_SIZE, LottoNumberSet.VALID_LOTTO_SIZE));
    }


    @org.junit.jupiter.api.Test
    @DisplayName("로또번호를 출력하면 리스트 형태로 나온다")
    void print_lotto_number_of_list_type() {
        // given
        List<LottoNumber> numbers = Arrays.asList(41, 22, 3, 4, 5, 6).stream()
                .map(LottoNumber::from).collect(Collectors.toList());;

        // when
        LottoNumberSet lottoNumberSet = LottoNumberSet.of(numbers);

        // then
        assertThat(lottoNumberSet.toString()).isEqualTo("[3, 4, 5, 6, 22, 41]");
    }



}
