package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoFactoryTest {

    @Test
    @DisplayName("구입금액에 따른 올바른 로또 개수를 리턴한다")
    void test1() throws Exception {
        int purchaseMoney = 4000;
        LottoFactory lottoFactory = new LottoFactory(purchaseMoney);
        assertThat(lottoFactory.lottoCount()).isEqualTo(4);
    }
    @Test
    @DisplayName("구입금액은 1000원 이상이어야한다.")
    void test2() throws Exception {
        int purchaseMoney = 800;
        assertThatThrownBy(() -> new LottoFactory(purchaseMoney))
                .hasMessageContaining("1000원 이상");
    }

}