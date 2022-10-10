package step2.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @DisplayName("로또 발행 시 6개의 번호가 있는 로또가 발행")
    @Test
    void lotto_list_size_6(){
        LottoNumber lottoGame = LottoNumber.newInstance();
        List<Integer> lottoNumbers = lottoGame.getLottoNumbers();
        Assertions.assertThat(lottoNumbers).isEqualTo(6);
    }
}
