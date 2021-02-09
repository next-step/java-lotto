package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersPickerTest {

    @DisplayName("pick한 LottoNumber가 총 6개")
    @Test
    void pickLottoNumbers() {
        // given & when
        List<LottoNumber> lottoNumbers = LottoNumbersPicker.pick();

        // then
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @DisplayName("pick한 LottoNumber의 리스트는 항상 오름차순")
    @Test
    void lottoNumbersAscendingOrder() {
        // given & when
        List<LottoNumber> lottoNumbers = LottoNumbersPicker.pick();

        // then
        assertThat(lottoNumbers).isSortedAccordingTo(LottoNumber::compareTo);
    }
}