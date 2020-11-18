package lotto.model;

import lotto.strategy.AutoDrawing;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottoes {

    private List<Lotto> lottoes;
    private int lottoCount;
    private int amount;

    public Lottoes(int amount) {
        this.amount = amount;
        this.lottoCount = getLottoCount(amount);
        this.lottoes = buyLottoes();
    }

    public Lottoes(int amount, List<Lotto> lottoes){
        this.amount = amount;
        this.lottoCount = getLottoCount(amount);
        if(isInvalid(lottoes)){
            throw new IllegalArgumentException("가지고 있는 액수보다 구입한 로또가 많습니다.");
        }
        this.lottoes = lottoes;
    }

    public int getLottoCount() {
        return lottoCount;
    }


    public List<List<Integer>> getLottoes() {
        return lottoes.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }


    public Map<Hit, Integer> getResult(List<Integer> winnerNumbers) {
        Map<Hit, Integer> hits = Hit.getHits();
        lottoes.stream()
                .map(lotto -> lotto.getMatchingNumberCount(winnerNumbers))
                .map(Hit::findByHitCount)
                .forEach(hit -> hits.computeIfPresent(hit, (Hit key, Integer value) -> ++value));
        return hits;
    }


    public double getEarningRate(List<Integer> winnerNumbers) {
        int totalReword = getResult(winnerNumbers).entrySet().stream()
                .mapToInt(this::calculateReword)
                .sum();

        return Math.floor(((double) totalReword / amount) * 100) / 100;
    }


    private int calculateReword(Map.Entry<Hit, Integer> e) {
        return e.getKey().calculateReword(e.getValue());
    }


    private List<Lotto> buyLottoes() {
        return IntStream.range(0, lottoCount)
                .mapToObj(e -> new Lotto(new AutoDrawing()))
                .collect(Collectors.toList());
    }


    private int getLottoCount(int amount) {
        return amount / Lotto.PRICE;
    }

    private boolean isInvalid(List<Lotto> lottoes){
        return this.lottoCount < lottoes.size();
    }
}
