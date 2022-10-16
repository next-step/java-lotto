package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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

}