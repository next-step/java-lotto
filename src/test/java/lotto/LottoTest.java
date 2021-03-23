package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private static int LOTTO_SIZE = 6;
    private Lotto lotto;
    private List<Integer> numbers;

    @BeforeEach
    void setUp() { //given
        numbers = new ArrayList<>();
        for (int i = 1; i < LOTTO_SIZE; i++) {
            numbers.add(i);
        }
        lotto = new Lotto(numbers);
    }

    @Test
    void createTest() {
        //then
        assertThat(lotto).isEqualTo(new Lotto(numbers));
    }
}
