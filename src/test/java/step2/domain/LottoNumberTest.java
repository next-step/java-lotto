package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @DisplayName("로또 발행 시 6개의 번호가 있는 로또가 발행")
    @Test
    void lotto_list_size_6(){
        LottoNumbers lottoNumbers = LottoNumbers.from(LottoNumberGenerator.generateLottoNumber());
        Assertions.assertThat(lottoNumbers.getLottoNumbers().size()).isEqualTo(6);
    }
}
