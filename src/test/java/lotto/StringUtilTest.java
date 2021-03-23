package lotto;

import lotto.util.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringUtilTest {

    @DisplayName("하이픈 문자와 5개의 출력해야할 숫자를 입력받아 하이픈 5개의 문자열을 반환한다.")
    @Test
    public void split() {
        String numbers = "1,2,3,4,5,6";

        String[] actual = StringUtil.split(",", numbers);

        assertThat(actual).containsExactly("1", "2", "3", "4", "5", "6");
    }
}
