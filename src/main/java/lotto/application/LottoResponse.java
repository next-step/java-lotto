package lotto.application;

import lotto.domain.lotto.Lotteries;
import lotto.domain.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LottoResponse {
    private final List<Lotto> lottoResponse;

    private LottoResponse(List<Lotto> lottoResponse) {
        this.lottoResponse = lottoResponse;
    }

    public static LottoResponse of(List<Lotto> lotteries) {
        return new LottoResponse(lotteries);
    }

    public static LottoResponse of(Lotteries manualLotteries, Lotteries autoLotteries) {
        List<Lotto> allLotteries = new ArrayList<>();
        allLotteries.addAll(manualLotteries.getLotteries());
        allLotteries.addAll(autoLotteries.getLotteries());
        return new LottoResponse(allLotteries);
    }

    public Lotteries getLottoResponse() {
        return Lotteries.of(lottoResponse.stream()
                .map(Lotto::toIntValues)
                .collect(toList()));
    }

    public int boughtCount() {
        return lottoResponse.size();
    }

    public int size() {
        return lottoResponse.size();
    }
}
