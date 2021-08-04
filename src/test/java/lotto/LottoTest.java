package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("로또 테스트")
public class LottoTest {

    @DisplayName("로또의 번호 개수는 6개이어여 한다.")
    @Test
    public void lottoNumberCountTest() {
        // given, when
        Lotto lotto = new Lotto();

        // then
        assertEquals(lotto.getNumberSize(), 6);
    }
}
