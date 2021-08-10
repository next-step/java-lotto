package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {
    private Lotto lotto;
    private Lotto winningLotto;

    @BeforeEach
    void setUp() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            lottoNumbers.add(LottoNumber.of(i));
        }
        lotto = new Lotto(lottoNumbers);

        List<LottoNumber> winningNumbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            winningNumbers.add(LottoNumber.of(i * 2));
        }
        winningLotto = new Lotto(winningNumbers);
    }

    @DisplayName(value = "당첨로또번호 갯수 구하기")
    @Test
    void count_winning_numbers() {
        assertThat(lotto.countWinningNumbers(winningLotto)).isEqualTo(3);
    }

    @DisplayName(value = "로또번호 포함여부 구하기")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void contains_lotto_number(final int number) {
        assertThat(lotto.contains(LottoNumber.of(number))).isTrue();
    }
}
