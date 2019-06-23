package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class lottoTest {

    @Test
    @DisplayName("1~45개 숫자를 가지는 로또 기계 생성 테스트")
    void lottoMachine() {
        LottoMachine lottoMachine = new LottoMachine();
        for (int i = 1; i <= 45; i++){
            assertThat(lottoMachine.lottoNumbers).contains(i);
        }
    }

    @Test
    @DisplayName("6개 번호를 랜덤으로 추출 테스트")
    void lottoRandomNumber(){
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> lottoNum = lottoMachine.getGameNumber();
        assertThat(lottoNum.size()).isEqualTo(6);
    }
}
