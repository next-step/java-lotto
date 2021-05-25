package study.ascii92der.lotto.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    @DisplayName("일치되는 로또 번호 계산")
    void lottoMatchedNumberTest() {
        String lottoString = "23,3,4,5,6,44";
        LottoResult lottoResult = new LottoResult(new Lotto(lottoString), new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lottoResult.matchNumberCount()).isEqualTo(4);
    }
}
