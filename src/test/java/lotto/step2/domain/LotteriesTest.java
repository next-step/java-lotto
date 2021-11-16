package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteriesTest {

    @Test
    @DisplayName("주어진 orderCount 수만큼 로또가 생성되어 컬렉션에 담긴다")
    void createLotteries() {
        Lotteries lotteries = new Lotteries(10);
        assertThat(lotteries.getLotteries()).size().isEqualTo(10);
    }

}