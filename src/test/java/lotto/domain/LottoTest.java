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
    void createLotto_inputValidation(int[] testNumbers) {
        assertThatThrownBy(() -> getLotto(testNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createLotto_inputValidation_length() {
        assertThatThrownBy(() -> getLotto(new int[]{1,2,3,4,5})).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createLotto_inputValidation_duplication() {
        assertThatThrownBy(() -> getLotto(new int[]{1,2,3,4,5,5})).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createLotto_inputValidation_range() {
        assertThatThrownBy(() -> getLotto(new int[]{1,2,3,4,5,50})).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void gerRanking_firstPrize() {
        Lotto lotto = new Lotto(new LottoNumbers(new int[]{1,2,3,4,5,6}));
        assertThat(lotto.getRanking(lotto)).isEqualTo(LottoRankingEnum.FIRST_PRIZE);
    }
    @Test
    void gerRanking_losLot() {
        Lotto winningLotto = new Lotto(new LottoNumbers(new int[]{1, 2, 3, 4, 5, 6}));
        Lotto newLotto = new Lotto(new LottoNumbers(new int[]{7, 8, 9, 10, 11, 12}));
        assertThat(newLotto.getRanking(winningLotto)).isEqualTo(LottoRankingEnum.LOSING_LOT);
    }

    private Lotto getLotto(int[] numbers) {
        Lotto lotto = new Lotto(new LottoNumbers(numbers));
        return lotto;
    }
}
