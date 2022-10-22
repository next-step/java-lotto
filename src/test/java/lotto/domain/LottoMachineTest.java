package lotto.domain;

import lotto.strategy.NumberGenerateStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void create_lotto_test() {
        List<Lotto> lotto = LottoMachine.createLotto(new LottoPurchaseMethod(10000, 0));
        assertThat(lotto).hasSize(10);
    }


}

