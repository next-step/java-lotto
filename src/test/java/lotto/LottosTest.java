package lotto;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @DisplayName("autoLottoCount와 수동 생성 로또번호를 주면 두 종류의 로또를 합친 객체를 반환")
    @Test
    void createTest() {
        //given
        List<LottoNumber> manualLottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            manualLottoNumbers.add(new LottoNumber(i));
        }

        //when
        Lottos lottos = new Lottos(1, Arrays.asList(new Lotto(manualLottoNumbers)));

        //then
        assertThat(lottos.getTotalLottoCount()).isEqualTo(2);
    }
}
