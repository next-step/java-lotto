package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.enums.Grade;
import lotto.exception.BonusContainWinningResultException;
import lotto.model.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

class AwardNumberUtilTest {

    @Test
    void getAwadNumberList() {
        assertThat(AwardNumberUtil.getAwardNumberList("1, 2, 4, 6")).contains(1, 2, 4, 6);
    }

    @Test
    @DisplayName("당첨 번호가 몇개 일치 하는지 확인")
    void awardCount() {
        assertThat(AwardNumberUtil.matchCount(Set.of(1, 2, 3, 4, 5, 6), Set.of(1, 2, 3, 9, 10, 20), 6))
                .isEqualTo(Grade.FIFTH);
    }
    @Test
    @DisplayName("보너스 번호는 당첨번호에 포함될 수 없습니다.")
    void bonusContains() {
        assertThrows(BonusContainWinningResultException.class, () -> {
            AwardNumberUtil.matchCount(Set.of(1, 2, 3, 4, 5, 6), Set.of(1, 2, 3, 9, 10, 20), 10);
        });
    }

}