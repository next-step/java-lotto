package edu.nextstep.camp.lotto.domain;

import edu.nextstep.camp.lotto.view.InputView;
import edu.nextstep.camp.testUtils.TestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static edu.nextstep.camp.lotto.domain.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottosTest {

    private Lottos lottos;

    @BeforeEach
    void init(){
        TestUtils.systemSetIn("1,2,3,4,5,6\n2,3,4,5,6,7");
        LottoFactory lottoFactory = new CustomLottoFactory();
        LottoGame lottoGame = new LottoGame(lottoFactory);

        lottos = lottoGame.buyLotto(2000);
    }

    @Test
    void 로또_발급_및_toString_테스트(){
        assertThat(lottos.toString()).contains("[1, 2, 3, 4, 5, 6]\n[2, 3, 4, 5, 6, 7]");
    }


    @Test
    void 로또_분석_테스트() {
        LottoAnalysisResult result = lottos.analysis(
                new LastWinLotto(
                        new Lotto(3, 4, 5, 6, 7, 9), LottoNumber.of(2)));

        assertAll(
                () -> assertThat(result.countByLottoRank(FIFTH)).isEqualTo(0),
                () -> assertThat(result.countByLottoRank(FOURTH)).isEqualTo(1),
                () -> assertThat(result.countByLottoRank(SECOND)).isEqualTo(1),
                () -> assertThat(result.countByLottoRank(FIRST)).isEqualTo(0),
                () -> assertThat(result.earningRate()).isEqualTo("15025.00")
        );
    }

    @AfterEach
    void after(){
        InputView.close();
    }
}
