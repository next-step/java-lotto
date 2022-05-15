package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    @Test
    void create() {
        //given
        LottoNumbers lottoNumbers = TestObjectSupport.createLottoNumbers();

        //when
        Winner result = new Winner(lottoNumbers);

        //then
        assertThat(result).isEqualTo(new Winner(lottoNumbers));
    }

    @Test
    void match() {
        //given
        Winner winner = new Winner(TestObjectSupport.createLottoNumbers());
        Lotto lotto = TestObjectSupport.createLotto();

        //when
        Rank result = winner.match(lotto);

        //then
        assertThat(result).isEqualTo(Rank.FIRST);
    }
}
