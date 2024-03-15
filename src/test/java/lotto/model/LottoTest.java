package lotto.model;

import lotto.exception.InvalidLottoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void empty() {
        List<LottoNumber> empty = Collections.emptyList();

        assertThatThrownBy(() -> new Lotto(empty))
                .isInstanceOf(InvalidLottoException.class);
    }

    @Test
    void 로또번호는6개만선택가능하다() {
        List<LottoNumber> five = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5));

        List<LottoNumber> seven = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6), new LottoNumber(7));

        assertThatThrownBy(() -> new Lotto(five))
                .isInstanceOf(InvalidLottoException.class);
        assertThatThrownBy(() -> new Lotto(seven))
                .isInstanceOf(InvalidLottoException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "7,0"}, delimiter = ',')
    void 하나의_번호를_로또번호와_매칭한다(int given, int expected) {
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        Lotto lotto = new Lotto(lottoNumbers);
        int actual = lotto.match(new LottoNumber(given));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void matchNull() {
        int expected = 0;
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        Lotto lotto = new Lotto(lottoNumbers);
        int actual = lotto.match(null);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 여러개의_번호를_로또번호와_매칭한다() {
        int expected = 6;
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        Lotto lotto = new Lotto(lottoNumbers);
        int actual = lotto.matches(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void matchesEmptyList() {
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        Lotto lotto = new Lotto(lottoNumbers);

        assertThatThrownBy(() -> lotto.matches(Collections.emptyList()))
                .isInstanceOf(InvalidLottoException.class);
    }

    @Test
    void matchesNull() {
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        Lotto lotto = new Lotto(lottoNumbers);

        assertThatThrownBy(() -> lotto.matches(null))
                .isInstanceOf(InvalidLottoException.class);
    }
}
