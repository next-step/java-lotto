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
        LottoMachine lottoMachine = new LottoMachine(new LottoGenerator(numbers -> given(), possibleNumbers()));

        // when
        Lottos result = lottoMachine.createLottos(6);

        // then
        assertThat(result).isEqualTo(createExpectedLottos());
    }

    private List<LottoNumber> given() {
        return List.of(
                LottoNumber.valueOf(1),
                LottoNumber.valueOf(21),
                LottoNumber.valueOf(26),
                LottoNumber.valueOf(31),
                LottoNumber.valueOf(40),
                LottoNumber.valueOf(42)
        );
    }

    private List<LottoNumber> possibleNumbers() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            LottoNumber.valueOf(i);
        }
        return numbers;
    }

    private Lottos createExpectedLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottos.add(new Lotto(1, 21, 26, 31, 40, 42));
        }
        return new Lottos(lottos);
    }
}
