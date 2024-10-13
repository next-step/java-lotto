package lotto.game;

import lotto.exception.LottoIllegalArgumentException;
import lotto.number.LottoBalls;
import lotto.strategy.LottoNumberStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    public static final int LOTTO_PRICE = 1000;
    private final LottoNumberStrategy lottoNumberStrategy;

    public LottoMachine(LottoNumberStrategy lottoNumberStrategy) {
        this.lottoNumberStrategy = lottoNumberStrategy;
    }

    public List<LottoBalls> generateTickets(int amount) {
        return generateTickets(amount, Collections.emptyList());
    }

    public List<LottoBalls> generateTickets(int amount, List<List<Integer>> manualLottoNumbers) {
        int totalLottoCount = amount / LOTTO_PRICE;
        int autoLottoCount = totalLottoCount - manualLottoNumbers.size();

        List<LottoBalls> lottoTickets = new ArrayList<>();
        lottoTickets.addAll(generateManualLottoNumber(manualLottoNumbers));
        lottoTickets.addAll(generateAutoLottoNumber(autoLottoCount));

        return lottoTickets;
    }

    public void validateManualLottoCount(int amount, int manualLottoCount) {
        int totalLottoCount = amount / LOTTO_PRICE;
        if (totalLottoCount < manualLottoCount) {
            throw LottoIllegalArgumentException.INVALID_MANUAL_LOTTO_COUNT;
        }
    }

    private List<LottoBalls> generateManualLottoNumber(List<List<Integer>> manualLottoNumbers) {
        return manualLottoNumbers.stream()
                .map(LottoBalls::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private List<LottoBalls> generateAutoLottoNumber(int numberOfTickets) {
        List<LottoBalls> autoLottos = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            autoLottos.add(new LottoBalls(lottoNumberStrategy.generate()));
        }
        return autoLottos;
    }
}
