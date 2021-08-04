package lotto.domain;

import lotto.LottoRank;
import lotto.exception.InvalidLottoRankException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoRankTests {

    @DisplayName("로또를 몇개 맞았는지 수로 RankEnum 이 일치하는지 테스트")
    @Test
    void rankEnumTest() {
        LottoRank lottoRank = LottoRank.valueOf(3);

        assertThat(lottoRank).isEqualTo(LottoRank.THREE_MATCH);
    }

    @DisplayName("Rank 에 없는 로또를 몇개 맞았는지 수를 입력 했을 때 Enum 값이 OUT_OF_RANK 인지 테스트")
    @Test
    void invalidLottoRankExceptionTest() {
        LottoRank lottoRank = LottoRank.valueOf(2);

        assertThat(lottoRank).isEqualTo(LottoRank.OUT_OF_RANK);
    }
}
