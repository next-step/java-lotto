package lotto.domain;

import lotto.utils.LottoInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private LottoInput lottoInput;

    @BeforeEach
    void setUp() {
        lottoInput = new LottoInput(Arrays.asList(10, 20, 30, 40, 45));
    }

    @DisplayName("생성된 로또 번호 확인")
    @Test
    public void makeLottoNumberWithInput() {


        Lotto lotto = new Lotto(lottoInput);
        lotto.makeLottoNumber();
        String selectedLottoNumber = lotto.getSelectedLottoNumbers();
        assertThat(selectedLottoNumber).isEqualTo("[10, 20, 30, 40, 45]");
    }

    @DisplayName("생성된 로또 번호와 지난 주 당첨 번호를 비교훟 일치하는 갯수 반환")
    @Test
    public void getEqualsCount(){

        Lotto lotto = new Lotto(lottoInput);
        lotto.makeLottoNumber();
        int count = lotto.getEqualsCount(Arrays.asList(10,20,30,34,44,45));
        assertThat(count).isEqualTo(4);
    }
}
