package lotto.domain.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {

    @DisplayName("일치하는 숫자 개수와 보너스 볼 일치 여부를 받아 해당하는 로또 등수를 반환한다." +
            "(보너스 볼 일치 여부는 true, false 둘다 넘어올 수 있으므로 2등 외 다른 테스트 케이스에서도 true를 넘기는 테스트 하나 추가)")
    @ParameterizedTest
    @CsvSource({
            "6,false,FIRST,2_000_000_000",
            "5,true,SECOND,30_000_000",
            "5,false,THIRD,1_500_000",
            "4,false,FOURTH,50_000",
            "3,false,FIFTH,5_000",
            "3,true,FIFTH,5_000",
            "2,false,NOTHING,0",
            "1,false,NOTHING,0",
    })
    void 일치개수별_로또등수_정상_반환(int match, boolean hasBonus, String prizeName, long prize) {
        LottoPrize lottoPrize = LottoPrize.from(match, hasBonus);

        assertThat(lottoPrize.name()).isEqualTo(prizeName);
        assertThat(lottoPrize.getPrize()).isEqualTo(prize);
    }

    @ParameterizedTest
    @CsvSource({
        "2_000_000_000,FIRST",
        "30_000_000,SECOND",
        "1_500_000,THIRD",
        "50_000,FOURTH",
        "5_000,FIFTH",
        "0,NOTHING"
    })
    void 등수별_로또상금_정상_계산(long prize, LottoPrize lottoPrize) {
        assertThat(lottoPrize.prize(2)).isEqualTo(prize * 2);
    }
}
