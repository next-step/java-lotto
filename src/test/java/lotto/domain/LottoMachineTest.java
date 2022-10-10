package lotto.domain;

import lotto.strategy.NumberGenerateStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    LottoMachine lottoMachine;

    @BeforeEach
    void init() {
        lottoMachine = new LottoMachine();
    }

    @Test
    @DisplayName("로또 생성 테스트")
    void create_lotto_test() {

        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        NumberGenerateStrategy numberGenerateStrategy = () -> lottoNumbers;

        Lotto lotto = lottoMachine.createLotto(numberGenerateStrategy);

        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("금액 입력 후 로또 구매량 계산")
    void check_lotto_count_after_buying() {
        int money = 10000;
        assertThat(lottoMachine.lottoTryCount(money)).isEqualTo(10);
    }


}





