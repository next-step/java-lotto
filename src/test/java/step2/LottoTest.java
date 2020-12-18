package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 당첨확인_실패() {
        Lotto lotto = new Lotto(new LottoNumbers(
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6),
                LottoNumber.of(7)
        ));
        LottoNumber bonusNumber = LottoNumber.of(7);
        WinResult winResult = lotto.getWinResult(new LottoNumbers(
                LottoNumber.of(8),
                LottoNumber.of(9),
                LottoNumber.of(10),
                LottoNumber.of(11),
                LottoNumber.of(12),
                LottoNumber.of(13)
        ), bonusNumber);
        assertThat(winResult).isEqualTo(WinResult.MISS);
    }

    @Test
    public void 당첨확인_일등() {
        Lotto lotto = new Lotto(new LottoNumbers(
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6),
                LottoNumber.of(7)
        ));
        LottoNumber bonusNumber = LottoNumber.of(8);
        WinResult winResult = lotto.getWinResult(new LottoNumbers(
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6),
                LottoNumber.of(7)
        ), bonusNumber);
        assertThat(winResult).isEqualTo(WinResult.FIRST);
    }

    @Test
    public void 당첨확인_2등() {
        Lotto lotto = new Lotto(new LottoNumbers(
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6),
                LottoNumber.of(8)
        ));
        LottoNumber bonusNumber = LottoNumber.of(8);
        WinResult winResult = lotto.getWinResult(new LottoNumbers(
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6),
                LottoNumber.of(7)
        ), bonusNumber);
        assertThat(winResult).isEqualTo(WinResult.SECOND);
    }

    @Test
    public void 당첨확인_3등() {
        Lotto lotto = new Lotto(new LottoNumbers(
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6),
                LottoNumber.of(7)
        ));
        LottoNumber bonusNumber = LottoNumber.of(7);
        WinResult winResult = lotto.getWinResult(new LottoNumbers(
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(12),
                LottoNumber.of(13)
        ), bonusNumber);
        assertThat(winResult).isEqualTo(WinResult.THIRD);
    }

}
