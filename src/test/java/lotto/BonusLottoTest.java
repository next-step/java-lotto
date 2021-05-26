package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusLottoTest {

    @Test
    @DisplayName(value = "우승 로또 번호와 보너스 번호는 겹칠 수 없다")
    void notContains() {
        LottoNumber bonus = new LottoNumber(1);
        assertThrows(IllegalArgumentException.class,
            () -> new BonusLotto(Arrays.asList(1, 2, 3, 4, 5, 6), bonus));
    }

    @Test
    @DisplayName(value = "일반 로또 게임에선 5를 반환하지만, 보너스 로또 게임에서는 6을 반환한다")
    void bonusCount() {
        List<Integer> winnerLottoNumberList = Arrays.asList(3, 4, 5, 6, 7, 8);

        BonusLotto bonusLotto = new BonusLotto(winnerLottoNumberList, new LottoNumber(10));
        LottoNumbers purchased = new LottoNumbers(Arrays.asList(4, 5, 6, 7, 8, 10));
        assertThat(bonusLotto.sameCount(purchased)).isEqualTo(6);

        LottoNumbers winner = new LottoNumbers(winnerLottoNumberList);
        assertThat(winner.sameCount(purchased)).isEqualTo(5);
    }

}