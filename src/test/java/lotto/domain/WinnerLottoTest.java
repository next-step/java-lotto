package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnerLottoTest {
    WinnerLotto winnerLotto;
    List<LottoNumber> expectedLottoNumbers;
    LottoNumber lottoBonusNumber;
    List<Integer> lottoNumbers;

    @BeforeEach
    void init() {
        lottoNumbers = Arrays.asList(1,2,3,4,5,6);
        expectedLottoNumbers = lottoNumbers.stream().map(LottoNumber::of).collect(Collectors.toList());
        lottoBonusNumber = LottoNumber.of(7);
        winnerLotto = WinnerLotto.of(lottoBonusNumber,LottoFactory.createLotto(lottoNumbers));
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



    @DisplayName("bonus ball cannot be same with lotto number")
    @Test
    void checkLottoContainsBonusball () {

        assertThatThrownBy(() -> {
            LottoNumber bonusBall = LottoNumber.of(1);

            WinnerLotto winnerLotto = WinnerLotto.of(bonusBall, LottoFactory.createLotto(lottoNumbers));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}