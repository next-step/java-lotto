package lotto.domain;

import lotto.util.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    @DisplayName("로또는 6개의 로또번호를 가진다.")
    void shouldContainExactlySixNumbers() {
        final Lotto lotto = new Lotto(LottoNumberGenerator.shuffleAndPickLottoNumbers());

        assertThat(lotto.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("비교대상으로 주어진 로또와 일치한지 비교할 수 있다.")
    void shouldMatchWithGivenLotto() {
        final List<LottoNumber> pickLottoNumbers = LottoNumberGenerator.shuffleAndPickLottoNumbers();
        final Lotto lotto1 = new Lotto(pickLottoNumbers);
        final Lotto lotto2 = new Lotto(pickLottoNumbers);

        assertThat(lotto1.allMatch(lotto2)).isTrue();
    }

    @Test
    @DisplayName("비교대상으로 주어진 로또와 몇개나 일치한지 알 수 있다.")
    void shouldReturnMatchedCountWithGivenLotto() {
        final Lotto lotto1 = new Lotto(
            List.of(
                new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6)
            )
        );
        final Lotto lotto2 = new Lotto(
            List.of(
                new LottoNumber(33), new LottoNumber(11),
                new LottoNumber(17), new LottoNumber(26),
                new LottoNumber(5), new LottoNumber(6)
            )
        );

        assertThat(lotto1.matchCount(lotto2)).isEqualTo(2);
    }
}
