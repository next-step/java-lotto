package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoUtilTest {

    @Test
    @DisplayName("로또 구입 금액을 입력하면 구입한 로또 개수를 반환한다.")
    void 구입한_로또_개수_반환(){
        assertThat(LottoUtil.returnLottoCount(14000)).isEqualTo(14);
    }

}
