package lotto.domain.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {

    @DisplayName("일치하는 숫자 개수와 보너스 볼 일치 여부를 받아 해당하는 로또 등수를 반환한다." +
            "(보너스 볼 일치 여부는 true, false 둘다 넘어올 수 있으므로 2등 외 다른 테스트 케이스에서도 true를 넘기는 테스트 하나 추가)")
    @ParameterizedTest
    @CsvSource({
            "6,false,FIRST",
            "5,true,SECOND",
            "5,false,THIRD",
            "4,false,FOURTH",
            "3,false,FIFTH",
            "3,true,FIFTH",
            "2,false,NOTHING",
            "1,false,NOTHING",
    })
    void 일치개수별_로또등수_정상_반환(int match, boolean hasBonus, LottoPrize lottoPrize) {
        assertThat(LottoPrize.from(match, hasBonus)).isEqualTo(lottoPrize);
    }

    @Test
    void 등수별_로또상금_정상_계산() {
        Arrays.stream(LottoPrize.values()).forEach(lottoPrize -> {
            int quantity = new Random().nextInt(10) + 1;
            assertThat(lottoPrize.prize(quantity)).isEqualTo(lottoPrize.getPrize() * quantity);
        });
    }
}
