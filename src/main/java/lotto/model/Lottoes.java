package lotto.model;

import lotto.strategy.AutoStrategy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottoes {

    private List<CandidateLotto> lottoes;
    private int lottoCount;


    public Lottoes(int amount) {
        this.lottoCount = getLottoCount(amount);
        this.lottoes = buyLottoes();
    }

    public Lottoes(int amount, List<CandidateLotto> lottoes){
        this.lottoCount = getLottoCount(amount);
        if(isInvalid(lottoes)){
            throw new IllegalArgumentException("가지고 있는 액수보다 구입한 로또가 많습니다.");
        }
        this.lottoes = lottoes;
    }

    public int getLottoCount() {
        return lottoCount;
    }


    public List<SortedSet<Integer>> getLottoes() {
        return lottoes.stream()
                .map(CandidateLotto::getNumbers)
                .collect(Collectors.toList());
    }

    private List<CandidateLotto> buyLottoes() {
        return IntStream.range(0, lottoCount)
                .mapToObj(e -> new CandidateLotto(new AutoStrategy()))
                .collect(Collectors.toList());
    }


    private int getLottoCount(int amount) {
        return amount / CandidateLotto.PRICE;
    }

    private boolean isInvalid(List<CandidateLotto> lottoes){
        return this.lottoCount < lottoes.size();
    }
}
