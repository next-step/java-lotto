package dev.solar.lotto.domain;

import java.util.ArrayList;
import java.util.List;

import dev.solar.lotto.LottoException;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;

    private final List<LottoTicket> lottoTickets = new ArrayList<>();
    private int payment;
    private int remainingLottoTicket = 0;

    private Lotto() {}

    public Lotto(final int payment) {
        this.payment = payment;
    }

    public static Lotto buyLottoTickets(final int payment) {
        final Lotto lotto = new Lotto();
        lotto.payment = payment;
        lotto.remainingLottoTicket = payment / LOTTO_PRICE;
        return lotto;
    }

    public LottoTicket pick() {
        if (isEmptyNewLottoTickets()) {
            throw new LottoException("모든 로또티켓을 사용했습니다.");
        }
        final LottoTicket lottoTicket = LottoTicket.buyOne();
        decreasePurchaseAmount();
        lottoTickets.add(lottoTicket);
        return lottoTicket;
    }

    public boolean isEmptyNewLottoTickets() {
        return remainingLottoTicket <= 0;
    }

    private void decreasePurchaseAmount() {
        this.remainingLottoTicket -= 1;
    }

    public ResultBoard checkWinningResult(WinningLotto winningLotto) {
        final ResultBoard resultBoard = new ResultBoard();
        for (final LottoTicket lottoTicket : lottoTickets) {
            resultBoard.addResult(winningLotto.match(lottoTicket));
        }
        return resultBoard;
    }

    public double calculateProfitMargin(ResultBoard resultBoard) {
        final long totalPrizeMoney = resultBoard.getNavigableKeySet()
                                                .stream()
                                                .mapToInt(
                                                          prizeMoney -> prizeMoney.getPrizeMoney() * resultBoard.getValue(prizeMoney)
                                                  ).sum();
        return (double) totalPrizeMoney / payment;
    }

    public int getRemainingLottoTicket() {
        return remainingLottoTicket;
    }

    public List<LottoTicket> getLottoTickets() {
        return List.copyOf(lottoTickets);
    }
}
