package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.type.Prize;
import step2.exception.NotFoundPrizeException;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class PrizeTest {

    @Test
    @DisplayName("6개 초과하여 번호를 맞출 수 없다")
    public void invalid_lotto_number() {
        assertThatExceptionOfType(NotFoundPrizeException.class)
            .isThrownBy(() -> {
                Prize.of(7);
            }).withMessageMatching("당첨 정보를 찾을 수 없습니다");
    }

    @Test
    @DisplayName("맞춘 개수에 따라 당첨 금액을 가져올 수 있다")
    public void prize_per_count() {
        assertThat(Prize.of(6)).extracting(Prize::prizeMoney).isEqualTo(BigDecimal.valueOf(2000000000));
    }

}
