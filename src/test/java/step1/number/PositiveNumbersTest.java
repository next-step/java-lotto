package step1.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveNumbersTest {

    @DisplayName("Numbers 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        List<PositiveNumber> inputData = new ArrayList<PositiveNumber>();

        // when
        PositiveNumbers positiveNumbers = new PositiveNumbers(inputData);

        // then
        assertThat(positiveNumbers).isNotNull();

    }

    @DisplayName("Numbers 인스턴스 생성시 Null 값 입력시 예외처리 발생 여부 테스트")
    @Test
    void 검증() {
        // given
        List<PositiveNumber> inputData = null;

        // when and then
        assertThatThrownBy(() -> {
            new PositiveNumbers(inputData);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null 값을 입력했습니다.");

    }

    @DisplayName("Numbers 인스턴스가 소유한 값을 기준으로 비교 가능한지 테스트")
    @Test
    void 비교() {
        // given
        List<PositiveNumber> inputData = Arrays.asList(new PositiveNumber(1), new PositiveNumber(2));

        // when
        PositiveNumbers firstPositiveNumbers = new PositiveNumbers(inputData);
        PositiveNumbers secondPositiveNumbers = new PositiveNumbers(inputData);

        // then
        assertThat(firstPositiveNumbers).isEqualTo(secondPositiveNumbers);
    }

    @DisplayName("Numbers 인스턴스가 소유한 값들을 합해서 반환 여부 테스트")
    @Test
    void 총합() {
        // given
        List<PositiveNumber> inputData = Arrays.asList(new PositiveNumber(1), new PositiveNumber(2));

        // when
        PositiveNumbers positiveNumbers = new PositiveNumbers(inputData);
        int actual = positiveNumbers.sum();

        // then
        assertThat(actual).isEqualTo(3);
    }

}