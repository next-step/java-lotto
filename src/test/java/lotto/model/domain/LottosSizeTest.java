package lotto.model.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class LottosSizeTest {

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "5001,3", "14001,0"})
    void 로또_개수_생성_성공(long totalMoney, long manualSize) {
        // given
        final LottoMoney totalLottoMoney = LottoMoney.valueOf(totalMoney);

        // when & then
        assertThatNoException().isThrownBy(() -> LottosSize.of(totalLottoMoney, manualSize));
    }

    @Test
    void 총_로또_개수가_0이하면_실패() {
        // given
        final LottoMoney lottoMoney = LottoMoney.valueOf(Lotto.COST - 1);

        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> LottosSize.of(lottoMoney, 1));
    }

    @Test
    void 수동_로또_개수가_0미만이거나_총_로또_개수_초과면_실패() {
        // given
        final LottoMoney lottoMoney = LottoMoney.valueOf(2000);
        final long manualSize1 = -1;
        final long manualSize2 = 3;

        // when & then
        SoftAssertions.assertSoftly(softAssertions -> {
                    assertThatIllegalArgumentException().isThrownBy(() -> LottosSize.of(lottoMoney, manualSize1));
                    assertThatIllegalArgumentException().isThrownBy(() -> LottosSize.of(lottoMoney, manualSize2));
                }
        );
    }
}
