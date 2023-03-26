package lotto;

import lotto.domain.LottoRandomPicker;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRandomPickerTest {

    @Test
    public void pickLottoNumber(){
        for(int i=0;i<30000;i++){
            assertThat(LottoRandomPicker.pickLottoNumber())
                    .isGreaterThan(0).isLessThan(47);
        }
    }
}
