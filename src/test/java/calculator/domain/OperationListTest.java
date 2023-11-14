package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OperationListTest {

    @Test
    @DisplayName("배열을 받아 짝수만 사칙연산 리스트로 추출 확인")
    void 사칙연산_일급컬렉션_생성_확인() {
        String[] textArray = {"2", "+", "10", "/", "3", "+", "6", "/", "3"};
        List<String> result = List.of("+", "/", "+", "/");
        Operations operationList = new Operations(textArray);

        Assertions.assertThat(operationList.findSign(0)).isEqualTo("+");

    }
}
