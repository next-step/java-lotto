package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {
  @Test
  void 로또_번호가_6개가아니면_IllegalArgumentException이_발생한다() {
    assertThatThrownBy(() -> new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6, 7)
                                                    .map(LottoNumber::new)
                                                    .collect(Collectors.toList())))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또 번호는 6개여야 합니다.");
  }

  @Test
  void 로또_번호에_중복된_숫자가_있으면_IllegalArgumentException이_발생한다() {
    assertThatThrownBy(() -> new LottoNumbers(Stream.of(1, 1, 2, 3, 4, 5)
                                                    .map(LottoNumber::new)
                                                    .collect(Collectors.toList())))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또 번호는 중복이 없어야 합니다.");
  }

  @Test
  void 로또_번호중_1에서45사이가_아닌_숫자가_포함되어_있으면_IllegalArgumentException이_발생한다() {
    assertThatThrownBy(() -> new LottoNumbers(Stream.of(0, 1, 2, 3, 4, 5)
                                                    .map(LottoNumber::new)
                                                    .collect(Collectors.toList())))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또 번호는 1~45 사이의 숫자여야 합니다.");
  }

  @Test
  void 로또_번호는_정렬된_상태다() {
    LottoNumbers lottoNumbers = new LottoNumbers(Stream.of(4, 3, 20, 10, 9, 45)
                                                       .map(LottoNumber::new)
                                                       .collect(Collectors.toList()));
    for (int i = 0; i < lottoNumbers.getNumbers().size() - 1; i++) {
      assertThat(lottoNumbers.getNumbers().get(i)).isLessThan(lottoNumbers.getNumbers().get(i + 1));
    }
  }

  @Test
  void 일치하는_숫자의_갯수를_반환한다() {
    LottoNumbers lottoNumbers = new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6)
                                                       .map(LottoNumber::new)
                                                       .collect(Collectors.toList()));
    LottoNumbers winningNumbers = new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6)
                                                        .map(LottoNumber::new)
                                                        .collect(Collectors.toList()));
    assertThat(lottoNumbers.matchCount(winningNumbers, new LottoNumber(7)))
        .isEqualTo(6);
  }
}
