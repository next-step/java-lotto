package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoRankTest {

    @Test
    public void findMatchCountTest() {
        assertThat(LottoRank.findMatchCount(3)).isEqualTo(LottoRank.THREE);
    }
}