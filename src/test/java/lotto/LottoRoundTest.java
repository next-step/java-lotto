package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

class LottoRoundTest {
    @DisplayName("로또 등수 확인")
    @Test
    public void test() throws Exception {
        LottoRound lottoRound = new LottoRound(Set.of(1, 2, 4, 3, 5, 6));
        Assertions.assertThat(lottoRound.checkLottoRank(new LottoNumber(Set.of(1,2,3,4,5,6))))
                .isEqualTo(LottoRank.FIRST);

        Assertions.assertThat(lottoRound.checkLottoRank(new LottoNumber(Set.of(1,2,3,4,5,7))))
                .isEqualTo(LottoRank.SECOND);

        Assertions.assertThat(lottoRound.checkLottoRank(new LottoNumber(Set.of(1,2,3,4,7,8))))
                .isEqualTo(LottoRank.THIRD);

        Assertions.assertThat(lottoRound.checkLottoRank(new LottoNumber(Set.of(1,2,3,7,8,9))))
                .isEqualTo(LottoRank.FOURTH);

        Assertions.assertThat(lottoRound.checkLottoRank(new LottoNumber(Set.of(1,2,7,8,9,10))))
                .isNull();

        Assertions.assertThat(lottoRound.checkLottoRank(new LottoNumber(Set.of(1,7,8,9,10,11))))
                .isNull();

        Assertions.assertThat(lottoRound.checkLottoRank(new LottoNumber(Set.of(7,8,9,10,11,12))))
                .isNull();
    }
}