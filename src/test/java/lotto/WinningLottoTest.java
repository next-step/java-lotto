package lotto;

import lotto.model.BoughtLotto;
import lotto.model.WinningLotto;
import lotto.utility.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    @DisplayName("구매자 로또 등수 결정하는 테스트")
    public void determineRank() {
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6", 7);

        BoughtLotto boughtLotto = new BoughtLotto(List.of(2, 3, 5, 7, 1, 4));

        assertThat(winningLotto.determineRank(boughtLotto)).isEqualTo(2);
    }


}
