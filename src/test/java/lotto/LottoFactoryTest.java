package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoFactoryTest {

    @DisplayName("오름차순으로 정렬된지 체크")
    @Test
    void sort() {
        List<LottoNumber> lottoNumbers = LottoFactory.create();

        for (int i = 0; i < lottoNumbers.size()-1; i++) {
            Assertions.assertThat(lottoNumbers.get(i).compareTo(lottoNumbers.get(i+1)) < 0).isTrue();
        }
    }

    @Test
    void size() {
        List<LottoNumber> lottoNumbers = LottoFactory.create();
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}
