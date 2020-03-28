package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}