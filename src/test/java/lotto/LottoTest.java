package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private List <Integer> lottoNumber;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lottoNumber = Arrays.asList(new Integer[]{6, 13, 23, 29, 35, 42});
        lotto = new Lotto(lottoNumber);
    }

    @Test
    @DisplayName("입력한 당첨번호와 3개일치 테스트")
    void lottoWinning() {
        String LastWeekWinnerNumber = "1,2,3,13,35,42";
        lotto.winnerCheck(LastWeekWinnerNumber);
        assertThat(lotto.getWinnerNumberCount()).isEqualTo(3);
        assertThat(LottoEnum.findByPrice(lotto.getWinnerNumberCount()).price()).isEqualTo(5000);
    }

    @Test
    @DisplayName("입력한 당첨번호와 6개일치 테스트")
    void lottoWinningAll() {
        String LastWeekWinnerNumber = "6,13,23,29,35,42";
        lotto.winnerCheck(LastWeekWinnerNumber);
        assertThat(lotto.getWinnerNumberCount()).isEqualTo(6);
        assertThat(LottoEnum.findByPrice(lotto.getWinnerNumberCount()).price()).isEqualTo(20000000);
    }

    @Test
    @DisplayName("로또 번호 출력을 위한 리스트를 스트링으로 변환 테스트")
    void lottoNumber() {
        Lotto lotto = new Lotto(Arrays.asList(new Integer[]{1,2,3,4,5,6}));
        assertThat(lotto.lottoNumber()).isEqualTo("1,2,3,4,5,6");
    }

}
