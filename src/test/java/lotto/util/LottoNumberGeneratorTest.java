package lotto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {
  @Test
  @DisplayName("제대로 생성이 되는가")
  public void create() throws Exception {
    //given
    LottoNumberGenerator generator = LottoNumberGenerator.createLottoNumbers();
    //when
    //then
    assertNotNull(generator.getLottos());
  }

  @Test
  @DisplayName("중복 값 없이 1 ~ 45가 생성되는가")
  public void hasNotDuplicate() throws Exception {
    //given
    LottoNumberGenerator generator = LottoNumberGenerator.createLottoNumbers();
    //when
    List<Integer> lottos = generator.getLottos();
    Set<Integer> lottoSet = new HashSet<>(lottos);
    //then
    assertEquals(lottos.size(), lottoSet.size());
  }

  @Test
  @DisplayName("수동으로 로또 번호를 생성할 수 있는가")
  public void createManual() throws Exception {
    //given
    //when
    Lotto manualLottoNumbers = Lotto.createManualLotto(Arrays.asList(6, 5, 4, 3, 2, 1));

    //then
    assertEquals(manualLottoNumbers.toNumbers().size(), 6);
  }

  @Test
  @DisplayName("자동으로 로또 번호를 생성할 수 있는가")
  public void createAuto() throws Exception {
    //given
    //when
    Lotto autoLottoNumbers = Lotto.createAutoLotto();

    //then
    assertEquals(autoLottoNumbers.toNumbers().size(), 6);
  }
}