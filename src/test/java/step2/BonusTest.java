package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BonusTest {
    Bonus bonus = new Bonus(45);
    LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1,2,3,4,5,45));

    @DisplayName("보너스 볼 생성")
    @Test
    void makeBounsNumberTest() {
        assertThat(bonus.getBonus()).isBetween(1, 45);
    }

    @DisplayName("보너스 볼 범위 초과 검사")
    @Test
    void makeBounsNumberRangeTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Bonus(47);
        });
    }

    @DisplayName("보너스볼 일치")
    @Test
    void matchBonusNumberTest() {
        assertThat(bonus.matchBonusNumber(lottoTicket)).isTrue();
    }
}
