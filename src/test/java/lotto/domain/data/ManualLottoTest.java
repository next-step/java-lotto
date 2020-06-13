package lotto.domain.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualLottoTest {
    @DisplayName("List<Integer> 를 입력받아 ManualLotto가 정상적으로 생성된다.")
    public void createTest() {
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        ManualLotto manualLotto = ManualLotto.of(numbers);
        assertThat(manualLotto).isNotNull();
    }

    @DisplayName("lottoNumber를 정상적으로 가져올 수 있다.")
    @Test
    public void createGetNumbersTest() {
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        ManualLotto manualLotto = ManualLotto.of(numbers);
        List<LottoNumber> lottoNumbers = manualLotto.getNumbers();
        assertThat(lottoNumbers).containsOnly(LottoNumber.of(1),LottoNumber.of(2),LottoNumber.of(3),LottoNumber.of(4),LottoNumber.of(5), LottoNumber.of(6));
    }

    @DisplayName("빈 List<Integer> 를 입력하면 빈 lottoNumber를 가져온다.")
    @Test
    public void createEmptyTest() {
        List<Integer> numbers = new ArrayList<>();
        ManualLotto manualLotto = ManualLotto.of(numbers);
        List<LottoNumber> lottoNumbers = manualLotto.getNumbers();
        assertThat(lottoNumbers).isEmpty();
    }

    @DisplayName("LottoManual 이 비어있는지 비어 있지 않은 지 알 수 있다.")
    @Test
    void isEmptyTest() {
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        ManualLotto manualLotto = ManualLotto.of(numbers);
        ManualLotto emptyManualLotto = ManualLotto.of(null);

        assertThat(manualLotto.isEmpty()).isFalse();
        assertThat(emptyManualLotto.isEmpty()).isTrue();
    }
}
