package lotto.dto;

import lotto.utils.LottoMaker;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {



    @Test
    public void 로또생성테스트() {
        Lotto lt = new Lotto(LottoMaker.getSixNumsAfterShuffle(LottoMaker.getOnetoFortyFive()));
        assertThat(lt.getLotto()).hasSize(6);
    }

}
