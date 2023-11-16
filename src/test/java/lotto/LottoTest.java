package lotto;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoTest {

    @Test
    void 번호_생성_확인() {
        Lotto lotto = new Lotto();
        List<Integer> selectedNumber = lotto.selectedNumber();
        System.out.println("selectedNumber = " + selectedNumber);

        Assertions.assertThat(selectedNumber).hasSize(6);
    }

    @Test
    void 당첨_번호_갯수_확인() {
        Lotto lotto = new Lotto();
        lotto.matchResult(3);

        Assertions.assertThat(lotto.getMatchCount()).isEqualTo(3);
    }

}
