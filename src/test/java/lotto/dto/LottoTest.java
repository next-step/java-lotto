package lotto.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {



    @Test
    public void 로또생성테스트() {
        Lotto lt = new Lotto();
        assertThat(lt.getLotto()).hasSize(6);
    }

}
