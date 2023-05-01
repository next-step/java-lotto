package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    @Test
    @DisplayName("주어진 문자열을 split하여 lotto객체 생성")
    public void lottoGeneratorTest() {
        Lotto lotto = new Lotto("1, 2, 3, 41, 42, 43");
        List<Integer> list = Arrays.asList(1, 2, 3, 41, 42, 43);
        assertThat(lotto.equals(list)).isTrue();
    }

    @Test
    @DisplayName("맞는 숫자가 몇개있는지 판별하는 메소드 테스트")
    public void checkTest() {
        Lotto lotto = new Lotto("1, 2, 3, 41, 42, 43");
        assertThat(lotto.findMatchCount("1, 2, 3, 4, 5, 6")).isEqualTo(3);
    }

    @Test
    @DisplayName("lotto객체의 사이즈 확인")
    public void lottoSizeCheck() {
        assertThatIllegalStateException().isThrownBy(() ->
                new Lotto("1, 2, 3, 41, 42")
        );
    }
}