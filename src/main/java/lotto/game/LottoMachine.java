package lotto.game;

import lotto.number.LottoBalls;
import lotto.strategy.LottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static final int LOTTO_PRICE = 1000;
    private final LottoNumberStrategy lottoNumberStrategy;

    public LottoMachine(LottoNumberStrategy lottoNumberStrategy) {
        this.lottoNumberStrategy = lottoNumberStrategy;
    }

    public List<LottoBalls> generateTickets(int amount, List<List<Integer>> manualLottoNumbers) {
        int numberOfTickets = amount / LOTTO_PRICE;

        List<LottoBalls> lottoTickets = new ArrayList<>();

        if (manualLottoNumbers.size() > numberOfTickets) {
            throw new IllegalArgumentException("수동 로또를 발행하기 위한 금액이 부족합니다.");
        }

        for (List<Integer> manualLottoNumber : manualLottoNumbers) {
            lottoTickets.add(new LottoBalls(manualLottoNumber));
        }

        for (int i = 0; i < numberOfTickets - manualLottoNumbers.size(); i++) {
            lottoTickets.add(new LottoBalls(lottoNumberStrategy.generate()));
        }

        return lottoTickets;
    }
}
