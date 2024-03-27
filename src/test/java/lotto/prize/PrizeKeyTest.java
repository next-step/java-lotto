package lotto.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeKeyTest {

    @Test
    @DisplayName("correctNumber와 isBonus가 일치하다면 해당 객체는 같다.")
    void equals(){
        PrizeKey prizeKey = new PrizeKey(1, false);
        PrizeKey prizeKey1 = new PrizeKey(1, false);
        assertThat(prizeKey).isEqualTo(prizeKey1);
    }
    @Test
    @DisplayName("of 메서드는 같은 correctNumber와 isBonus에 캐시객체를 반환한다.")
    void equalsOf() {
        PrizeKey prizeKey = PrizeKey.of(1, false);
        PrizeKey prizeKey1 = PrizeKey.of(1, false);
        assertThat(prizeKey).isEqualTo(prizeKey1);
    }

}