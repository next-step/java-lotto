package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    private List<Lotto> lottos;

    public LottoController() {
        this.lottos = new ArrayList<>();
    }

    public LottoController(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void buy(int money) {
        List<Lotto> newLottos = makeLottos(money);

        lottos.clear();
        lottos.addAll(newLottos);
    }

    private List<Lotto> makeLottos(int money) {
        List<Integer> numbers = makeLottoRandomNumbers();
        int count = money / Lotto.PRICE;

        return IntStream.range(0, count)
                .mapToObj(value -> new Lotto(new HashSet<>(numbers.subList(0, 6))))
                .collect(Collectors.toList());
    }

    private List<Integer> makeLottoRandomNumbers() {
        List<Integer> numbers = IntStream.range(1, 46)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);

        return numbers;
    }


    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoGameResult play(Set<Integer> winningNumbers, int bonus) {
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);
        Map<LottoRank, Long> lottoRanks = getLottoRanks(winningLotto);
        double profitRatio = getProfitRatio(lottoRanks);

        return new LottoGameResult(
                lottoRanks.getOrDefault(LottoRank.FIRST, 0L),
                lottoRanks.getOrDefault(LottoRank.SECOND, 0L),
                lottoRanks.getOrDefault(LottoRank.THIRD, 0L),
                lottoRanks.getOrDefault(LottoRank.FOURTH, 0L),
                lottoRanks.getOrDefault(LottoRank.FIFTH, 0L),
                profitRatio
        );
    }

    private double getProfitRatio(Map<LottoRank, Long> lottoRanks) {
        long sum = lottoRanks.entrySet().stream()
                .mapToLong(lottoRankLongEntry -> lottoRankLongEntry.getKey().getPrice() * lottoRankLongEntry.getValue())
                .sum();
        return ((double) sum) / (lottos.size() * Lotto.PRICE);
    }

    private Map<LottoRank, Long> getLottoRanks(WinningLotto winningLotto) {
        return lottos.stream()
                .map(lotto -> lotto.match(winningLotto))
                .collect(Collectors.groupingBy(
                        rank -> rank,
                        Collectors.counting()
                ));
    }
}