import domain.BonusBall;
import domain.Lotto;
import domain.WinningLotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
public class WinningLottoTest {

    @Test
    public void 보너스번호_중복에러_테스트() {
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(1);
        lottoNumbers.add(2);
        lottoNumbers.add(3);
        lottoNumbers.add(4);
        lottoNumbers.add(5);
        lottoNumbers.add(6);

        assertThatThrownBy(() -> new WinningLotto(new Lotto(() -> lottoNumbers), new BonusBall(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
