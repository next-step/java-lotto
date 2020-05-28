package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.model.LottoNumber;
import step2.model.LottoNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @DisplayName("로또 번호 6개를 리스트로 반환한다")
    @Test
    void generate_void_LottoNumbers() {
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.generate();

        assertThat(lottoNumbers).hasSize(6);
    }
}
