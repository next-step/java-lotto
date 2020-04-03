package lotto;

import lotto.model.*;
import lotto.model.lottos.Lotto;
import lotto.model.lottos.LottoNumber;
import lotto.model.lottos.Lottos;
import lotto.model.winninglotto.WinningLotto;
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
        Lottos lottos
                = Lottos.createAllLottos(1, Arrays.asList(new Lotto(manualLottoNumbers)));

        //then
        assertThat(lottos.getToTalLottoCount()).isEqualTo(2);
    }

    @DisplayName("구매한 로또의 당첨 Rank를 반환한다.")
    @Test
    void matchTest() {
        List<LottoNumber> manualLottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            manualLottoNumbers.add(new LottoNumber(i));
        }
        Lottos lottos
                = Lottos.createAllLottos(3, Arrays.asList(new Lotto(manualLottoNumbers)));
        WinningLotto winningLotto = new WinningLotto(new Lotto(manualLottoNumbers), new LottoNumber(7));

        //when
        List<Rank> matches = lottos.match(winningLotto);

        //then
        assertThat(matches).hasSize(4);
    }


}