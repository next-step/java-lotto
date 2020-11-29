package lotto.model.lotto;

import lotto.model.Hit;
import lotto.model.LottoPrice;
import lotto.strategy.AutoStrategy;
import lotto.strategy.ManualStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottoes {
    private static final String LOTTOES_FORMAT = "%s\n%s";

    private List<CandidateLotto> lottoes = new LinkedList<>();

    public Lottoes(int autoLottoPrice, List<String> userInputs){
        int autoLottoCount = autoLottoPrice/Lotto.PRICE;

        this.lottoes.addAll(makeManualLotto(userInputs));
        this.lottoes.addAll(makeAutoLotto(autoLottoCount));
    }

    public Map<Hit, Integer> matches(WinningLotto winningLotto, LottoNumber bonus) {
        Map<Hit, Integer> hits = Hit.getHits();

        lottoes.stream()
                .map(lotto -> lotto.intersect(winningLotto, bonus))
                .map(matchingNumber -> Hit.findByNumbers(matchingNumber, bonus))
                .forEach(hit -> hits.computeIfPresent(hit, (Hit key, Integer value) -> ++value));

        return hits;
    }

    public double earningRate(WinningLotto winningLotto, LottoNumber bonus, LottoPrice lottoPrice) {
        long totalReword = matches(winningLotto,bonus).entrySet().stream()
                .mapToLong(this::calculateReword)
                .sum();

        BigDecimal safeReword = BigDecimal.valueOf((double) totalReword);
        BigDecimal safeAmount = BigDecimal.valueOf(lottoPrice.totalPrice());

        return safeReword
                .divide(safeAmount, 2, RoundingMode.FLOOR)
                .doubleValue();
    }

    public int size(){
        return lottoes.size();
    }

    private long calculateReword(Map.Entry<Hit, Integer> hits) {
        return hits.getKey().calculateReword(hits.getValue());
    }

    private List<CandidateLotto> makeAutoLotto(int autoLottoCount) {
        return IntStream.range(0, autoLottoCount)
                .mapToObj(e -> new CandidateLotto(new AutoStrategy()))
                .collect(Collectors.toList());
    }

    private List<CandidateLotto> makeManualLotto(List<String> userInputs){
        return userInputs.stream()
                .map(ManualStrategy::new)
                .map(CandidateLotto::new)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return lottoes.stream()
                .map(Lotto::toString)
                .reduce( (x,y) -> String.format(LOTTOES_FORMAT, x,y))
                .orElse("");
    }
}
