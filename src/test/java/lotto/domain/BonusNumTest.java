package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BonusNumTest {
    @DisplayName("보너스 번호는 로또 번호와 중복 불가.")
    @Test
    void price_lotto(){
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        BonusNum bonus = new BonusNum(6);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new WinLotto(lotto,bonus);
        });
    }

}
