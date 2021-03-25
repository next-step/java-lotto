package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberStore;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

  private LottoNumberStore store;
  private LottoNumbers lottoNumbers;

  @BeforeEach
  void setUp() {
    store = new LottoNumberStore();
    lottoNumbers = new LottoNumbers();
  }

  @Test
  @DisplayName("[LottoNumbers] 로또 번호 생성 테스트")
  void createLottoNumbers() {
    int size = lottoNumbers.numbers().size();
    assertThat(size).isEqualTo(6);
  }

  @Test
  @DisplayName("[LottoNumbers] 로또 번호 크기 검증 테스트")
  void validateSizeTest() {
    List<LottoNumber> numbers = IntStream.rangeClosed(1, 7)
        .mapToObj(LottoNumber::new)
        .collect(Collectors.toList());

    assertThatThrownBy(() -> lottoNumbers.validateSize(numbers))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("[LottoNumbers] 로또 번호 중복 검증 테스트")
  void validateDuplicationTest() {
    List<LottoNumber> numbers = Arrays.stream(new int[]{1, 1, 2, 3, 4, 5})
        .mapToObj(LottoNumber::new)
        .collect(Collectors.toList());

    assertThatThrownBy(() -> lottoNumbers.validateDuplication(numbers))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
