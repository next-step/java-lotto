package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @Test
    public void checkRank() {

        Assertions.assertThat(LottoRank.valueOf("FIRST")).isEqualTo(LottoRank.FIRST);
        Assertions.assertThat(LottoRank.valueOf("SECOND")).isEqualTo(LottoRank.SECOND);
        Assertions.assertThat(LottoRank.valueOf("THIRD")).isEqualTo(LottoRank.THIRD);

    }

}