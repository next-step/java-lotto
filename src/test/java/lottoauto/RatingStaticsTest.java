package lottoauto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RatingStaticsTest {
    private Lottos lottos;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        List<String> numberInputs = new ArrayList<>();
        numberInputs.add("8, 21, 23, 41, 42, 43");
        numberInputs.add("3, 5, 11, 16, 32, 38");
        numberInputs.add("7, 11, 16, 35, 36, 44");
        numberInputs.add("1, 8, 11, 31, 41, 42");
        numberInputs.add("13, 14, 16, 38, 42, 45");
        numberInputs.add("7, 11, 30, 40, 42, 43");
        numberInputs.add("2, 13, 22, 32, 38, 45");
        numberInputs.add("23, 25, 33, 36, 39, 41");
        numberInputs.add("1, 3, 5, 14, 22, 45");
        numberInputs.add("5, 9, 38, 41, 43, 44");
        numberInputs.add("2, 8, 9, 18, 19, 21");
        numberInputs.add("13, 14, 18, 21, 23, 35");
        numberInputs.add("17, 21, 29, 37, 42, 45");
        numberInputs.add("3, 8, 27, 30, 35, 44");

        List<Lotto> lottoList = numberInputs.stream().map(Lotto::from).collect(Collectors.toList());
        lottos = Lottos.from(lottoList);

        winningLotto = WinningLotto.from(Lotto.from("1, 2, 3, 4, 5, 6"));
    }

    @Test
    void 수익률_확인() {
        System.out.println(lottos.totalPrice());
        assertThat(lottos.findRatingStatics(winningLotto).rateOfReturn(lottos.totalPrice())).isEqualTo("0.35");
    }

}