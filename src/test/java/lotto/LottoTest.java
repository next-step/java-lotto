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

}
