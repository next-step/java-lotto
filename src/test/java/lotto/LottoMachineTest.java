package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @Test
    @DisplayName("1~45개 숫자를 가지는 로또 기계 생성 테스트")
    void lottoMachine() {
        List<Integer> createLootoMachine = lottoMachine.createLottoMachine();
        for (int i = 1; i <= 45; i++) {
            assertThat(createLootoMachine).contains(i);
        }
    }

    @Test
    @DisplayName("6개 번호를 랜덤으로 추출 테스트")
    void lottoRandomNumber() {
        List<Integer> lottoNum = lottoMachine.autoLottoNumber();
        assertThat(lottoNum.size()).isEqualTo(6);
    }

}
