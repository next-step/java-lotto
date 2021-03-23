package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoListTest {
    private static int LOTTO_LIST_SIZE = 10;
    private static int LOTTO_SIZE = 6;
    private static int LOTTO_BOUND = 45;

    private Lottos lottos;
    private List<Lotto> lottoList = new ArrayList<>();


    @BeforeEach
    void setUp() {
        Random random = new Random();
        for (int i = 0; i < LOTTO_LIST_SIZE; i++) {
            List<Integer> numbers = new ArrayList<>();
            for (int j = 0; j < LOTTO_SIZE; j++) {
                numbers.add(1 + random.nextInt(LOTTO_BOUND));
            }
            lottoList.add(new Lotto(numbers));
        }

        lottos = new Lottos(lottoList);
    }

    @Test
    void createTest() {
        assertThat(lottos).isEqualTo(new Lottos(lottoList));
    }

    @Test
    void toStringTest() {
        System.out.println(lottos.toString());
    }
}
