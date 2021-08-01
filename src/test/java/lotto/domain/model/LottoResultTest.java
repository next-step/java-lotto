package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = LottoResult.createEmpty();
    }

    @ParameterizedTest
    @EnumSource(LottoRank.class)
    @DisplayName("생성 직후 모든 상금 등급에 따른 개수가 0이다.")
    void getCount_init_correctly(LottoRank lottoRank) {
        assertThat(lottoResult.getCountByRank(lottoRank)).isEqualTo(0);
    }

    @Test
    @DisplayName("상금 등급을 알려주면 해당 등급 숫자가 개수만큼 증가한다.")
    void update_once() {
        LottoRank updatedLottoRank = LottoRank.FIRST;
        int count = 3;
        lottoResult.update(updatedLottoRank, count);
        assertThat(lottoResult.getCountByRank(updatedLottoRank)).isEqualTo(count);
    }

    @Test
    void sumWinningMoney() {
        lottoResult.update(LottoRank.THIRD, 2);
        int prizeMoney = lottoResult.sumWinningMoney();
        assertThat(prizeMoney).isEqualTo(2 * LottoRank.THIRD.getWinningMoney());
    }
}
