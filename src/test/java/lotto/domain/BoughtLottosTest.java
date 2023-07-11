package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoughtLottosTest {

    @Test
    @DisplayName("구입한 로또 정상 생성 입력 테스트")
    void boughtLottos_create() {
        /* given */
        List<Lotto> lottos = new ArrayList<>();

        /* when & then */
        assertDoesNotThrow(() -> new BoughtLottos(lottos));
    }
}
