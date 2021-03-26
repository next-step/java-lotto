package step2.domain.Lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersGeneratorTest {

    @DisplayName("LottoNumbersGenerator 인스턴스 생성 테스트")
    @Test
    void 생성() {
        // when
        LottoNumbersGenerator lottoNumbersGenerator = LottoNumbersGenerator.getInstance();

        // then
        assertThat(lottoNumbersGenerator).isNotNull();
    }
}