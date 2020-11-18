package lotto.domain.game;

import lotto.domain.LottoNumberBoard;
import lotto.domain.LottoNumberMaker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created By mand2 on 2020-11-19.
 */
class LottoNumberTest {

    @Test
    @DisplayName("자동으로 생성된 로또 게임 두개의 로또번호가 같을까")
    void is_automated_lotto_number_same() {
        // given
        List<Integer> automatedLotto ;
        List<Integer> automatedLotto2 ;

        // when
        automatedLotto = LottoNumberMaker.shuffle();
        automatedLotto2 = LottoNumberMaker.shuffle();

        // then
        assertThat(false).isEqualTo(automatedLotto.containsAll(automatedLotto2));
    }

    @Test
    @DisplayName("한 세트의 로또번호-리스트-가 같으면 같다")
    void is_same_lotto_number_in_a_round() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        LottoNumber lottoNumber = LottoNumber.of(numbers);

        // then
        assertThat(lottoNumber.value()).isEqualTo(numbers);
        assertThat(lottoNumber.value()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("로또번호는 오름차순으로 정렬이 된다.")
    void is_lotto_number_ascending() {
        // given
        List<Integer> numbers = Arrays.asList(41, 22, 3, 4, 5, 6);

        // when
        LottoNumber lottoNumber = LottoNumber.of(numbers);

        // then
        assertThat(lottoNumber.value()).isEqualTo(Arrays.asList(3, 4, 5, 6, 22, 41));
    }

    @ParameterizedTest
    @DisplayName("로또번호가 6개로 이루어진 세트가 아니면 예외를 던진다")
    @ValueSource(ints = {1, 2, 33})
    void is_lotto_number_valid_size(int inputLottoNumber) {

        // given
        List<Integer> numbers = Arrays.asList(41, 22, 3, 4, inputLottoNumber);

        assertThatThrownBy(() -> LottoNumber.of(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(LottoNumber.MESSAGE_VALID_SIZE,
                        LottoNumber.VALID_LOTTO_SIZE));
    }

    @ParameterizedTest
    @DisplayName("로또번호가 1~45 사이의 수가 아니면 예외를 던진다")
    @ValueSource(ints = {0, -1, 46})
    void is_lotto_number_valid_number(int inputLottoNumber) {

        // given
        List<Integer> numbers = Arrays.asList(41, 22, 3, 4, 5, inputLottoNumber);

        assertThatThrownBy(() -> LottoNumber.of(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(LottoNumber.MESSAGE_VALID_NUMBER,
                        LottoNumberBoard.VALID_MIN_NUMBER, LottoNumberBoard.VALID_MAX_NUMBER));
    }

    @ParameterizedTest
    @DisplayName("로또번호에 중복된 숫자가 있다면 예외를 던진다")
    @ValueSource(ints = {22, 3, 4})
    void is_lotto_number_repeated(int inputLottoNumber) {

        // given
        List<Integer> numbers = Arrays.asList(41, 22, 3, 4, 5, inputLottoNumber);

        assertThatThrownBy(() -> LottoNumber.of(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(LottoNumber.MESSAGE_VALID_SIZE,
                        LottoNumber.VALID_LOTTO_SIZE));
    }


    @Test
    @DisplayName("로또번호를 출력하면 리스트 형태로 나온다")
    void print_lotto_number_of_list_type() {
        // given
        List<Integer> numbers = Arrays.asList(41, 22, 3, 4, 5, 6);

        // when
        LottoNumber lottoNumber = LottoNumber.of(numbers);

        // then
        assertThat(lottoNumber.value()).containsExactlyInAnyOrder(41, 22, 3, 4, 5, 6);
        assertThat(lottoNumber.value().toString()).isEqualTo("[3, 4, 5, 6, 22, 41]");
    }



}
