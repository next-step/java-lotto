package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.model.Lotto;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("로또 번호 생성 테스트")
    @Test
    void generate_lotto() {
        Lotto lotto = Lotto.generate();

        assertThat(lotto.getLottoNumbers()).anyMatch(num -> num>0 && num<46);
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }
}
