package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValuesTest {

    private Values values;

    @Test
    @DisplayName("더하기 테스트")
    void AddCalculator() {
        String[] array = {"1","2","3"};
        values = new Values(array);
        assertThat(values.sum()).isEqualTo(6);
    }

}