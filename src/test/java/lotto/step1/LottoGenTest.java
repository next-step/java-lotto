package lotto.step1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGenTest {
    @DisplayName("생성된 로또 번호 갯수 체크")
    @Test
    void lottoNumberLengthCheck() {
        LottoGen generator = new LottoGen();
        Lotto actual = generator.generate();
        assertThat(actual.getLotto().size()).isEqualTo(7);
    }

    @DisplayName("로또 번호 중복 불가")
    @Test
    void lottoDuplicateCheck() {
        LottoGen generator = new LottoGen();
        Lotto actual = generator.generate();
        assertThat(actual.getLotto().stream().distinct().count()).isEqualTo(actual.getLotto().size());
    }
}
