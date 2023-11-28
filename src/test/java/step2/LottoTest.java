package step2;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.lotto.domain.Lotto;
import step2.lotto.domain.LottoPurchase;
import step2.lotto.strategy.LottoNumberManualGenerator;

public class LottoTest {

    private Set<Integer> lotto;

    @BeforeEach
    void setUp() {
        Set<Integer> lottoNumbers = Set.of(1, 2, 3, 4, 5, 6);
        lotto = Set.copyOf(lottoNumbers);
    }

    @Test
    @DisplayName("6개의 숫자를 바탕으로 로또를 발급한다.")
    void lotto() {
        assertThat(Lotto.of(lotto).getLottoNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("로또 숫자의 범위는 1이상 45이하 이다.")
    void lottoNumberBoundTest() {
        Set<Integer> lottoNumbers = Set.of(1, 2, 3, 4, 5, 46);
        lotto = Set.copyOf(lottoNumbers);
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(lotto));
    }

    @Test
    @DisplayName("로또는 중복되지 않은 6개의 숫자로 이루어 진다.")
    void lottoNumberSizeTest() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 5);
        Set<Integer> lotto = Set.copyOf(lottoNumbers);
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(lotto));
    }


}