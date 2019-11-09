package lotto;

import lotto.domain.BonusNumberStrategy;
import lotto.domain.LottoRank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @Test
    void findRankTest() {
        BonusNumberStrategy notMatchBonusNumber = rank -> false ? LottoRank.SECOND : LottoRank.THIRD;
        assertThat(LottoRank.find(6, notMatchBonusNumber)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.find(5, notMatchBonusNumber)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.find(4, notMatchBonusNumber)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.find(3, notMatchBonusNumber)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.find(2, notMatchBonusNumber)).isEqualTo(LottoRank.NOT_MATCH);
        assertThat(LottoRank.find(1, notMatchBonusNumber)).isEqualTo(LottoRank.NOT_MATCH);
        assertThat(LottoRank.find(0, notMatchBonusNumber)).isEqualTo(LottoRank.NOT_MATCH);

        BonusNumberStrategy matchBonusNumber = rank -> true ? LottoRank.SECOND : LottoRank.THIRD;
        assertThat(LottoRank.find(6, matchBonusNumber)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.find(5, matchBonusNumber)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.find(4, matchBonusNumber)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.find(3, matchBonusNumber)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.find(2, matchBonusNumber)).isEqualTo(LottoRank.NOT_MATCH);
        assertThat(LottoRank.find(1, matchBonusNumber)).isEqualTo(LottoRank.NOT_MATCH);
        assertThat(LottoRank.find(0, matchBonusNumber)).isEqualTo(LottoRank.NOT_MATCH);
    }
}
