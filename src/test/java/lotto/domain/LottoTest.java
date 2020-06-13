package lotto.domain;

import lotto.utils.LottoInput;
import lotto.utils.LottoShuffle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("생성된 로또 번호 확인")
    @Test
    public void makeLottoNumberWithInput() {

        LottoInput lottoInput = new LottoInput(Arrays.asList(10, 20, 30, 40, 45));
        Lotto lotto = new Lotto(lottoInput);
        lotto.makeLottoNumber();
        String selectedLottoNumber = lotto.getSelectedLottoNumber();
        assertThat(selectedLottoNumber).isEqualTo("[10, 20, 30, 40, 45]");
    }
}
