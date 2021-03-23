package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {

  @Test
  @DisplayName("[LottoStore] 수량만큼 로또 생성 테스트")
  void generateLottoTest() {
    LottoStore store = new LottoStore();
    List<LottoNumbers> lottos = store.generateLottos(14);

    int size = lottos.size();

    assertThat(size).isEqualTo(14);
  }
}
