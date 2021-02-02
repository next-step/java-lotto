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
    //TODO: getLottoWithSplitting method 는 LottoTest 가 적합해보임. 추상클래스의 메소드니까
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



    @DisplayName("bonusball cannot be same with lotto number")
    @Test
    void checkLottoContainsBonusball () {

        assertThatThrownBy(() -> {
            LottoNumber bonusBall = new LottoNumber(1);
            List<LottoNumber> lottoNumbers = new ArrayList<>(Arrays.asList(
                    new LottoNumber(1),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5),
                    new LottoNumber(6)
            ));
            WinnerLotto winnerLotto = new WinnerLotto(bonusBall, lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}