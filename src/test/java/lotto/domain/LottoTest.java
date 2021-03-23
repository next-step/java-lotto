package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("로또 번호 추출 테스트")
    void extractionLottoNumber() {
        Lotto lotto = new Lotto(Lotto.extractionLottoNumber());

        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("1 ~ 45 숫자 만들기")
    void createReferenceNumbers() {
        List<Integer> referenceNumbers = Lotto.createReferenceNumbers();
        assertThat(referenceNumbers.size()).isEqualTo(45);
    }
}
