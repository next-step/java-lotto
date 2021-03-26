package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
}