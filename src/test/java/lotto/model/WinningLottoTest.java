package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    WinningLotto winningLotto;
    Lotto oddLotto;
    Lotto evenLotto;

    @BeforeEach
    void setUp() {
        List<LottoNumber> wn = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            wn.add(LottoNumber.of(i));
        }
        Lotto winningNumbers = new Lotto(wn);
        LottoNumber bonusNumber = LottoNumber.of(7);
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        List<LottoNumber> oddLottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            oddLottoNumbers.add(LottoNumber.of(i * 2));
        }
        oddLotto = new Lotto(oddLottoNumbers);

        List<LottoNumber> evenLottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            evenLottoNumbers.add(LottoNumber.of(i + 1));
        }
        evenLotto = new Lotto(evenLottoNumbers);
    }

    @DisplayName(value = "입력받은 로또의 당첨번호 갯수 구하기")
    @Test
    void count_winning_numbers() {
        assertThat(winningLotto.countWinningNumbers(oddLotto)).isEqualTo(3);
    }

    @DisplayName(value = "입력받은 로또에 보너스번호가 존재하지 않는다.")
    @Test
    void does_not_contain_bonus_number() {
        assertThat(winningLotto.containsBonusNumber(oddLotto)).isFalse();
    }

    @DisplayName(value = "입력받은 로또에 보너스번호가 존재한다.")
    @Test
    void contains_bonus_number() {
        assertThat(winningLotto.containsBonusNumber(evenLotto)).isTrue();
    }
}
