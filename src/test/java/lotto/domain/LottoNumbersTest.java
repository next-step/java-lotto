package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {
    @Test
    @DisplayName("로또 번호 목록은 45개의 목록을 가진다.")
    void shouldContain45Numbers() {
        final LottoNumbers lottoNumbers = new LottoNumbers();
        assertThat(lottoNumbers.size()).isEqualTo(45);
    }

    @Test
    @DisplayName("로또 번호 목록의 shuffle 은 랜덤한 6개의 로또 번호를 반환한다.")
    void shouldReturnSixRandomLottoNumbers() {
        final LottoNumbers lottoNumbers = new LottoNumbers();
        final LottoNumbers shuffleNumbers = lottoNumbers.shuffle();
        assertThat(shuffleNumbers.size()).isEqualTo(6);
    }
}