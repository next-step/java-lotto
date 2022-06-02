package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
