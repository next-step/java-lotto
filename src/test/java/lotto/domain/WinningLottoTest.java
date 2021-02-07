package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    WinningLotto winningLotto;
    List<LottoNumber> expectedLottoNumbers;
    LottoNumber lottoBonusNumber;

    @BeforeEach
    void init() {
        expectedLottoNumbers = new ArrayList<>(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
        lottoBonusNumber = new LottoNumber(7);
        winningLotto = new WinningLotto(lottoBonusNumber,expectedLottoNumbers);
    }

    @DisplayName("get List of LottoNumber test")
    @Test
    void getNumbers() {
        assertThat(winningLotto.getNumbers()).isEqualTo(expectedLottoNumbers);
    }

    @DisplayName("getBonusBall test")
    @Test
    void getBonusBall() {
        assertThat(winningLotto.getBonusBall()).isEqualTo(lottoBonusNumber);
    }

    @DisplayName("comma with space parsing test")
    @Test
    void getWinnerLottoWithSplitting() {
        String input = "1, 2, 3, 4, 5, 6";
        assertThat(winningLotto.getWinnerLottoWithSplitting(input)).isEqualTo(expectedLottoNumbers);
    }

    @DisplayName("duplicated number lotto")
    @Test
    void duplicatedLotto() {
        Assertions.assertThatThrownBy(() -> {
            expectedLottoNumbers = new ArrayList<>(Arrays.asList(
                    new LottoNumber(1),
                    new LottoNumber(1),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5),
                    new LottoNumber(6)
            ));
            lottoBonusNumber = new LottoNumber(7);
            winningLotto = new WinningLotto(lottoBonusNumber,expectedLottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("string input have duplicated number case")
    @Test
    void duplicatedLottoNumber() {
        Assertions.assertThatThrownBy(() -> {
            LottoNumber bonus = new LottoNumber(6);
            List<LottoNumber> lotto = this.winningLotto.getWinnerLottoWithSplitting("1, 1, 2, 3, 4, 5");
            WinningLotto winningLotto = new WinningLotto(bonus,lotto);
        }).isInstanceOf(IllegalArgumentException.class);

    }
}