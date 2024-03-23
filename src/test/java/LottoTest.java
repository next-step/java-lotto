import domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 번호 확인")
    public void list() {
        List<Integer> mynumbers = List.of(1, 2, 3, 9, 22, 33);
        Lotto lotto = new Lotto(mynumbers);

        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);

        assertThat(lotto.numberCheck(winningNumber)).isEqualTo(3);
    }
}
