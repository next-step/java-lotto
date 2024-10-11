package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @ParameterizedTest
    @NullSource
    @EmptySource
    void createLotto_inputValidation(List<Integer> testNumbers) {
        assertThatThrownBy(() -> getLotto(testNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createLotto_inputValidation_length() {
        assertThatThrownBy(() -> getLotto(Arrays.asList(1,2,3,4,5))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createLotto_inputValidation_duplication() {
        assertThatThrownBy(() -> getLotto(Arrays.asList(1,2,3,4,5,5))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createLotto_inputValidation_range() {
        assertThatThrownBy(() -> getLotto(Arrays.asList(1,2,3,4,5,50))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create_normal_firstPrize() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto newLotto  = getLotto(winningNumbers);
        assertThat(newLotto.getRanking(winningNumbers)).isEqualTo(LottoRankingEnum.FIRST_PRIZE);
    }
    @Test
    void create_normal_losLot() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto newLotto = getLotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        assertThat(newLotto.getRanking(winningNumbers)).isEqualTo(LottoRankingEnum.LOSING_LOT);
    }
    private Lotto getLotto(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }
}
