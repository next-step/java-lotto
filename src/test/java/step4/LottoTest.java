package step4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import step4.domian.Lotto;

import java.util.List;

public class LottoTest {

    @Test
    void 로또가_숫자를_포함하는지() {
        Lotto lotto = new Lotto(List.of(3, 4, 5, 6, 7, 8));

        Assertions.assertThat(lotto.isContain(5)).isEqualTo(1);
    }
}
