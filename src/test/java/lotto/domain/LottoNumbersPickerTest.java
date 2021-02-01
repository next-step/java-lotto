package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersPickerTest {

    @DisplayName("NumberPicker를 통해 pick을 할 때, 6개의 볼이 나오는 지 확인하는 테스트")
    @Test
    void pickLottoNumbers() {
        //given
        NumberPicker numberPicker = new LottoNumbersPicker();

        // when
        List<LottoNumber> lottoNumbers = numberPicker.pick();

        // then
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}