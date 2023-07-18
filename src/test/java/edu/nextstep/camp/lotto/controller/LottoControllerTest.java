package edu.nextstep.camp.lotto.controller;

import edu.nextstep.camp.lotto.domain.AutoLottoFactory;
import edu.nextstep.camp.lotto.view.ConsoleLottoInputView;
import edu.nextstep.camp.lotto.view.ConsoleLottoOutputView;
import edu.nextstep.camp.lotto.view.InputView;
import edu.nextstep.camp.lotto.view.LottoView;
import edu.nextstep.camp.testUtils.TestUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoControllerTest {

    @ParameterizedTest
    @ValueSource(strings = {"-1", "15", "20"})
    void 수동_로또_갯수_유효성_체크(String manualCount) {
        LottoController controller = new LottoController(new AutoLottoFactory(), new LottoView(new ConsoleLottoInputView(), new ConsoleLottoOutputView()));

        TestUtils.systemSetIn(manualCount);

        Assertions.assertThatIllegalArgumentException().isThrownBy(
                ()-> controller.buyLottos(14)
        ).withMessageContaining("수동 로또는 0~14개 구입 가능 합니다.");
    }

    @AfterEach
    void close(){
        InputView.close();
    }
}