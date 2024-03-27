package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoCountTest {

    @Test
    @DisplayName("Money를 이용해 LottoCount 생성한다.")
    void makeLottoCountByMoney() {
        LottoCount firstLottoCount = new LottoCount(new Money(1000));
        LottoCount secondLottoCount = new LottoCount(new Money(1000));

        assertThat(firstLottoCount).isEqualTo(secondLottoCount);
    }

    @Test
    @DisplayName("횟수를 이용해 LottoCount 생성한다.")
    void makeLottoCountByCount() {
        LottoCount firstLottoCount = new LottoCount(1);
        LottoCount secondLottoCount = new LottoCount(1);

        assertThat(firstLottoCount).isEqualTo(secondLottoCount);
    }

    @Test
    @DisplayName("카운트 차감을 했을 때 차감한 Count와 같은지 확인한다.")
    void subtractCount() {
        LottoCount firstLottoCount = new LottoCount(1);
        LottoCount secondLottoCount = new LottoCount(0);
        LottoCount subtractCount = firstLottoCount.subtractCount(secondLottoCount);

        assertThat(firstLottoCount).isEqualTo(subtractCount);

    }
}