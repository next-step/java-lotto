package step2.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    @Test
    @DisplayName("로또 생성")
    void lotto() {
        Lotto lotto = Lotto.create();
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("공 6개 미만인 경우 로또 생성 실패")
    void create_fail() {
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.create(List.of(1, 2, 3, 4, 5)));
    }

    @Test
    @DisplayName("로또 당첨 비교, equalsAndHashCode")
    void equals_lotto() {
        Lotto lotto = Lotto.create();

        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        Lotto newLotto = new Lotto(lottoNumbers);

        assertThat(lotto).isEqualTo(newLotto);
    }
}
