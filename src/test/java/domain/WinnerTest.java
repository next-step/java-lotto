package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinnerTest {
    @Test
    void create() {
        //given
        LottoNumbers lottoNumbers = TestObjectSupport.createLottoNumbers();
        BonusNumber bonusNumber = TestObjectSupport.createBonusNumber();

        //when
        Winner result = new Winner(lottoNumbers, bonusNumber);

        //then
        assertThat(result).isEqualTo(new Winner(lottoNumbers, bonusNumber));
    }

    @Test
    void duplicateBonus() {
        //given
        LottoNumbers winnerNumbers = TestObjectSupport.createLottoNumbers();
        BonusNumber bonusNumber = new BonusNumber(1);

        //then
        assertThatThrownBy(() -> new Winner(winnerNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 볼은 로또 번호와 중복될 수 없습니다.");
    }

    @Test
    void match() {
        //given
        Winner winner = new Winner(TestObjectSupport.createLottoNumbers(), TestObjectSupport.createBonusNumber());
        Lotto lotto1 = TestObjectSupport.createLotto();
        Lotto lotto2 = TestObjectSupport.createSecondRankLotto();

        //when
        Rank result1 = winner.match(lotto1);
        Rank result2 = winner.match(lotto2);

        //then
        assertThat(result1).isEqualTo(Rank.FIRST);
        assertThat(result2).isEqualTo(Rank.SECOND);
    }
}
