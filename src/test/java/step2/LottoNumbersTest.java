package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoNumbers;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class LottoNumbersTest {
    @DisplayName("로또번호 생성 확인")
    @Test
    void lott_shuffle() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        List<Integer> afterSuffle = lottoNumbers.getLottoNumbers();

        assertThat(afterSuffle.size()).isEqualTo(6);
    }
}
