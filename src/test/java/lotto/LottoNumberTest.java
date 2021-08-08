package lotto;

import lotto.model.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoNumberTest {

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    LottoNumber lottoNumber = new LottoNumber();

    @Test
    void 로또_숫자_1부터_45까지() {
        List<Integer> numbers = lottoNumber.getLottoNumber();
        for (int number : numbers) {
            assertThat(number).isGreaterThanOrEqualTo(LOTTO_START_NUMBER)
                    .isLessThanOrEqualTo(LOTTO_END_NUMBER);
        }
    }

    @Test
    void 로또_숫자_6개_섞였나() {
        List<Integer> numbers = lottoNumber.getLottoNumber();

        LottoNumber lottoNumber2 = new LottoNumber();
        lottoNumber2.shuffle();
        List<Integer> shuffleNumber = lottoNumber2.getLottoNumber();

        assertThat(numbers.get(0)).isNotEqualTo(shuffleNumber.get(0));
    }


}
