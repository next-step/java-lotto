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

        assertThat(lotto.countMatchingNumber(List.of(5, 33, 45, 6, 21, 42)))
                .isEqualTo(3);
    }
}
