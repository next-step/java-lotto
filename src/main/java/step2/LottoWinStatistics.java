package step2;

import java.util.*;

public class LottoWinStatistics {

    private int numberOfSamples = 0;
    private final Lotto winnersLotto;
    private final Map<LottoWin, LottoBucket> lottoBucketByLottoWin = new EnumMap<LottoWin, LottoBucket>(LottoWin.class) {{
        Arrays.stream(LottoWin.values())
                .forEach(w -> lottoBucketByLottoWin.put(w, new LottoBucket()));
    }};

    public LottoWinStatistics(Lotto winnersLotto) {
        this.winnersLotto = winnersLotto;
    }

    public void addLottoSample(Lotto sampleLotto) {
        int match = winnersLotto.countMatch(sampleLotto);
        LottoWin result = LottoWin.fromMatch(match).orElse(LottoWin.NONE_WIN);

        LottoBucket lottoBucket = this.lottoBucketByLottoWin.get(result);
        lottoBucket.addLotto(sampleLotto);

        this.numberOfSamples += 1;
    }

    public void addLottoSamples(List<Lotto> lottoes) {
        lottoes.forEach(this::addLottoSample);
    }

    public double getProfitRate(int lottoUnitPrice) {
        int totalCost = lottoUnitPrice * this.numberOfSamples;

        double earning = lottoBucketByLottoWin.keySet().stream()
                .map(w -> w.prize() * lottoBucketByLottoWin.get(w).size())
                .reduce(Integer::sum).orElse(0);

        if (totalCost == 0) {
            return 0.0;
        }

        return earning / totalCost;
    }
}
