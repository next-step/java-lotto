package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoTest {
    private Lotto lotto;
    private Lotto lotto2;

    @Test
    @DisplayName("로또 생성 test")
    void createLotto() {
        lotto = new Lotto();
        for(int num : lotto.getNums()) {
            System.out.print(num);
            System.out.print(",");
        }
        System.out.println();
        assertThat(lotto.getNums().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 생성 랜덤 test")
    void createRandomLotto() {
        lotto = new Lotto();
        lotto2 = new Lotto();
        assertThat(lotto.equals(lotto2)).isEqualTo(false);
    }
}
