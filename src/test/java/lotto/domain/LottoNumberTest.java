package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("로또 자동 넘버 테스트")
    @Test
    public void LottoRandomNumberTest() {
        LottoNumber lottoNumber = new LottoNumber();
        lottoNumber.setLotto(
                new LottoNumberStragey(){
                    @Override
                    public List<Integer> getLottoNumber() {
                        return Arrays.asList(1,2,3,4,5,6);
                    }
                }
        );

        assertThat(lottoNumber.getLotto()).contains(1,2,3,4,5,6);

    }

}