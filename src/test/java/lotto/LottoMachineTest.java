package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.RandomLottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    private LottoMachine lottoMachine;
    private List<Integer> numberSetList = new ArrayList<Integer>();
    private LottoNumber randomLottoNumber = new RandomLottoNumber();

    private static final List<Integer> totalNumberList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10
            , 11, 12, 13, 14, 15, 16, 17, 18, 19
            , 20, 21, 22, 23, 24, 25, 26, 27, 28, 29
            , 30, 31, 32, 33, 34, 35, 36, 37, 38, 39
            , 40, 41, 42, 43, 44, 45));

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();

        numberSetList.add(1);
        numberSetList.add(3);
        numberSetList.add(5);
        numberSetList.add(7);
        numberSetList.add(9);
    }

    @Test
    void lottoMachineInitTest() {
        assertThat(lottoMachine.getClass().getSimpleName()).isEqualTo("LottoMachine");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    void lottoGenerateTest(int number) {
        Lotto lotto = lottoMachine.generateLotto(numberSetList);
        assertThat(lotto.isContainsNumber(number)).isTrue();
    }

    @Test
    void RandomLottoNumberSizeTest() {
        int EXPECTED_LIST_SIZE = 6;
        assertThat(randomLottoNumber.generateNumber().size()).isEqualTo(6);
    }

    @Test
    void RandomLottoNumberTest() {
        assertThat(randomLottoNumber.generateNumber()).isSubsetOf(totalNumberList);
    }
}
