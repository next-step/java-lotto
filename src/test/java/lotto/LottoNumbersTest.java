package lotto;

import lotto.domain.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class LottoNumbersTest {

    @Test
    @DisplayName("로또 1장 생성 테스트")
    public void lottoMake(){
        assertThat(LottoNumber.getLottoNumbers()).hasSize(6);
    }
}
