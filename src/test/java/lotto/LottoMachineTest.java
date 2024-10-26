package lotto;

import lotto.lotto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {
    private LottoGeneratorStrategy lottoGeneratorStrategy;

    @BeforeEach
    void setUp() {
        lottoGeneratorStrategy = new FakeLottoStrategy();
    }

    @Test
    void 로또_생성_횟수_구하기() {
        LottoMachine lottoMachine = new LottoMachine(3000, lottoGeneratorStrategy);
        assertThat(lottoMachine.getExecuteIdx()).isEqualTo(3);
    }

    @Test
    void 로또_금액은_1000원_미만_IllegalArgumentException() {
        assertThatThrownBy(() -> {
            LottoMachine lottoMachine = new LottoMachine(500, lottoGeneratorStrategy);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또생성을 주어진 횟수만큼 생성")
    void createLottos() {
        LottoMachine lottoMachine = new LottoMachine(3000, lottoGeneratorStrategy);
        Lottos lottos = lottoMachine.createLottos();

        List<LottoNumber> lottoNumberList = new ArrayList<>();
        lottoNumberList.add(new LottoNumber(1));
        lottoNumberList.add(new LottoNumber(2));
        lottoNumberList.add(new LottoNumber(3));
        lottoNumberList.add(new LottoNumber(4));
        lottoNumberList.add(new LottoNumber(5));
        lottoNumberList.add(new LottoNumber(10));

        IntStream.range(0, lottos.getSize()).forEach(idx -> {
            Lotto lotto = lottos.get(idx);
            assertThat(lotto.findLottoNumber(idx)).isEqualTo(lottoNumberList.get(idx).getNumber());
        });

        assertThat(lottos.getSize()).isEqualTo(3);
    }
}
