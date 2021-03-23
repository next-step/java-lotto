package step1.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @DisplayName("Numbers 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        List<Number> inputData = new ArrayList<Number>();

        // when
        Numbers numbers = new Numbers(inputData);

        // then
        assertThat(numbers).isNotNull();

    }
}