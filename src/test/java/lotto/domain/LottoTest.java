package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
}
