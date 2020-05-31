package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.util.AutoLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {

  @DisplayName("로또 티켓 하나는 6개의 숫자를 들고 있다.")
  @Test
  void 로또_티켓의_숫자는_6가지이다() {
    final int LOTTO_NUMBER_SIZE = 6;
    assertThat(new LottoTicket(AutoLottoNumberGenerator.pickList()).getLottoNumbers().size())
        .isEqualTo(LOTTO_NUMBER_SIZE);
  }

  @DisplayName("로또 티켓의 숫자는 각각 오름차순 순서대로 인덱스가 정렬되어 있다.")
  @Test
  void 로또_티켓의_숫자는_오름차순으로_정렬되어_있다() {
    LottoTicket lottoTicket = new LottoTicket(AutoLottoNumberGenerator.pickList());
    List<LottoNumber> lottoNumberListOriginal = lottoTicket.getLottoNumbers();
    List<LottoNumber> lottoNumberListCopy = new ArrayList<>(lottoNumberListOriginal);
    lottoNumberListCopy.sort(Comparator.comparing(LottoNumber::getNumber));
    assertThat(lottoNumberListOriginal.equals(lottoNumberListCopy)).isTrue();
  }
}
