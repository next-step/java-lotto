package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(Lotto... lottos) {
        this(Arrays.asList(lottos));
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos as(Lotto... lottos) {
        return new Lottos(lottos);
    }

    public int getPaidMoney() {
        return lottos.size() * Lotto.PRICE;
    }

    public LottoFinder finder(WinningNumber winningNumber){
        return new LottoFinder(lottos, winningNumber);
    }

    class LottoFinder {

        private final WinningNumber winningNumber;
        private Stream<Lotto> lottoStream;

        public LottoFinder(List<Lotto> lottos, WinningNumber winningNumber) {
            this.lottoStream = lottos.stream();
            this.winningNumber = winningNumber;
        }

        public List<Lotto> lottos(){
            return lottoStream.collect(Collectors.toList());
        }

        public LottoFinder findMatched(int matchedCount){
            lottoStream = find(it -> winningNumber.getMatchedWinningNumberCount(it) == matchedCount);
            return this;
        }

        public LottoFinder findMatchBonus(){
            lottoStream = find(it -> winningNumber.matchBonusNumber(it));
            return this;
        }

        public LottoFinder excludeMatchBonus() {
            lottoStream = find(it -> !winningNumber.matchBonusNumber(it));
            return this;
        }

        private Stream<Lotto> find(Predicate<Lotto> condition){
            return lottoStream.filter(condition);
        }

    }
}
