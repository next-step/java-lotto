package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrizeTest {

    private Prize prize;

    @BeforeEach
    void setUp(){
        prize = Prize.FIRST;
    }

    @DisplayName("1등 당첨 숫자 갯수와 유저가 구매한 번호의 당첨 숫자 갯수 일치 테스트")
    @Test
    void isSameMatchCountWithEqual() {
        boolean sameMatchCount = prize.isSameMatchCount(6);
        assertThat(sameMatchCount).isEqualTo(true);
    }

    @DisplayName("1등 당첨 숫자 갯수와 유저가 구매한 번호의 당첨 숫자 갯수 일치 테스트")
    @Test
    void isSameMatchCountWithDiff() {
        boolean sameMatchCount = prize.isSameMatchCount(5);
        assertThat(sameMatchCount).isEqualTo(false);
    }

}