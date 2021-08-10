package lotto;

import lotto.model.LottoNumber;
import lotto.model.LottoNumberPicker;
import lotto.model.LottoNumbers;
import org.junit.jupiter.api.Test;
import stringcalculation.StringAddCalculator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class LottoNumbersTest {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int TEST_LOTTO_NUBMER = 1;

    LottoNumbers lottoNumbers = new LottoNumbers();

    @Test
    void 로또_숫자_객체_체크() {
        LottoNumbers lottoNumbers = new LottoNumbers("1");
        assertThat(lottoNumbers.selectedNumber().get(0).getLottoNumber())
                .isEqualTo(TEST_LOTTO_NUBMER);
    }

    @Test
    void 로또_번호_6개_생성기() {
        lottoNumbers = lottoNumbers.generateNumbers();
        assertThat(lottoNumbers.selectedNumber().size())
                .isEqualTo(LOTTO_NUMBER_SIZE);
    }

    @Test
    void 로또_번호_6개_겹치는_숫자_없는지_체크() {
        lottoNumbers = lottoNumbers.generateNumbers();
        for (LottoNumber number : lottoNumbers.selectedNumber()) {
            assertThat(containsCount(lottoNumbers.selectedNumber(), number))
                    .isEqualTo(1);
        }
    }


    private int containsCount(List<LottoNumber> numbers, LottoNumber number) {
        return (int)numbers.stream()
                .filter(lottoNumber -> lottoNumber == number)
                .count();
    }
}
