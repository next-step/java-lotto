package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("StringUtil 클래스 테스트")
class StringUtilTest {

    @DisplayName("콤마로 구분된 문자열을 입력 받아 숫자형 List를 생성할 수 있다.")
    @Test
    void splitAndToIntegerList() {
        String inputString = "1,2,3";
        List<Integer> integers = StringUtil.splitAndToIntegerList(inputString);

        assertThat(integers.get(0)).isEqualTo(1);
        assertThat(integers).hasSize(3);
    }
}
