package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoNumber.LOWER_LOTTONUMBER_BOUND;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private static int LOTTO_SIZE = 6;
    private Lotto lotto;
    private List<LottoNumber> numbers;

    @BeforeEach
    void setUp() { //given
        numbers = new ArrayList<>();
        for (int i = LOWER_LOTTONUMBER_BOUND; i <= LOTTO_SIZE; i++) {
            numbers.add(new LottoNumber(i));
        }
        lotto = new Lotto(numbers);
    }

    @Test
    void createTest() {
        //then
        assertThat(lotto).isEqualTo(new Lotto(numbers));
    }

    @Test
    void containsTest(){
        //given
        List<LottoNumber> testNumbers = new ArrayList<>();
        for (int i = LOWER_LOTTONUMBER_BOUND + 1; i <= LOTTO_SIZE + 1; i++) {
            testNumbers.add(new LottoNumber(i));
        }

        //when
        int allCorrect = lotto.contains(numbers);
        int fiveCorrect = lotto.contains(testNumbers);
        int zeroCorrect = lotto.contains(Collections.emptyList());

        //then
        assertThat(allCorrect).isEqualTo(LOTTO_SIZE);
        assertThat(fiveCorrect).isEqualTo(5);
        assertThat(zeroCorrect).isEqualTo(0);
    }
}
