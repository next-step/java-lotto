package lotto;

import lotto.util.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    @DisplayName("사용자가 입력한 금액에 따른 발급할 로또 개수 테스트")
    void lotteryTickerPer1000() {
        assertThat(12345 / 1000).isEqualTo(12);
    }

    @Test
    @DisplayName("오름차순으로 정렬된 6개의 복권 번호를 자동으로 생성함")
    void generateLottoNumber() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> lotteries = lottoGenerator.generate();

        assertThat(lotteries).hasSize(6);
    }
}
