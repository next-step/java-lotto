package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoListTest {

  @Test
  void LottoList_생성_성공() {
    assertDoesNotThrow(() -> new LottoList(5));
  }

  @Test
  void LottoList_생성_실패() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new LottoList(0)
    );
  }

  @ParameterizedTest(name = "{0}개 일치한 로또의 갯수는 1개")
  @ValueSource(ints = {1, 2, 3, 4, 5, 6})
  void getMatchedLottoCount_성공(int matchedCount) {
    Lotto lottoMatched6 = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
    Lotto lottoMatched5 = new Lotto(Set.of(1, 2, 3, 4, 5, 16));
    Lotto lottoMatched4 = new Lotto(Set.of(1, 2, 3, 4, 15, 16));
    Lotto lottoMatched3 = new Lotto(Set.of(1, 2, 3, 14, 15, 16));
    Lotto lottoMatched2 = new Lotto(Set.of(1, 2, 13, 14, 15, 16));
    Lotto lottoMatched1 = new Lotto(Set.of(1, 12, 13, 14, 15, 16));

    LottoList lottoList = new LottoList(List.of(
        lottoMatched1, lottoMatched2, lottoMatched3, lottoMatched4, lottoMatched5, lottoMatched6));

    Lotto winningLotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
    assertThat(lottoList.getMatchedLottoCount(matchedCount, winningLotto)).isEqualTo(1);
  }

  @Test
  void getTotalLottoCount_성공() {
    Lotto lottoMatched6 = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
    Lotto lottoMatched5 = new Lotto(Set.of(1, 2, 3, 4, 5, 16));
    Lotto lottoMatched4 = new Lotto(Set.of(1, 2, 3, 4, 15, 16));
    Lotto lottoMatched3 = new Lotto(Set.of(1, 2, 3, 14, 15, 16));
    Lotto lottoMatched2 = new Lotto(Set.of(1, 2, 13, 14, 15, 16));
    Lotto lottoMatched1 = new Lotto(Set.of(1, 12, 13, 14, 15, 16));

    LottoList lottoList = new LottoList(List.of(
        lottoMatched1, lottoMatched2, lottoMatched3, lottoMatched4, lottoMatched5, lottoMatched6));

    assertThat(lottoList.getTotalLottoCount()).isEqualTo(6);
  }

  @Test
  void getTotalPurchaseAmount_성공() {
    Lotto lottoMatched6 = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
    Lotto lottoMatched5 = new Lotto(Set.of(1, 2, 3, 4, 5, 16));
    Lotto lottoMatched4 = new Lotto(Set.of(1, 2, 3, 4, 15, 16));
    Lotto lottoMatched3 = new Lotto(Set.of(1, 2, 3, 14, 15, 16));
    Lotto lottoMatched2 = new Lotto(Set.of(1, 2, 13, 14, 15, 16));
    Lotto lottoMatched1 = new Lotto(Set.of(1, 12, 13, 14, 15, 16));

    LottoList lottoList = new LottoList(List.of(
        lottoMatched1, lottoMatched2, lottoMatched3, lottoMatched4, lottoMatched5, lottoMatched6));

    assertThat(lottoList.getTotalPurchaseAmount()).isEqualTo(6000);
  }

  @Test
  void toStringForPrinting_성공() {
    Lotto lotto1 = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
    Lotto lotto2 = new Lotto(Set.of(1, 2, 3, 4, 5, 16));
    LottoList lottoList = new LottoList(List.of(lotto1, lotto2));
    String expected = new StringJoiner("\n")
        .add(lotto1.toStringForPrinting())
        .add(lotto2.toStringForPrinting())
        .toString();

    assertThat(lottoList.toStringForPrinting()).isEqualTo(expected);
  }
}
