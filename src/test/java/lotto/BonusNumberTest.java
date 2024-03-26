package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class BonusNumberTest {

    @Test
    public void bonusNumberMatchTest() {
        BonusNumber bonusNumber = new BonusNumber(2);
        boolean sut = bonusNumber.match(List.of(1, 2, 3));
        Assertions.assertTrue(sut);
    }

}