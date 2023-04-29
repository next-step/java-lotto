package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LottoNumbersTest {

    @Test
    void create() {
        LottoNumbers lottoNumbers = getLottoNumbers();
        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void contains() {
        LottoNumbers lottoNumbers1 = getLottoNumbers();
        assertThat(lottoNumbers1.contains(LottoNumber.valueOf(1))).isTrue();
        assertThat(lottoNumbers1.contains(LottoNumber.valueOf(11))).isFalse();
    }

    @Test
    void match() {

    }

    private LottoNumbers getLottoNumbers() {
        return new LottoNumbers(new HashSet<>(
                List.of(
                        LottoNumber.valueOf(1),
                        LottoNumber.valueOf(2),
                        LottoNumber.valueOf(3),
                        LottoNumber.valueOf(4),
                        LottoNumber.valueOf(5),
                        LottoNumber.valueOf(6)
                )
        ));
    }
}
