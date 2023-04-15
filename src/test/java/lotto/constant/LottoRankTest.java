package lotto.constant;

import lotto.model.LottoTicketList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @Test
    void getRank() {
        assertThat(LottoRank.getRank(6, false)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.getRank(6, true)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.getRank(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.getRank(5, false)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.getRank(4, true)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.getRank(3, true)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.getRank(2, true)).isEqualTo(LottoRank.LOSE);
    }
}