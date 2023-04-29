package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    @Test
    @DisplayName("주어진 문자열을 split하여 lotto객체 생성")
    public void lottoGeneratorTest() {
        Lotto lotto = new Lotto("1, 2, 3, 41, 42, 43");
        List<Integer> list = Arrays.asList(1, 2, 3, 41, 42, 43);
        assertThat(lotto.equals(list)).isTrue();
    }
}
