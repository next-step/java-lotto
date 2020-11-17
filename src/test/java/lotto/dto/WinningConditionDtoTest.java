package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoNoPool;
import lotto.domain.WinningCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningConditionDtoTest {

    @Test
    @DisplayName("WinningLotto 가 정상적으로 빌드 되는지 확인")
    void toEntity() {
        List<Integer> lotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        WinningCondition condition = new WinningConditionDto.Builder()
                .winningLotto(lotto)
                .bonus(bonus)
                .build()
                .toEntity();
        assertThat(condition)
                .isEqualTo(new WinningCondition(new Lotto(lotto), LottoNoPool.getLottoNo(bonus)));
    }
}
