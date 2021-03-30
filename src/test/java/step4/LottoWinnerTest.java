package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerLotto {

    @Test
    @DisplayName("당첨 로또 생성")
    public void test1() {
        LottoWinner lottoWinner = new LottoWinner();
        assertThat(lottoWinner).isEqualTo(new LottoWinner());
    }
}
