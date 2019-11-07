package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Bonus;
import step2.domain.LottoTicket;
import step2.domain.Ranks;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step2.domain.Ranks.BONUS_RANK_INDEX;

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

    @DisplayName("랭킹에 보너스 당첨 등수 추가")
    @Test
    void countOfBounsRankTest() {
        Ranks ranks = new Ranks();
        ranks.countBouns(lottoTicket, 5, bonus);

        assertThat(ranks.getOrDefault(BONUS_RANK_INDEX,0)).isEqualTo(1);
    }
}
