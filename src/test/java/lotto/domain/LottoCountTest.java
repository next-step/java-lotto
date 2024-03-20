package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoCountTest {

    private LottoPicker lottoPicker;

    @BeforeEach
    public void setUp() {
        lottoPicker = new LottoPicker();
    }

    @Test
    @DisplayName("로또 구매 갯수 설정 테스트")
    void purchaseCount() {
        // given
        int money = 14000;

        // when
        LottoCount lottoCount = new LottoCount(money);

        // then
        assertThat(lottoCount.getLottoCount()).isEqualTo(14000/1000);

    }
}
