package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static step2.domain.LottoNumberGenerator.lottoNumbers;

public class LottoNumberGeneratorTest {

    @Test
    @DisplayName("주어진 로또 장수 만큼 로또가 생성된다")
    public void lotto_count() {
        assertThat(lottoNumbers(14)).hasSize(14);
    }

    @Test
    @DisplayName("생성된 로또 번호들의 개수를 확인한다")
    public void lotto_number_size() {
        assertThat(lottoNumbers(1).get(0).numbers()).hasSize(6);
    }



}
