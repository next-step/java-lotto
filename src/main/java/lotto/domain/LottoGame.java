package lotto.domain;

public class LottoGame {

  public static LottoResult match(LottoTicket lottoTicket, WinLotto winLotto) {
    return lottoTicket.match(winLotto);
  }

}
