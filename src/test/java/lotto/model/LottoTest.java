package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {
    @DisplayName(value = "당첨로또번호 갯수 구하기")
    @Test
    void count_winning_numbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(LottoNumber.of(1));
        lottoNumbers.add(LottoNumber.of(2));
        lottoNumbers.add(LottoNumber.of(3));
        lottoNumbers.add(LottoNumber.of(4));
        lottoNumbers.add(LottoNumber.of(5));
        lottoNumbers.add(LottoNumber.of(6));

        List<LottoNumber> winningNumbers = new ArrayList<>();
        winningNumbers.add(LottoNumber.of(2));
        winningNumbers.add(LottoNumber.of(4));
        winningNumbers.add(LottoNumber.of(6));
        winningNumbers.add(LottoNumber.of(8));
        winningNumbers.add(LottoNumber.of(10));
        winningNumbers.add(LottoNumber.of(12));

        Lotto lotto = new Lotto(lottoNumbers);
        Lotto winningLotto = new Lotto(winningNumbers);

        assertThat(lotto.countWinningNumbers(winningLotto)).isEqualTo(3);
    }
}
