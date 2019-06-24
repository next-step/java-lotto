package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoVendingMachineTest {
    private LottoVendingMachine lottoVendingMachine;

    @BeforeEach
    void setUp() {
        lottoVendingMachine = new LottoVendingMachine();
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 5000, 10000})
    @DisplayName("입력한 금액으로 몇장의 로또를 구입할지 구한다.")
    void howManyLotto(int amount) {
        int result = this.lottoVendingMachine.howManyLotto(amount);
        assertThat(result).isEqualTo(amount / this.lottoVendingMachine.getUnitPrice());
    }

    @Test
    @DisplayName("여러개의 로또를 생성한다.")
    void createLottos() {
        lottoVendingMachine.createLottos(2, () -> Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoVendingMachine.getLottos()).contains(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("생성된 로또의 사이즈를 구한다.")
    void lottosSize() {
        lottoVendingMachine.createLottos(4, () -> Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoVendingMachine.size()).isEqualTo(4);
    }

    @Test
    void fullResultQuery() {
        lottoVendingMachine.createLottos(4, () -> Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> result = lottoVendingMachine.resultLottoGames(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(result).contains(6, 6, 6, 6, 6);
    }
}