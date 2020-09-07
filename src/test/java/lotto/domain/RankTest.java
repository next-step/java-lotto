package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("Rank 생성 테스트")
    @Test
    public void Rank생성테스트() {
        assertThat(Rank.FirstPlace).isInstanceOf(Rank.class);
    }


    @DisplayName("Rank 생성테스트 당첨갯수")
    @Test
    public void Rank생성테스트_당첨갯수() {
        assertThat(Rank.create(1)).isEqualTo(Rank.SixthPlace);
    }


    @DisplayName("1 Rank 당첨금 테스트")
    @Test
    public void Rank1_당첨금테스트() {
        assertThat(Rank.create(6).getMatchCount()).isEqualTo(6);
    }

    @DisplayName("2 Rank 당첨 갯수")
    @Test
    public void Rank2_당첨갯수_테스트() {
        assertThat(Rank.create(5).getWinnings()).isEqualTo(1500000);
    }

}
