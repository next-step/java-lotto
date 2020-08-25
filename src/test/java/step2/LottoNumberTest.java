package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoNumber;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class LottoNumberTest {
    @DisplayName("로또번호 생성 확인")
    @Test
    void lott_shuffle() {
        LottoNumber lottoNumber = new LottoNumber();
        List<Integer> beforeSuffle = lottoNumber.getLottoNumbers();
        lottoNumber.create();
        List<Integer> afterSuffle = lottoNumber.getLottoNumbers();

        assertThat(beforeSuffle.size()).isEqualTo(45);
        assertThat(afterSuffle.size()).isEqualTo(6);
    }
}
