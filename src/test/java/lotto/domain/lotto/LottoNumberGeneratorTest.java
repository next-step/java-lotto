package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoNumberGenerator 클래스 테스트")
public class LottoNumberGeneratorTest {

    @DisplayName("자동 로또 번호를 생성할 수 있다.")
    @Test
    void create_auto() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(new Price(1000), Collections.emptyList());
        assertThat(lottoNumberGenerator.getLottoNumbers()).hasSize(1);
    }

    @DisplayName("수동 로또 번호를 생성할 수 있다.")
    @Test
    void create_manual() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(new Price(1000), Collections.singletonList("1,2,3,4,5,6"));
        assertThat(lottoNumberGenerator.getLottoNumbers()).hasSize(1);
    }

    @DisplayName("자동, 수동 로또 번호를 생성할 수 있다.")
    @Test
    void create_all() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(new Price(2000), Collections.singletonList("1,2,3,4,5,6"));
        assertThat(lottoNumberGenerator.getLottoNumbers()).hasSize(2);
    }
}
