package lotto.model;

import lotto.enumset.LottoEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    private LottoOneLine lottoOneLine;
    private boolean matchBonus;

    @BeforeEach
    void setUp() {
        matchBonus = false;
        lottoOneLine = new LottoOneLine(
                Arrays.asList(
                        new LottoNumber("6"),
                        new LottoNumber("13"),
                        new LottoNumber("23"),
                        new LottoNumber("29"),
                        new LottoNumber("35"),
                        new LottoNumber("42")
                )
        );
    }

    @Test
    @DisplayName("입력한 당첨번호와 3개일치 테스트")
    void lottoWinning() {
        String LastWeekWinnerNumber = "1,2,3,13,35,42";
        int winnerCount = lottoOneLine.winnerCheck(LastWeekWinnerNumber);
        assertThat(winnerCount).isEqualTo(3);
        assertThat(LottoEnum.findByPrice(winnerCount, matchBonus).price()).isEqualTo(5000);
    }

    @Test
    @DisplayName("입력한 당첨번호와 6개일치 테스트")
    void lottoWinningAll() {
        String LastWeekWinnerNumber = "6,13,23,29,35,42";
        int winnerCount = lottoOneLine.winnerCheck(LastWeekWinnerNumber);
        assertThat(winnerCount).isEqualTo(6);
        assertThat(LottoEnum.findByPrice(winnerCount, matchBonus).price()).isEqualTo(200000000);
    }

    @Test
    @DisplayName("로또 번호 출력을 위한 리스트를 스트링으로 변환 테스트")
    void lottoNumber() {
        assertThat(lottoOneLine.lottoNumber()).isEqualTo("6,13,23,29,35,42");
    }

    @Test
    @DisplayName("로또 번호 중복 생성 테스트")
    void lottoNumberError() {
        assertThatThrownBy(() -> new LottoOneLine(
                Arrays.asList(new LottoNumber("6"), new LottoNumber("13"),
                              new LottoNumber("23"), new LottoNumber("29"),
                              new LottoNumber("35"), new LottoNumber("35")))
        ).isInstanceOf(IllegalStateException.class)
         .hasMessage("로또 번호의 수가 6이 아니거나 중복된 숫자가 있습니다.");

    }

}
