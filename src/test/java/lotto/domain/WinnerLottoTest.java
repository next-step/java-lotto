package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinnerLottoTest {

    WinnerLotto winnerLotto;
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
        winnerLotto = new WinnerLotto(lottoBonusNumber,expectedLottoNumbers);
    }

    @DisplayName("get List of LottoNumber test")
    @Test
    void getNumbers() {
        assertThat(winnerLotto.getNumbers()).isEqualTo(expectedLottoNumbers);
    }

    @DisplayName("getBonusBall test")
    @Test
    void getBonusBall() {
        assertThat(winnerLotto.getBonusBall()).isEqualTo(lottoBonusNumber);
    }

    @DisplayName("comma with space parsing test")
    @Test
    void getWinnerLottoWithSplitting() {
        String input = "1, 2, 3, 4, 5, 6";
        assertThat(winnerLotto.getWinnerLottoWithSplitting(input)).isEqualTo(expectedLottoNumbers);
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
            winnerLotto = new WinnerLotto(lottoBonusNumber,expectedLottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("string input have duplicated number case")
    @Test
    void duplicatedLottoNumber() {
        Assertions.assertThatThrownBy(() -> {
            LottoNumber bonus = new LottoNumber(6);
            List<LottoNumber> lotto = winnerLotto.getWinnerLottoWithSplitting("1, 1, 2, 3, 4, 5");
            WinnerLotto winnerLotto = new WinnerLotto(bonus,lotto);
        }).isInstanceOf(IllegalArgumentException.class);

    }
}