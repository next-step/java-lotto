package lotto.game;

import lotto.exception.LottoIllegalArgumentException;
import lotto.number.LottoBalls;
import lotto.strategy.LottoNumberStrategy;
import lotto.strategy.ManualLottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static final int LOTTO_PRICE = 1000;

    private final LottoNumberStrategy lottoNumberStrategy;

    public LottoMachine(LottoNumberStrategy lottoNumberStrategy) {
        this.lottoNumberStrategy = lottoNumberStrategy;
    }

    public void validateManualLottoCount(Money amount, LottoCount manualLottoCount) {
        if (manualLottoCount.isGreaterThan(amount.divideByLottoPrice())) {
            throw LottoIllegalArgumentException.INVALID_MANUAL_LOTTO_COUNT;
        }
    }

    public List<LottoBalls> generateLottoTickets(List<List<Integer>> manualLottoNumbers, LottoCount autoLottoCount) {
        List<LottoBalls> lottoTickets = new ArrayList<>();

        lottoTickets.addAll(generateManualLottoTicket(manualLottoNumbers));
        lottoTickets.addAll(generateAutoLottoTicket(autoLottoCount));
        return lottoTickets;
    }

    public List<LottoBalls> generateManualLottoTicket(List<List<Integer>> manualLottoNumbers) {
        List<LottoBalls> lottoTickets = new ArrayList<>();

        for (List<Integer> manualLottoNumber : manualLottoNumbers) {
            ManualLottoNumberStrategy manualLottoNumberStrategy = new ManualLottoNumberStrategy(manualLottoNumber);
            lottoTickets.add(generateLottoTicket(manualLottoNumberStrategy));
        }

        return lottoTickets;
    }

    public List<LottoBalls> generateAutoLottoTicket(LottoCount count) {
        List<LottoBalls> lottoTickets = new ArrayList<>();

        for (int i = 0; i < count.getValue(); i++) {
            lottoTickets.add(generateLottoTicket(lottoNumberStrategy));
        }
        return lottoTickets;
    }

    public LottoBalls generateLottoTicket(LottoNumberStrategy strategy) {
        return new LottoBalls(strategy.generate());
    }

}
