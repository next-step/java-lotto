package step3.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TotalLottoTest {

    @Test
    @DisplayName("size 반환 테스트")
    void sizeTest() {
        TotalLotto totalLotto = new TotalLotto();
        assertThat(totalLotto.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("로또 1개를 add하는 테스트")
    void addTest() {
        TotalLotto totalLotto = new TotalLotto();
        totalLotto.addLottoOne(new LottoNumbers());
        totalLotto.addLottoOne(new LottoNumbers());
        assertThat(totalLotto.size()).isEqualTo(2);
    }

}
