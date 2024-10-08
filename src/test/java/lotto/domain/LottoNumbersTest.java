package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {
    @Test
    @DisplayName("로또 번호 목록은 45개의 목록을 가진다.")
    void shouldContain45Numbers() {
        final LottoNumbers lottoNumbers = new LottoNumbers();
        assertThat(lottoNumbers.size()).isEqualTo(45);
    }

    @Test
    @DisplayName("로또 번호 목록의 shuffleAndPickLottoNumbers 은 랜덤한 6개의 로또 번호를 반환한다.")
    void shouldReturnSixRandomLottoNumbers() {
        final LottoNumbers lottoNumbers = new LottoNumbers();
        final LottoNumbers shuffleNumbers = lottoNumbers.shuffleAndPickLottoNumbers();
        assertThat(shuffleNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("특정 로또 번호가 포함되어있는지 확인 할 수 있다.")
    void shouldContainLottoNumber() {
        final LottoNumbers lottoNumbers = new LottoNumbers(
            List.of(new LottoNumber(1), new LottoNumber(33))
        );

        assertThat(lottoNumbers.contains(new LottoNumber(33))).isTrue();
    }

    @Test
    @DisplayName("넘어온 로또 번호 목록괴 몇 개나 일치하는지 확인 할 수 있다.")
    void shouldReturnMatchCountWithGivenLottoNumbers() {
        final LottoNumbers lottoNumbers = new LottoNumbers(
            List.of(new LottoNumber(1), new LottoNumber(33))
        );
        final LottoNumbers targetLottoNumbers = new LottoNumbers(
            List.of(new LottoNumber(44), new LottoNumber(33))
        );

        assertThat(lottoNumbers.matchCount(targetLottoNumbers)).isEqualTo(1);
    }
}