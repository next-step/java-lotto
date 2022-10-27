package step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static step4.domain.Prize.*;

class PrizeTest {

    @ParameterizedTest
    @CsvSource(value = {"6,false,SIX_PRIZE", "5,true,FIVE_BONUS_PRIZE","4,false,FOUR_PRIZE", "5,false,FIVE_PRIZE","3,false,THREE_PRIZE","2,false,NONE"})
    void 등수_확인(int count, Boolean isBonus, Prize expected) {
        Assertions.assertThat(getPrize(count,isBonus)).isEqualTo(expected);
    }
}