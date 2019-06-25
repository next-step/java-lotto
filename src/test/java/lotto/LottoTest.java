package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("입력한 당첨번호와 3개일치 테스트")
    void lottoWinning() {
        boolean matchBonus = false;
        Lotto lotto = new Lotto(Arrays.asList(new Integer[]{6, 13, 23, 29, 35, 42}));
        String LastWeekWinnerNumber = "1,2,3,13,35,42";
        lotto.winnerCheck(LastWeekWinnerNumber, "36");
        assertThat(lotto.getWinnerNumberCount()).isEqualTo(3);
        assertThat(LottoEnum.findByPrice(lotto.getWinnerNumberCount(), matchBonus).price()).isEqualTo(5000);
    }

    @Test
    @DisplayName("입력한 당첨번호와 6개일치 테스트")
    void lottoWinningAll() {
        boolean matchBonus = false;
        Lotto lotto = new Lotto(Arrays.asList(new Integer[]{6, 13, 23, 29, 35, 42}));
        String LastWeekWinnerNumber = "6,13,23,29,35,42";
        lotto.winnerCheck(LastWeekWinnerNumber, "36");
        assertThat(lotto.getWinnerNumberCount()).isEqualTo(6);
        assertThat(LottoEnum.findByPrice(lotto.getWinnerNumberCount(), matchBonus).price()).isEqualTo(200000000);
    }

    @Test
    @DisplayName("로또 번호 출력을 위한 리스트를 스트링으로 변환 테스트")
    void lottoNumber() {
        Lotto lotto = new Lotto(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}));
        assertThat(lotto.lottoNumber()).isEqualTo("1,2,3,4,5,6");
    }

    @Test
    @DisplayName("로또 번호 중복 생성 테스트")
    void lottoNumberError() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(new Integer[]{1, 2, 3, 4, 6, 6})))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("로또 번호의 수가 6이 아니거나 중복된 숫자가 있습니다.");

    }

}
