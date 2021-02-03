package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnerLottoTest {
    WinnerLotto winnerLotto;
    List<LottoNumber> expectedLottoNumbers;
    LottoNumber lottoBonusNumber;
    int [] lottoNumbers = {1,2,3,4,5,6};

    @BeforeEach
    void init() {
        expectedLottoNumbers = LottoFactory.createListOfLottoNumber(lottoNumbers);
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



    @DisplayName("bonusball cannot be same with lotto number")
    @Test
    void checkLottoContainsBonusball () {

        assertThatThrownBy(() -> {
            LottoNumber bonusBall = LottoNumber.of(1);

            WinnerLotto winnerLotto = new WinnerLotto(bonusBall, LottoFactory.createListOfLottoNumber(lottoNumbers));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}