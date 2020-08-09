package camp.nextstep.edu.rebellion.lotto.rule;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameRuleTest {
    @DisplayName("로또 게임 규칙을 잘 가져오는 지 확인")
    @Test
    public void ruleTest() {
        // given
        int lottoCount = 6;
        int lottoPrice = 1000;
        int lottoPurchaseLimit = 100000;
        int lottoNumberMin = 1;
        int lottoNumberMax = 45;

        // when & then
        assertAll(
                () -> assertThat(LottoGameRule.getLottoCount()).isEqualTo(lottoCount),
                () -> assertThat(LottoGameRule.getLottoPrice()).isEqualTo(lottoPrice),
                () -> assertThat(LottoGameRule.getLottoPurchaseLimit()).isEqualTo(lottoPurchaseLimit),
                () -> assertThat(LottoGameRule.getLottoNumberMin()).isEqualTo(lottoNumberMin),
                () -> assertThat(LottoGameRule.getLottoNumberMax()).isEqualTo(lottoNumberMax)
        );
    }
}
