package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private List<Integer> lottoPaper;
    private Lotto lotto;
    @BeforeEach
    void setUp() {
        lottoPaper = new ArrayList<>();
        lotto = new Lotto(8);

    }

    @Test
    void collectionTest() {
        int random = new Random().nextInt(44);
        lottoPaper.add(random);
        Collections.shuffle(lottoPaper);
        System.out.println(lottoPaper.get(0));
    }

    @Test
    void lottoTest() {
        assertThat(lotto).isEqualTo(new Lotto(8));
        assertThat(lotto.getNumber()).isEqualTo(8);
        lotto.selectLottoNumber();
        assertThat(lotto.getNumber()).isEqualTo(8);
    }
}
