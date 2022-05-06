package lottoauto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultViewTest {
    @Test
    void 출력_테스트() {
        ResultView.printLottosInfo(Lottos.from(14000));
    }
}