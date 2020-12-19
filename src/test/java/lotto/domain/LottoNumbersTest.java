package lotto.domain;

import lotto.exception.LottoNumberCountNotEnoughException;
import lotto.util.StringSplitter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class LottoNumbersTest {

    @Test
    @DisplayName("LottoNumbers 생성 테스트")
    void lotto_numbers_test() {
        // given
        String text = "1,2,3,4,5,6";
        List<Integer> numbers = StringSplitter.splitText(text);

        // when
       LottoNumbers lottoNumbers = new LottoNumbers(numbers);

        // then
        assertThat(lottoNumbers.getNumbers().size()).isEqualTo(6);
        assertThat(lottoNumbers.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("입력한 로또 갯수가 6보다 작을때 예외발생 테스트")
    void not_enough_lotto_number_count_test() {
        assertThatExceptionOfType(LottoNumberCountNotEnoughException.class).isThrownBy(() -> {
            List<Integer> numbers = StringSplitter.splitText("1,2,3,4,5");
            LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        }).withMessageMatching("로또 번호 또는 당첨 번호는 6개를 입력해주세요.");
    }

}
