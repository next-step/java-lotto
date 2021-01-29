package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketPickerTest {

    @DisplayName("pick한 LottoNumber가 총 6개")
    @Test
    void pickLottoNumbers() {
        // when
        List<LottoNumber> lottoNumbers = LottoNumbersPicker.pick();

        // then
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}