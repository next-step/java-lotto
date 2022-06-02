package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusNumberTest {
    @Test
    void create() {
        //given
        int bonusNumber = 7;

        //when
        BonusNumber result = new BonusNumber(bonusNumber);

        //then
        assertThat(result).isEqualTo(new BonusNumber(bonusNumber));
    }
}
