package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.Lotto;
import study.lotto.exception.WrongLottoNumberException;
import study.lotto.exception.WrongLottoSizeException;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("자동으로 랜덤한 6개의 로또 번호를 가진 로또종이가 생성")
    @Test
    public void randomNumberLottoPaperTest() {
        Lotto lotto = Lotto.randomLotto();
        assertThat(lotto.lotto().size()).isEqualTo(6);
    }

    @DisplayName("입력받아 로또 생성")
    @Test
    public void newWithString(){
        Lotto stringLotto = new Lotto("1,2,3,4,5,6");
        assertThat(stringLotto).isEqualTo(new Lotto("1,2,3,4,5,6"));

        Lotto integersLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThat(integersLotto).isEqualTo(new Lotto("1,2,3,4,5,6"));
    }

    @DisplayName("잘못된 로또 번호가 있을때")
    @Test
    public void invalidLottoNumber(){
        assertThatThrownBy(() -> new Lotto("-1,2,3,4,5,6"))
                .isInstanceOf(WrongLottoNumberException.class);

        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,46"))
                .isInstanceOf(WrongLottoNumberException.class);
    }

    @DisplayName("로또 번호가 개수가 다를 때")
    @Test
    public void invalidLottoSize(){
        //중복포함 6개, 5개 번호
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,5"))
                .isInstanceOf(WrongLottoSizeException.class);

        //5개번호
        assertThatThrownBy(() -> new Lotto("2,3,4,5,6"))
                .isInstanceOf(WrongLottoSizeException.class);

        //7개번호
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,6,7"))
                .isInstanceOf(WrongLottoSizeException.class);

    }



    @DisplayName("당첨 번호와 일치 개수 확인")
    @Test
    public void randomNumberLottoPaperTest2() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto winningLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        int matchCount = lotto.matchWinningNumberCount(winningLotto);

        assertThat(matchCount).isEqualTo(6);
    }


}
