package edu.nextstep.camp.lotto.domain;

import edu.nextstep.camp.testUtils.TestUtils;
import org.junit.jupiter.api.Test;

import static edu.nextstep.camp.lotto.domain.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottosTest {

    @Test
    void 로또_발급_및_toString_테스트(){
        TestUtils.systemSetIn("1,2,3,4,5,6\n2,3,4,5,6,7");
        LottoFactory lottoFactory = new CustomLottoFactory();
        LottoGame lottoGame = new LottoGame(lottoFactory);

        Lottos lottos = lottoGame.buyLotto(2000);

        assertThat(lottos.toString()).contains("[1, 2, 3, 4, 5, 6]\n[2, 3, 4, 5, 6, 7]");
    }


    @Test
    void 로또_분석_테스트() {
        TestUtils.systemSetIn("1,2,3,4,5,6\n2,3,4,5,6,7");
        LottoFactory lottoFactory = new CustomLottoFactory();
        LottoGame lottoGame = new LottoGame(lottoFactory);

        Lottos lottos = lottoGame.buyLotto(2000);
        Lotto beforeLotto = new Lotto(3, 4, 5, 6, 7, 9);

        LottoAnalysisResult result = lottos.analysis(beforeLotto);

        assertAll(
                () -> assertThat(result.countByLottoRank(FOURTH)).isEqualTo(0),
                () -> assertThat(result.countByLottoRank(THIRD)).isEqualTo(1),
                () -> assertThat(result.countByLottoRank(SECOND)).isEqualTo(1),
                () -> assertThat(result.countByLottoRank(FIRST)).isEqualTo(0),
                () -> assertThat(result.earningRate()).isEqualTo("775.00")
        );
    }
}
