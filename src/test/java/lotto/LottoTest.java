package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    @Test
    public void 로또_당첨_개수_확인() {
        Lotto lotto = new Lotto(new ArrayList<>(List.of(2, 5, 3, 12, 33, 45)));
        int bonusNumber = 45;

        assertThat(lotto.countMatchingNumber(List.of(5, 33, 45, 6, 21, 42), bonusNumber))
                .isEqualTo(4);
    }

    @Test
    public void 보너스번호_포함() {
        Lotto lotto = new Lotto(new ArrayList<>(List.of(5, 2, 13, 23, 21, 43)));
        int bonusNumber = 13;

        assertThat(lotto.containsBonusNumber(bonusNumber)).isTrue();
    }
}
