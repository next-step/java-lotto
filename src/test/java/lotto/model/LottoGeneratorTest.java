package lotto.model;

import lotto.util.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottoGeneratorTest {

  @Test
  @DisplayName("로또 생성")
  void generate() {
    Money paidMoney = new Money(15000);
    Lottos lottos = new LottoGenerator(new MockNumberGenerator()).generate(paidMoney);
    assertThat(lottos.getCount()).isEqualTo(15);
  }

  @Test
  @DisplayName("로또 생성2 generate에 List<Integer> 넘기는 방식")
  void generate2() {
    Lotto lotto = LottoGenerator.generate(LottoNumberGenerator.generate(Stream.of(1, 2, 3, 4, 5, 6)));
    assertThat(lotto.contains(new LottoNumber(1))).isTrue();
  }

  @Test
  @DisplayName("로또 group 수동생성")
  void generateManually() {
    List<LottoNumber> lottoNumbers = LottoNumberGenerator.generate(Stream.of(1, 2, 3, 4, 5, 6));
    List<List<LottoNumber>> manualLottoNumbers = Arrays.asList(lottoNumbers);
    Lottos lottos = LottoGenerator.generateManually(manualLottoNumbers);

    assertThat(lottos.getCount()).isEqualTo(1);
  }

  @Test
  @DisplayName("로또 group 두개를 합성")
  void union() {
    Lotto lotto1 = new Lotto(LottoNumberGenerator.generate(Stream.of(1, 3, 5, 6, 9, 11)));
    Lotto lotto2 = new Lotto(LottoNumberGenerator.generate(Stream.of(2, 4, 6, 8, 10, 12)));

    Lottos lottos1 = new Lottos(Arrays.asList(lotto1));
    Lottos lottos2 = new Lottos(Arrays.asList(lotto2));

    Lottos union = LottoGenerator.union(lottos1, lottos2);

    assertThat(union.getLottos()).contains(lotto1, lotto2);
  }
}
