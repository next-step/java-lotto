package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @DisplayName("로또 번호가 당첨 번호와 일치하는 갯수를 반환하는 테스트")
    @Test
    void countCollectLottoNumber_일치하는_로또_번호_갯수() {
        Lotto lotto = new Lotto(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 7, 8)));
        int result = lotto.compareWinLottoNumber(Arrays.asList(1, 2, 3, 4, 7, 8));
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("로또 랜덤 번호 생성 출력 테스트")
    @Test
    void 단순_출력_테스트(){
        Lotto lotto = new Lotto();
        System.out.println(lotto.toString());
    }
}
