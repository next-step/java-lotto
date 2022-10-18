package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("6개의 숫자가 생성되는지 확인")
    void testIfGenerate6Nums(){
        Lotto lotto = new Lotto();

        List<Integer> lottoNums = lotto.getLottoNums();
        assertThat(lottoNums).hasSize(6);
    }
}
