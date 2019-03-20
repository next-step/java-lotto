package lotto.domain.lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicLottoTest {

    private List<Integer> numbers;

    @Before
    public void setUp() throws Exception {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void 임의의_로또_생성() {
        Lotto lotto = new BasicLotto(numbers);
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
