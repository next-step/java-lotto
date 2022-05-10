package dev.solar.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;
    private static final int INITIAL_COUNT = 0;
    private static final int INCREASE_COUNT = 1;

    private final List<LottoTicket> lottoTickets = new ArrayList<>();
    private final TreeMap<PrizeMoney, Integer> winningResult = new TreeMap<>();
    private int payment;
    private int remainingLottoTicket = 0;

    public static Lotto buyLottoTickets(final int payment) {
        final Lotto lotto = new Lotto();
        lotto.payment = payment;
        lotto.remainingLottoTicket = payment / LOTTO_PRICE;
        initialWinningResult(lotto);
        return lotto;
    }

    private static void initialWinningResult(final Lotto lotto) {
        Arrays.stream(PrizeMoney.values())
              .forEach(
                      PrizeMoney -> lotto.winningResult.put(PrizeMoney, INITIAL_COUNT)
              );
    }

    public LottoTicket pick() {
        if (!isRemainNewLottoTickes()) {
            throw new LottoException("모든 로또티켓을 사용했습니다.");
        }
        final LottoTicket lottoTicket = LottoTicket.buyOne();
        decreasePurchaseAmount();
        lottoTickets.add(lottoTicket);
        return lottoTicket;
    }

    public boolean isRemainNewLottoTickes() {
        return remainingLottoTicket > 0;
    }

    private void decreasePurchaseAmount() {
        this.remainingLottoTicket -= 1;
    }

    public TreeMap<PrizeMoney, Integer> checkWinningResult(Set<LottoNumber> winningNumbers) {
        for (final LottoTicket lottoTicket : lottoTickets) {
            aggregateResult(winningNumbers, lottoTicket, winningResult);
        }
        return winningResult;
    }

    private void aggregateResult(final Set<LottoNumber> winningNumbers, final LottoTicket lottoTicket, final Map<PrizeMoney, Integer> winningResult) {
        final int result = lottoTicket.checkWinningNumbers(winningNumbers);
        final Optional<PrizeMoney> prizeMoneyKey = PrizeMoney.getPrizeMoney(result);
        if (prizeMoneyKey.isEmpty()) {
            return;
        }
        final PrizeMoney prizeMoney = prizeMoneyKey.get();
        winningResult.put(prizeMoney, winningResult.get(prizeMoney) + INCREASE_COUNT);
        // 아래 코드에서 money 타입을 읽지 못해 오류가 나서 위에 코드로 작성
        // error - required type object provided lambda parameter
//        prizeMoneyKey.isPresent(money -> {
//            winningResult.put(money, winningResult.get(money) + INCREASE_COUNT);
//        });
    }

    public int getRemainingLottoTicket() {
        return remainingLottoTicket;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
