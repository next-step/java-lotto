package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/*
- 당첨번호를 입력받는다.
*/
public class BoughtLottoTest {

    @DisplayName("당첨번호를 입력받는다.")
    @Test
    void addLottoNumTest() {
        BoughtLotto boughtLotto = new BoughtLotto();
        boughtLotto.addLotto(new Lotto(Set.of(1, 2, 3, 4, 5, 6)));
        boughtLotto.addLotto(new Lotto(Set.of(7, 8, 9, 10, 11, 12)));

        assertThat(boughtLotto.getBoughtLotto())
                .containsExactlyInAnyOrder(
                        new Lotto(Set.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(Set.of(7, 8, 9, 10, 11, 12))
                );
    }

}
