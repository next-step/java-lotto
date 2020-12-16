package step3.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMatchStatusTest {

    LottoMatchStatus lottoMatchStatus;

    @BeforeEach
    void setUp() {
        lottoMatchStatus = new LottoMatchStatus();
    }

    @Test
    @DisplayName("count 증가 기능 테스트")
    void increaseCount() {
        lottoMatchStatus.increaseCount();
        lottoMatchStatus.increaseCount();
        Assertions.assertEquals(lottoMatchStatus.getCount(), 2);
    }
}