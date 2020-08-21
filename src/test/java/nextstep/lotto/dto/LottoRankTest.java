package nextstep.lotto.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoRankTest {

    @Test
    @DisplayName("6개일치")
    void lottoRank_6개일치(){
        LottoRank lottoRank = LottoRank.of(6);
        assertThat(lottoRank).isEqualTo(LottoRank.SIX);
    }

    @Test
    @DisplayName("5개일치")
    void lottoRank_5개일치(){
        LottoRank lottoRank = LottoRank.of(5);
        assertThat(lottoRank).isEqualTo(LottoRank.FIVE);
    }

    @Test
    @DisplayName("4개일치")
    void lottoRank_4개일치(){
        LottoRank lottoRank = LottoRank.of(4);
        assertThat(lottoRank).isEqualTo(LottoRank.FOUR);
    }

    @Test
    @DisplayName("3개일치")
    void lottoRank_3개일치(){
        LottoRank lottoRank = LottoRank.of(3);
        assertThat(lottoRank).isEqualTo(LottoRank.THREE);
    }

    @Test
    @DisplayName("2개일치")
    void lottoRank_2개일치(){
        LottoRank lottoRank = LottoRank.of(2);
        assertThat(lottoRank).isEqualTo(LottoRank.ETC);
    }

    @Test
    @DisplayName("1개일치")
    void lottoRank_1개일치(){
        LottoRank lottoRank = LottoRank.of(1);
        assertThat(lottoRank).isEqualTo(LottoRank.ETC);
    }

    @Test
    @DisplayName("0개일치")
    void lottoRank_0개일치(){
        LottoRank lottoRank = LottoRank.of(0);
        assertThat(lottoRank).isEqualTo(LottoRank.ETC);
    }

}