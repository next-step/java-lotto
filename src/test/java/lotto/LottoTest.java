package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private LottoPaper lottoPaper;
    private List<Integer> numbers;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        numbers = new ArrayList<>();
        lotto = new Lotto();
        lottoPaper = new LottoPaper();

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

    @Test
    void createLottoPaperTest() {
        for (int i = 0; i < 5; i++) {
            Lotto lotto = new Lotto();
            lotto.selectLottoNumber();
            lottoPaper.applyLotto(lotto);
        }

        for (Lotto paper : lottoPaper.getLottoPapers()) {
            System.out.println(paper.getLottoNumber().toString());
        }
    }

    @Test
    void checkLottoGrade() {
        int[] winNumber = new int[] {1,2,3,4,5,6};
        for (int i = 0; i < 5; i++) {
            Lotto lotto = new Lotto();
            lotto.selectLottoNumber();
            lottoPaper.applyLotto(lotto);
        }

        lottoPaper.checkLottoGrade(winNumber);

        for (Lotto paper : lottoPaper.getLottoPapers()) {
            System.out.println(paper.getLottoNumber().toString());
            System.out.println("hit:" + paper.getHitCount());
        }

    }
}
