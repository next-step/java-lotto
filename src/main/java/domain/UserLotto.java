package domain;

import policy.LottoPrice;
import policy.LottoRandomNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UserLotto {
    private List<Lotto> lottoTickets = new ArrayList<>();

    public UserLotto() {

    }

    public UserLotto(Lotto lotto) {
        this.lottoTickets = Arrays.asList(lotto);
    }

    public UserLotto(List<Lotto> lotto) {
        this.lottoTickets = lotto;
    }

    public List<Lotto> generateRandomLottoTickets(final long money) {
        checkUnderZero(money);
        long lottoTicketCount = money / LottoPrice.LOTTO_PRICE;

        for (int i = 0; i < lottoTicketCount; i++) {
            List<Integer> lottoNumbers = LottoRandomNumberGenerator.generateLottoNumber();

            Lotto lotto = new Lotto(lottoNumbers);
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }

    private static void checkUnderZero(long money) {
        if (money < LottoPrice.LOTTO_PRICE) {
            throw new IllegalArgumentException(LottoPrice.LOTTO_PRICE + "원 이상부터 로또 구매가 가능합니다.");
        }
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public Map<Integer, Integer> matchUserLotto(WinningLotto winningLotto) {
        LottoMatchResult lottoMatchResult = new LottoMatchResult();
        int matchCount = 0;
        for (Lotto lottoTicket : lottoTickets) {
            matchCount = lottoTicket.matchCount(winningLotto);

            lottoMatchResult.storeResult(LottoPrize.fromMatchCount(matchCount).getMatchCount());
        }
        return lottoMatchResult.getAllResult();
    }
}
