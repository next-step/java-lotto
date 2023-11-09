package calculator.domain;

import calculator.domain.NumberList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NumberListTest {

    @Test
    @DisplayName("배열을 받아 홀수만 숫자 리스트로 추출 확인")
    void 숫자_일급컬렉션_생성_확인() {
        String[] textArray = {"2", "+", "10", "/", "3", "+", "6", "/", "3"};
        List<Integer> result = List.of(2, 10, 3, 6, 3);
        NumberList numberList = new NumberList(textArray);

        Assertions.assertThat(numberList.getNumberList()).isEqualTo(result);

    }
}
