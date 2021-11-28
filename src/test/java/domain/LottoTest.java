package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

  @Test
  @DisplayName("로또 기본생성자는 숫자를 6개 갖는 로또 객체를 생성함을 검증하는 테스트.")
  void lottoDefaultConstructor() {
    // given, when
    Lotto lotto = new Lotto();
    List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();

    // then
    assertThat(lottoNumbers).isNotEmpty();
    assertThat(lottoNumbers.size()).isEqualTo(Lotto.LOTTO_SIZE);
  }

}
