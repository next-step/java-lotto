package lotto.domain;

import lotto.domain.game.Lotto;
import lotto.domain.game.LottoNumber;
import lotto.domain.game.Round;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created By mand2 on 2020-12-02.
 */
class LottoGeneratorTest {

    SeedMoney seedMoney;
    Round round;

    @BeforeEach
    void setUp() {
        seedMoney = SeedMoney.from(3000);
        round = Round.from(seedMoney.round() + "");
    }

    @Test
    @DisplayName("수동_로또만_산다")
    void 수동_로또만_산다() {
        // given
        List<String> inputLottos = Arrays
                .asList("1, 2, 3, 4, 5, 6",
                        "1, 2, 3, 4, 5, 7",
                        "1, 2, 3, 4, 6, -8");
        InputManualLotto inputManualLotto = InputManualLotto.of(round, inputLottos);

        // when
        Lottos lottos = LottoGenerator.generate(seedMoney, inputManualLotto);

        // then
//        assertThat(lottos.toString()).isEqualTo(inputLottos);


    }
}
