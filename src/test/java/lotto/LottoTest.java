package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    @DisplayName("Lotto 번호 개수 46개 확인")
    void generate_lotto_numbers() throws Exception {
        //Given
        Lotto lottos = new Lotto();

        //When
        List<LottoNumber> lottoNumbers = lottos.getLottoNumbers();

        //Then
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(46);
    }

}
