package lotto.model;

import lotto.enums.Grade;
import lotto.exception.BonusContainWinningResultException;
import lotto.exception.LottoLengthException;
import lotto.util.AwardNumberUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {

    @Test
    void getAwadNumberList() {
        assertThat(AwardNumberUtil.getAwardNumberList("1, 2, 4, 6")).contains(1, 2, 4, 6);
    }

    @Test
    @DisplayName("당첨 번호가 몇개 일치 하는지 확인")
    void awardCount() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.matchCount(Set.of(1, 2, 3, 9, 10, 20), 6))
                .isEqualTo(Grade.FIFTH);
    }

    @Test
    @DisplayName("보너스 번호는 당첨번호에 포함될 수 없습니다.")
    void bonusContains() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        assertThrows(BonusContainWinningResultException.class, () -> {
            lotto.matchCount(Set.of(1, 2, 3, 9, 10, 20), 10);
        });
    }

    @Test
    @DisplayName("당첨 번호와 상품으로 만들어진 로또의 번호가 일치하는지 확인한다.")
    void winningProduct() {
        Lotto lotto = Lotto.from(Set.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isEqualTo(new Lotto(Set.of(
                1, 2, 3, 4, 5, 6)));
    }


    @Test
    @DisplayName("로또 사이즈는 6자리입니다.")
    void lottoSizeException() {
        assertThrows(LottoLengthException.class, () -> {
            List<Integer> lottoNumbers = List.of(7, 8, 8, 9, 5, 6);
            new Lotto(new HashSet<>(lottoNumbers));
            new Lotto(
                    Set.of(7, 8, 9, 5, 6, 10, 17));

        });
    }

}