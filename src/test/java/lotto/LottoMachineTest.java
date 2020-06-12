package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    private LottoMachine lottoMachine;
    private List<Lotto> lottoList = new ArrayList<Lotto>();
    private LottoNumbers randomLottoNumber = new RandomLottoNumbers();

    private static final List<Integer> totalNumberList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10
            , 11, 12, 13, 14, 15, 16, 17, 18, 19
            , 20, 21, 22, 23, 24, 25, 26, 27, 28, 29
            , 30, 31, 32, 33, 34, 35, 36, 37, 38, 39
            , 40, 41, 42, 43, 44, 45));

    @BeforeEach
    void setUp() {
        int money = 3000;
        int manualCount = 1;
        lottoMachine = new LottoMachine(money, manualCount);
    }

    @Test
    void lottoMachineInitTest() {
        assertThat(lottoMachine.getClass().getSimpleName()).isEqualTo("LottoMachine");
    }

    @Test
    void RandomLottoNumberSizeTest() {
        int EXPECTED_LIST_SIZE = 6;
        assertThat(randomLottoNumber.generateNumbers().size()).isEqualTo(EXPECTED_LIST_SIZE);
    }

    @Test
    void RandomLottoNumberTest() {
        assertThat(randomLottoNumber.generateNumbers().stream().mapToInt(value -> value.getNumber())).isSubsetOf(totalNumberList);
    }
}
