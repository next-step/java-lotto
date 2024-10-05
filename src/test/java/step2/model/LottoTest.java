package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
- 당첨번호를 입력받는다.
*/
public class LottoTest {

    @DisplayName("당첨번호를 입력받는다.")
    @Test
    void addLottoNumTest() {
        Lotto lotto = new Lotto();
        lotto.addLotto(List.of(1, 2, 3, 4, 5, 6));
        lotto.addLotto(List.of(7, 8, 9, 10, 11, 12));

        assertThat(lotto.getLottos())
                .containsExactly(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(7, 8, 9, 10, 11, 12)
                );
    }


}
