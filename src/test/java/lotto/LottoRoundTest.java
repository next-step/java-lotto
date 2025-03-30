package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class LottoRoundTest {
    @DisplayName("로또 등수 확인")
    @Test
    public void lottoRank() throws Exception {
        LottoRound lottoRound = new LottoRound(Set.of(1, 2, 4, 3, 5, 6));
        Assertions.assertThat(lottoRound.checkLottoRank(new LottoNumbers(Set.of(1,2,3,4,5,6))))
                .isEqualTo(LottoRank.FIRST);

        Assertions.assertThat(lottoRound.checkLottoRank(new LottoNumbers(Set.of(1,2,3,4,5,7))))
                .isEqualTo(LottoRank.SECOND);

        Assertions.assertThat(lottoRound.checkLottoRank(new LottoNumbers(Set.of(1,2,3,4,7,8))))
                .isEqualTo(LottoRank.THIRD);

        Assertions.assertThat(lottoRound.checkLottoRank(new LottoNumbers(Set.of(1,2,3,7,8,9))))
                .isEqualTo(LottoRank.FOURTH);

        Assertions.assertThat(lottoRound.checkLottoRank(new LottoNumbers(Set.of(1,2,7,8,9,10))))
                .isEqualTo(LottoRank.ETC);

        Assertions.assertThat(lottoRound.checkLottoRank(new LottoNumbers(Set.of(1,7,8,9,10,11))))
                .isEqualTo(LottoRank.ETC);

        Assertions.assertThat(lottoRound.checkLottoRank(new LottoNumbers(Set.of(7,8,9,10,11,12))))
                .isEqualTo(LottoRank.ETC);
    }

    @DisplayName("로또 리스트 등수 확인")
    @Test
    public void lottoRanks() throws Exception {
        LottoRound lottoRound = new LottoRound(Set.of(1, 2, 4, 3, 5, 6));

        LottoNumbers first = new LottoNumbers(Set.of(1, 2, 3, 4, 5, 6));
        LottoNumbers second = new LottoNumbers(Set.of(1, 2, 3, 4, 5, 7));
        LottoNumbers third = new LottoNumbers(Set.of(1, 2, 3, 4, 7, 8));
        LottoNumbers fourth = new LottoNumbers(Set.of(1, 2, 3, 7, 8, 9));
        LottoNumbers etc = new LottoNumbers(Set.of(1, 2, 7, 8, 9, 10));

        Assertions.assertThat(lottoRound.checkLottoRank(List.of(first, first, second, second, second, third, fourth, etc, etc)))
                .containsEntry(LottoRank.FIRST, 2)
                .containsEntry(LottoRank.SECOND, 3)
                .containsEntry(LottoRank.THIRD, 1)
                .containsEntry(LottoRank.FOURTH, 1)
                .containsEntry(LottoRank.ETC, 2);
    }
}