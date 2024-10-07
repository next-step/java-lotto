package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/*
- 당첨번호를 입력받는다.
*/
public class LottoTest {

    @DisplayName("당첨번호를 입력받는다.")
    @Test
    void addLottoNumTest() {
        Lotto lotto = new Lotto();
        lotto.addLotto(Set.of(1, 2, 3, 4, 5, 6));
        lotto.addLotto(Set.of(7, 8, 9, 10, 11, 12));

        assertThat(lotto.getLottos())
                .containsExactly(
                        Set.of(1, 2, 3, 4, 5, 6),
                        Set.of(7, 8, 9, 10, 11, 12)
                );
    }


}
