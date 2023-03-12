package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @DisplayName("생성된 로또 번호 갯수 체크")
    @Test
    void lottoNumberLengthCheck() {
        LottoGenerator generator = new LottoGenerator();
        Lotto actual = generator.generate();
        assertThat(actual.getLotto().size()).isEqualTo(7);
    }

    @DisplayName("로또 번호는 중복되지 않는다")
    @Test
    void lottoDuplicateCheck() {
        LottoGenerator generator = new LottoGenerator();
        Lotto actual = generator.generate();
        assertThat(actual.getLotto().stream().distinct().count()).isEqualTo(actual.getLotto().size());
    }

}
