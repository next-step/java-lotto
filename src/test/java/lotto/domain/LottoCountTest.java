package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoCountTest {

    @Test
    @DisplayName("횟수를 이용해 LottoCount 생성한다.")
    void makeLottoCountByCount() {
        LottoCount firstLottoCount = new LottoCount(1, 1);
        LottoCount secondLottoCount = new LottoCount(1, 1);

        assertThat(firstLottoCount).isEqualTo(secondLottoCount);
    }
}