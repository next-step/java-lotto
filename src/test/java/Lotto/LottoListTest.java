package Lotto;

import Lotto.domain.Lotto;
import Lotto.domain.LottoList;
import Lotto.domain.LottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoListTest {
    private LottoList lottoList;

    @BeforeEach
    void setUp() {
        List<Lotto> lottos = new ArrayList<>();

        lottos.add(Lotto.newManualLotto(LottoNumbers.of("1,2,3,4,5,6")));
        lottos.add(Lotto.newManualLotto(LottoNumbers.of("1,2,3,4,8,9")));
        lottos.add(Lotto.newManualLotto(LottoNumbers.of("1,2,3,4,10,11")));
        lottos.add(Lotto.newManualLotto(LottoNumbers.of("1,2,3,4,10,12")));

        lottos.add(Lotto.newAutoLotto(LottoNumbers.of("10,11,12,13,14,15")));
        lottos.add(Lotto.newAutoLotto(LottoNumbers.of("10,11,12,13,14,15")));
        lottos.add(Lotto.newAutoLotto(LottoNumbers.of("10,11,12,13,14,15")));

        lottoList = LottoList.of(lottos);
    }

    @Test
    @DisplayName("수동, 자동 로또의 갯수를 가지고 온다")
    void lottoCountTest() {
        assertThat(lottoList.getManualLottoCount()).isEqualTo(4);
        assertThat(lottoList.getAutoLottoCount()).isEqualTo(3);
    }
}
