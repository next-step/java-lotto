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
        assertThat(lotto).isEqualTo(new Lotto(8));
        assertThat(lotto.getNumber()).isEqualTo(8);
        lotto.selectLottoNumber();
        assertThat(lotto.getNumber()).isEqualTo(8);
    }

    @Test
    void createLottoPaperCollectionTest() {
        for (int i = 0; i < 6; i++) {
            Lotto lotto = new Lotto();
            lotto.selectLottoNumber();
            numbers.add(lotto.getNumber());
        }
        assertThat(numbers).hasSize(6);
        System.out.println(numbers.toString());
    }

    @Test
    void createLottoPaperClassTest() {
        for (int i = 0; i < 6; i++) {
            Lotto lotto = new Lotto();
            lotto.selectLottoNumber();
            lottoPaper.applyNumber(lotto.getNumber());
        }
        assertThat(lottoPaper.getNumbers()).hasSize(6);
        System.out.println(lottoPaper.getNumbers());
    }

    @Test
    void duplicateNumberTest() {
        lottoPaper.applyNumber(5);
        lottoPaper.applyNumber(5);
        assertThat(lottoPaper.getNumbers()).hasSize(1);
    }
}
