package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    @DisplayName("로또는 6개의 로또번호를 가진다.")
    void shouldContainExactlySixNumbers() {
        final LottoNumbers lottoNumbers = new LottoNumbers();
        final Lotto lotto = new Lotto(lottoNumbers.shuffleAndPickLottoNumbers());

        assertThat(lotto.size()).isEqualTo(6);
    }
}
