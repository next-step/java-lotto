package lotto.domian;

import lotto.domain.LottoGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoGameTest {

    @DisplayName("LottoGame 객체 정상 생성 테스트")
    @Test
    public void lottoGame_객체_생성_테스트() {
        LottoGame lotto = new LottoGame();
        LottoGame lotto1 = new LottoGame();
        LottoGame lotto2 = new LottoGame();

        assertAll("LottoGame size == 6",
                () -> assertEquals(lotto.getLottoNumber().size(), 6),
                () -> assertEquals(lotto1.getLottoNumber().size(), 6),
                () -> assertEquals(lotto2.getLottoNumber().size(), 6)
        );
    }
}
