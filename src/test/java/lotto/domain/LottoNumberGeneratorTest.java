package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

    private LottoNumberGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new LottoNumberGenerator();
    }

    @DisplayName("무작위 6개의 로또 번호를 생성한다.")
    @Test
    void generate() {
        List<LottoNumber> lottoNumbers = generator.generate();

        assertThat(lottoNumbers).hasSize(6);
    }

    @DisplayName("6개의 로또 번호중 중복 되지 않는다.")
    @Test
    void isDuplicate() {
        List<LottoNumber> lottoNumbers = generator.generate();

        List<LottoNumber> expect = new ArrayList<>();

        for (LottoNumber lottoNumber : lottoNumbers) {
            assertThat(expect).doesNotContain(lottoNumber);
        }
    }
}