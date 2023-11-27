package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoFactoryTest {

    @Test
    @DisplayName("구입금액에 따른 올바른 로또 개수를 리턴한다")
    void test1() {
        int purchaseMoney = 4000;
        LottoFactory lottoFactory = new LottoFactory(purchaseMoney);
        assertThat(lottoFactory.totalLottoCount()).isEqualTo(4);
    }

    @Test
    @DisplayName("수동으로 구매한 로또가 없으면 나머지는 모두 자동이다")
    void test2() {
        int purchaseMoney = 4000;
        ManualCount manualCount = new ManualCount(0);
        LottoFactory lottoFactory = new LottoFactory(purchaseMoney, manualCount);
        assertThat(lottoFactory.totalLottoCount()).isEqualTo(4);
    }
}