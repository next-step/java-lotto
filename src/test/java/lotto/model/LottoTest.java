package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.enums.Grade;
import lotto.exception.LottoLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {

  @Test
  @DisplayName("당첨 번호와 상품으로 만들어진 로또의 번호가 일치하는지 확인한다.")
  void winningProduct() {
    Lotto lotto = Lotto.from(Set.of(1, 2, 3, 4, 5, 6));
    assertThat(lotto).isEqualTo(new Lotto(Set.of(
        1, 2, 3, 4, 5, 6)));
  }


  @Test
  @DisplayName("로또 사이즈는 6자리입니다.")
  void lottoSizeException() {
    assertThrows(LottoLengthException.class, () -> {
      List<Integer> lottoNumbers = List.of(7, 8, 8, 9, 5, 6);
      new Lotto(new HashSet<>(lottoNumbers));
      new Lotto(
          Set.of(7, 8, 9, 5, 6, 10, 17));

    });
  }

  @Test
  @DisplayName("복권을 통해 당첨된 결과를 확인한다.")
  void lottoGrade() {
    Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
    assertThat(lotto.reflectLottoGrade(3, false))
        .isEqualTo(new Lotto(lotto.numbers(), Grade.FIFTH));
  }

  @ParameterizedTest
  @DisplayName("로또 계수기를 통해 몇 장인지 센다.")
  @CsvSource(value = {"FIRST:0","SECOND:0","THIRD:0","FOURTH:1","FIFTH:2"},delimiter = ':')
  void lottoCounts(String input, String output) {
    List<Lotto> lotteryTickets = new ArrayList<>();
    lotteryTickets.add(new Lotto(Set.of(1, 2, 3, 4, 5, 6)).reflectLottoGrade(3, false));
    lotteryTickets.add(new Lotto(Set.of(1, 2, 3, 4, 5, 6)).reflectLottoGrade(4, false));
    lotteryTickets.add(new Lotto(Set.of(1, 2, 3, 4, 5, 6)).reflectLottoGrade(3, false));
    LotteryNoteCounter lotteryNoteCounter = new LotteryNoteCounter(lotteryTickets);
    assertThat(lotteryNoteCounter.lotteryCount(Grade.valueOf(input))).isEqualTo(Integer.parseInt(output));
  }
}