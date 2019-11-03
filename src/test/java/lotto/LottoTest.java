package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private LottoPaper lottoPaper;
    private List<Integer> numbers;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        numbers = new ArrayList<>();
        lotto = new Lotto();
        lottoPaper = new LottoPaper(numbers);

    }

    @Test
    void collectTest() {
        int random = new Random().nextInt(44);
        numbers.add(random);
        Collections.shuffle(numbers);
        System.out.println(numbers.get(0));
    }

    @Test
    void lottoTest() {
        lotto.selectLottoNumber();
        assertThat(lotto.getLottoNumber()).hasSize(6);
        System.out.println(lotto.getLottoNumber().toString());
    }


}
