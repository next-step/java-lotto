package lotto.view.util;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoViewParameterHandlerTest {

    @Test
    public void 수동번호_List로변환_하기() {
        String input = "1,2,3,4,5,6\r\n7,8,9,10,11,12";
        List<String[]> manualLottoNumbers = LottoViewParameterHandler.toStringArrayList(input);
        int compareValue = 0;

        for (String[] manualLottoNumber : manualLottoNumbers) {
            for (String number : manualLottoNumber) {
                assertThat(number).isEqualTo(Integer.toString(++compareValue));
            }
        }
        assertThat(manualLottoNumbers.size()).isEqualTo(2);
    }

    @Test
    public void 수동번호_없는경우_변환_하기() {
        String input = "";
        List<String[]> manualLottoNumbers = LottoViewParameterHandler.toStringArrayList(input);
        assertThat(manualLottoNumbers.size()).isEqualTo(0);
    }
}