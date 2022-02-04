package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void 총_6개의_중복되지_않은_로또_숫자를_가진다() {
        List<LottoNumber> lottoNumbers = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.count()).isEqualTo(6);
    }

    @Test
    void 중복된_숫자를_가질_수_없다() {
        List<LottoNumber> lottoNumbers = Arrays.stream(new int[]{1, 1, 2, 3, 4, 5})
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 갯수는_6개_미만_혹은_초과_할_수_없다() {
        List<LottoNumber> underLottoNumbers = Arrays.stream(new int[]{1, 2, 3, 4, 5})
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        List<LottoNumber> overLottoNumbers = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7})
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        assertThatThrownBy(() -> new Lotto(underLottoNumbers))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(overLottoNumbers))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
