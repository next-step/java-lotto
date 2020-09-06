package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    void valueOfTest(){
        assertThat(Rank.valueOf(4,false).getWinnerPrice())
                .isEqualTo(50000);
    }

    @Test
    void valueOfTest2(){
        assertThat(Rank.valueOf(5,true).getWinnerPrice())
                .isEqualTo(30_000_000);
    }

}
