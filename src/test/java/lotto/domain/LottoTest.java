package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {
    private Lotto lotto;
    private List<Integer> overRangeNumbers;

    @BeforeEach
    void setUp() {
        overRangeNumbers = new ArrayList<>();
        overRangeNumbers.add(0);
        overRangeNumbers.add(2);
        overRangeNumbers.add(3);
        overRangeNumbers.add(4);
        overRangeNumbers.add(5);
        overRangeNumbers.add(6);
        overRangeNumbers.add(46);
        lotto = new Lotto();
    }

    @Test
    void 로또번호유효성확인_6자리초과_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lotto.checkAnotherNumberLength(overRangeNumbers);
        });
    }

    @Test
    void getRank_5등확인() {
        List<Integer> numbers = new ArrayList<>();
        for (int index=0; index < LottoNumber.MAX_LOTTO_NUM_COUNT; index++) {
            numbers.add(index+1);
        }
        lotto = new Lotto(numbers);
        List<Integer> winNumbers = new ArrayList<>();
        winNumbers.add(1);
        winNumbers.add(2);
        winNumbers.add(3);
        assertThat(lotto.getRank(winNumbers)).isEqualTo(Rank.FIFTH);
    }
}
