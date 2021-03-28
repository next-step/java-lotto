package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 객체 생성")
    public void create() throws Exception {
        LottoNumbers lottoNumbers = new LottoNumbers();
        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(lottoNumbers.lottoNumbers()));
    }
}
