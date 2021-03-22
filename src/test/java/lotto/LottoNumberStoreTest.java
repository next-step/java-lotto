package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoNumberStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberStoreTest {

  private LottoNumberStore store;

  @BeforeEach
  void setUp() {
    store = new LottoNumberStore();
  }

  @Test
  @DisplayName("[LottoNumberStore] 1-45 base 숫자 생성 테스트")
  void createBaseNumberTest() {
    int size = store.createBaseNumbers().size();

    assertThat(size).isEqualTo(45);
  }

  @Test
  @DisplayName("[LottoNumberStore] 로또 번호 생성 테스트")
  void createLottoNumberTest() {
    int size = store.createLottoNumbers().size();

    assertThat(size).isEqualTo(6);
  }
}
