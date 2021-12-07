package lotto;

import lotto.game.LottoNumber;
import lotto.game.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoNumbersTest {
    @Test
    void matchCount() {
        LottoNumbers lottoNumbers = LottoNumbers.generate(Arrays.asList(1, 2, 3, 4, 5, 6));
        int matchCount = lottoNumbers.matchCount(LottoNumbers.generate(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(matchCount).isEqualTo(6);
    }

    @Test
    void nonMatchCount() {
        LottoNumbers lottoNumbers = LottoNumbers.generate(Arrays.asList(1, 2, 3, 4, 5, 6));
        int matchCount = lottoNumbers.matchCount(LottoNumbers.generate(Arrays.asList(7, 8, 9, 10, 11, 12)));
        assertThat(matchCount).isEqualTo(0);
    }

    @Test
    void size() {
        LottoNumbers lottoNumbers = LottoNumbers.generate(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또는 6개의 숫자만을 선택할 수 있다.")
    void sixNumberMustProvided() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumbers.generate(Arrays.asList(1, 2, 3, 4, 5));
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumbers.generate(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        });
    }

    @Test
    void duplicateNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumbers.generate(Arrays.asList(1, 2, 3, 4, 5, 5));
        });
    }

    @Test
    void contains() {
        LottoNumbers lottoNumbers = LottoNumbers.generate(Arrays.asList(1, 2, 3, 4, 5, 6));
        boolean contains = lottoNumbers.contains(new LottoNumber(6));
        assertTrue(contains);
    }

    @Test
    void toStringTest() {
        LottoNumbers lottoNumbers = LottoNumbers.generate(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumbers.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
