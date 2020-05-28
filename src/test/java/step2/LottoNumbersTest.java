package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("기본 로또 번호 콜렉션 클래스 테스트")
class LottoNumbersTest {
    @Test
    @DisplayName("로또 번호가 1부터 45까지 존재하는지 확인하는 테스트")
    void lottoNumbersTest() {
        List<Integer> lottoNumbers = LottoNumbers.getLottoNumbers();
        int index;
        for (int i = 1; i <= 45; i++) {
            index = i - 1;
            assertThat(i).isEqualTo(lottoNumbers.get(index));
        }
    }
}