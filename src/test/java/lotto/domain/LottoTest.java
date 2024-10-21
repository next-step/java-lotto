package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또생성() {
        Set<LottoNumber> lottoNumbers = getLottoNumbers();
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto).isNotNull();
    }

    @Test
    void 로또_번호개수_검증() {
        Set<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5)
                .map(LottoNumber::from)
                .collect(Collectors.toSet());
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_중복_검증() {
        Set<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 5)
                .map(LottoNumber::from)
                .collect(Collectors.toSet());
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 번호_비교() {
        Set<LottoNumber> lottoNumbers = getLottoNumbers();
        Set<LottoNumber> winningNumbers = getLottoNumbers();
        Lotto lotto = new Lotto(lottoNumbers);
        Lotto winningLotto = new Lotto(winningNumbers);

        assertThat(lotto.countMatchCount(winningLotto)).isEqualTo(6);
    }

    private static Set<LottoNumber> getLottoNumbers() {
        return Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::from)
                .collect(Collectors.toSet());
    }
}
