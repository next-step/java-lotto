package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {

    @Test
    void 일치갯수로_등수_생성(){
        Assertions.assertThat(Division.valueOf(3)).isEqualTo(Division.FOURTH);
        Assertions.assertThat(Division.valueOf(4)).isEqualTo(Division.THIRD);
        Assertions.assertThat(Division.valueOf(5)).isEqualTo(Division.SECOND);
        Assertions.assertThat(Division.valueOf(6)).isEqualTo(Division.FIRST);
        Assertions.assertThat(Division.valueOf(0)).isEqualTo(Division.NO_DIVISION);
    }

    @Test
    void 등수_목록_총_상금액_계산(){
        List<Division> divisions = List.of(
            Division.FOURTH,
            Division.NO_DIVISION,
            Division.NO_DIVISION,
            Division.NO_DIVISION,
            Division.NO_DIVISION,
            Division.NO_DIVISION,
            Division.NO_DIVISION,
            Division.NO_DIVISION,
            Division.NO_DIVISION,
            Division.NO_DIVISION,
            Division.NO_DIVISION,
            Division.NO_DIVISION,
            Division.NO_DIVISION,
            Division.NO_DIVISION
        );

        Assertions.assertThat(Division.sumPrize(divisions)).isEqualTo(BigDecimal.valueOf(5000));
    }

}