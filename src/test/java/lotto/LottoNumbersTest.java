package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class LottoNumbersTest {

    @Test
    void create() {
        LottoNumbers lottoNumbers = getLottoNumbers();
        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void exception() {
        assertThatThrownBy(() -> new LottoNumbers(List.of(1, 2, 3, 4, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void contains() {
        LottoNumbers lottoNumbers1 = getLottoNumbers();
        assertThat(lottoNumbers1.contains(LottoNumber.valueOf(1))).isTrue();
        assertThat(lottoNumbers1.contains(LottoNumber.valueOf(11))).isFalse();
    }

    private LottoNumbers getLottoNumbers() {
        return new LottoNumbers(List.of(1,2,3,4,5,6));
    }
}
