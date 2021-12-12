package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumberGroupTest {

    @Test
    @DisplayName("동일한 리스트로 NumberGroup이 생성시 같은 값인지 확인합니다.")
    void equals() {
        //given
        Integer[] numbers = {1,2,3,4,5,6};
        List<Number> numberList = Arrays.stream(numbers)
                .map(n -> new Number(n,new Position(n-1)))
                .collect(Collectors.toList());

        NumberGroup numberGroup = new NumberGroup(numberList);

        //when
        boolean result = numberGroup.equals(new NumberGroup(numberList));

        //then
        assertThat(result).isTrue();
    }
}