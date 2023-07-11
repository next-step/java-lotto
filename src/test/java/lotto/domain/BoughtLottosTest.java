package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
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

    @Test
    @DisplayName("구입한 로또의 개수 테스트")
    void boughtLottos_count() {
        /* given */
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(LottoTest.getBalls("1", "2", "3", "4", "5", "6")));
        lottos.add(new Lotto(LottoTest.getBalls("1", "2", "3", "4", "5", "6")));

        /* when */
        BoughtLottos boughtLottos = new BoughtLottos(lottos);

        /* then */
        assertThat(boughtLottos.getCount()).isEqualTo(lottos.size());
    }
}
