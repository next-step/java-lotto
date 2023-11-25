package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.util.Util.parseIntegerList;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    List<Integer> defaultLottoNumber = null;

    @BeforeEach
    void set() {
        defaultLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

    }

    @DisplayName("로또 생성")
    @Test
    void 로또_생성() {
        Lotto lotto = new Lotto(defaultLottoNumber);

        assertThat(lotto.getLottoNumber()).hasSize(6);
    }

    @DisplayName("당첨번호 비교 테스트")
    @Test
    void 당첨번호_비교() {
        Lotto lotto = new Lotto(defaultLottoNumber);
        List<Integer> winningNumerList = parseIntegerList(Arrays.asList("1", "2", "3", "4", "5", "6"));
        int bonusNumber = 7;

        lotto.compareWinningNumber(winningNumerList);

        assertThat(lotto.getLottoOriginMatchNumber()).isEqualTo(6);
    }

    @DisplayName("당첨번호 비교 테스트")
    @Test
    void 보너스번호_비교() {
        Lotto lotto = new Lotto(defaultLottoNumber);
        int bonusNumber = 5;

        lotto.addBonusMatchPoint(bonusNumber);

        assertThat(lotto.getLottoBonusMatchNumber()).isEqualTo(1);
    }
}
