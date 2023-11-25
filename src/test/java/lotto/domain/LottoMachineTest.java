package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    @Test
    @DisplayName("원하는 로또 갯수로 로또 뭉치를 생성한다.")
    void create_lottos() {
        // given
        long lottoCnt = 6;
        LottoMachine lottoMachine = new LottoMachine(new RandomNumbersGenerator(numbers -> List.of(1, 21, 26, 31, 40, 42), numbers()));

        // when
        Lottos result = lottoMachine.createLottos(6);

        // then
        assertThat(result).isEqualTo(createExpectedLottos());
    }

    private List<Integer> numbers() {
        List<Integer> given = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            given.add(i);
        }
        return given;
    }

    private Lottos createExpectedLottos() {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottos.add(new ArrayList<>());
        }
        for (List<Integer> lotto : lottos) {
            lotto.addAll(List.of(1, 21, 26, 31, 40, 42));
        }
        return new Lottos(lottos);
    }
}
