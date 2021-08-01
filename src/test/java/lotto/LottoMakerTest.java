package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMakerTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void makeLottoTest() {
        assertThat(LottoMaker.run()).isInstanceOf(Lotto.class);
    }

    @Test
    @DisplayName("수동 생성 테스트")
    void makeManualLottoTest() {
        Set<Integer> lotto = new HashSet<>(Arrays.asList(1,2,3,4,5,6));

        assertThat(LottoMaker.manual(lotto)).isInstanceOf(Lotto.class);
    }

}