package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    WinnerNumbers winnerNumbers;
    LottoNumbers lottoNumbers;
    Lotto lotto;

    @BeforeEach
    void setUp() {
        lottoNumbers = new LottoNumbers(Set.of(
                new LottoNumberValidate(1),
                new LottoNumberValidate(2),
                new LottoNumberValidate(3),
                new LottoNumberValidate(4),
                new LottoNumberValidate(5),
                new LottoNumberValidate(6)));
        winnerNumbers = new WinnerNumbers(lottoNumbers, new BonusBall(new LottoNumberValidate(7)));
        lotto = new Lotto(Set.of(1, 3, 5, 6, 7, 8));
    }

    @Test
    @DisplayName("보너스 숫자는 당첨번호에 카운트되지 않는다")
    void test1() throws Exception {
        int correctCount = 5;
        assertThat(lotto.matchCountAndBonus(winnerNumbers).correctCount())
                .isNotEqualTo(correctCount);
    }
}