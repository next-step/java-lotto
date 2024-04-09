package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TotalTryTest {

    @Test
    void 전체시도횟수() {
        TotalTry totalTry = new TotalTry(10);
        assertThat(totalTry.getTotalTry()).isEqualTo(10);
        totalTry.minus(3);
        assertThat(totalTry.getTotalTry()).isEqualTo(7);
    }
}