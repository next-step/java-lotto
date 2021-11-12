package lotto.step2;

import lotto.step2.domain.LotteryCompany;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryCompanyTest {

    @Test
    @DisplayName("당첨 번호 입력받아 자르기")
    void winningNumber() {
        LotteryCompany company = new LotteryCompany("1, 2, 3, 4, 5, 6");
        assertThat(company.getWinningNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("통계 테스트")
    void statics() {

    }

}