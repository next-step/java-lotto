package lotto;

import lotto.domain.LottoNumbers;
import lotto.utils.LottoRandomNumberUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 객체 생성")
    public void create() throws Exception {
        List<Integer> lottoRandomNumbers = LottoRandomNumberUtil.lottoNumbers();
        LottoNumbers lottoNumbers = new LottoNumbers(lottoRandomNumbers);
        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(lottoRandomNumbers));
    }
}
