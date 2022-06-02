package domain;

import org.junit.jupiter.api.Test;

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
        Winner winner = new Winner(TestObjectSupport.createLottoNumbers(), null);
        Lotto lotto = TestObjectSupport.createLotto();

        //when
        Rank result = winner.match(lotto);

        //then
        assertThat(result).isEqualTo(Rank.FIRST);
    }
}
