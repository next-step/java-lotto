package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoCountTest {

    @DisplayName("3000원을 지불했을 때, 5회의 수동 카운트를 등록하면, Illegal 에러를 발생시키는 테스트")
    @Test
    void validateIllegalManualCount() {
        //given
        final Money money = new Money(3000);

        //when & then
        assertThrows(IllegalArgumentException.class,
                () -> new LottoCount(money, 5));
    }

    @DisplayName("3000원을 지불했을 때, 1회의 수동 카운트를 등록하면, 수동 1회, 자동 2회가 나오는 지 확인하는 테스트")
    @Test
    void getLottoCountTest() {
        //given
        final Money money = new Money(3000);
        final LottoCount lottoCount = new LottoCount(money, 1);

        //when
        int manualLottoCount = lottoCount.getManualLottoCount();
        int autoLottoCount = lottoCount.getAutoLottoCount();

        //then
        assertThat(manualLottoCount).isEqualTo(1);
        assertThat(autoLottoCount).isEqualTo(2);
    }
}