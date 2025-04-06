package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoRound;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class LottoRoundTest {
    @DisplayName("로또 등수 확인")
    @Test
    public void lottoRank() throws Exception {
        LottoRound lottoRound = new LottoRound(Set.of(1, 2, 4, 3, 5, 6), 7);
        Assertions.assertThat(lottoRound.checkLottoRank(new LottoNumbers("1,2,3,4,5,6")))
                .isEqualTo(LottoRank.FIRST);

        Assertions.assertThat(lottoRound.checkLottoRank(new LottoNumbers("1,2,3,4,5,7")))
                .isEqualTo(LottoRank.SECOND);

        Assertions.assertThat(lottoRound.checkLottoRank(new LottoNumbers("1,2,3,4,5,8")))
                .isEqualTo(LottoRank.THIRD);

        Assertions.assertThat(lottoRound.checkLottoRank(new LottoNumbers("1,2,3,4,8,9")))
                .isEqualTo(LottoRank.FOURTH);

        Assertions.assertThat(lottoRound.checkLottoRank(new LottoNumbers("1,2,3,7,8,9")))
                .isEqualTo(LottoRank.FIFTH);

        Assertions.assertThat(lottoRound.checkLottoRank(new LottoNumbers("1,2,7,8,9,10")))
                .isEqualTo(LottoRank.ETC);

        Assertions.assertThat(lottoRound.checkLottoRank(new LottoNumbers("1,7,8,9,10,11")))
                .isEqualTo(LottoRank.ETC);

        Assertions.assertThat(lottoRound.checkLottoRank(new LottoNumbers("7,8,9,10,11,12")))
                .isEqualTo(LottoRank.ETC);
    }

    @DisplayName("로또 리스트 등수 확인")
    @Test
    public void lottoRanks() throws Exception {
        LottoRound lottoRound = new LottoRound(Set.of(1, 2, 4, 3, 5, 6), 7);

        LottoNumbers first = new LottoNumbers("1,2,3,4,5,6");
        LottoNumbers second = new LottoNumbers("1,2,3,4,5,7");
        LottoNumbers third = new LottoNumbers("1,2,3,4,5,8");
        LottoNumbers fourth = new LottoNumbers("1,2,3,4,8,9");
        LottoNumbers fifth = new LottoNumbers("1,2,3,7,8,9");
        LottoNumbers etc = new LottoNumbers("1,2,7,8,9,10");

        LottoResult lottoResult = lottoRound.checkLottoRank(List.of(first, first, second, second, second, third, fourth, fifth, fifth, etc, etc));
        Assertions.assertThat(lottoResult.lottoResult(LottoRank.FIRST))
                .isEqualTo(2);

        Assertions.assertThat(lottoResult.lottoResult(LottoRank.SECOND))
                .isEqualTo(3);

        Assertions.assertThat(lottoResult.lottoResult(LottoRank.THIRD))
                .isEqualTo(1);

        Assertions.assertThat(lottoResult.lottoResult(LottoRank.FOURTH))
                .isEqualTo(1);

        Assertions.assertThat(lottoResult.lottoResult(LottoRank.FIFTH))
                .isEqualTo(2);

        Assertions.assertThat(lottoResult.lottoResult(LottoRank.ETC))
                .isEqualTo(2);
    }
}