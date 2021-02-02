package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberPickerTest {

    @DisplayName("AutoNumbersPicker를 통해 pick을 할 때, 6개의 볼이 나오는 지 확인하는 테스트")
    @Test
    void pickAutoLottoNumbers() {
        //given
        AutoNumbersPicker autoNumbersPicker = new AutoNumbersPicker();

        // when
        LottoTicket lottoNumbers = autoNumbersPicker.pick();

        // then
        assertThat(lottoNumbers.getLottoNumbers().size()).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "2,3,4,5,6,7", "3,4,5,6,7,8"})
    @DisplayName("ManualNumbersPicker를 통해 미리 입력을 해 놓고, pick을 할 때, 6개의 볼이 나오는 지 확인하는 테스트")
    void pickManualLottoNumbers(String input) {
        List<String> inputList = Arrays.asList(input);
        System.out.println(inputList.size());
        System.out.println(inputList.toString());
        //given
        ManualNumbersPicker manualNumbersPicker = new ManualNumbersPicker(inputList);

        // when
        LottoTicket lottoNumbers = manualNumbersPicker.pick();

        // then
        assertThat(lottoNumbers.getLottoNumbers().size()).isEqualTo(6);
    }
}