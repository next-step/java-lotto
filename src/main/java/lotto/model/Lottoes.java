package lotto.model;

import lotto.strategy.AutoDrawing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottoes {
    private List<Lotto> lottoes;
    private int lottoCount;


    public Lottoes(int amount){
        this.lottoCount = getLottoCount(amount);
        this.lottoes = buyLottoes();
    }


    public int getLottoCount() {
        return lottoCount;
    }


    public List<List<Integer>> getLottoes(){
        return lottoes.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }


    private List<Lotto> buyLottoes(){
        return IntStream.range(0, lottoCount)
                .mapToObj(e -> new Lotto(new AutoDrawing()))
                .collect(Collectors.toList());
    }


    private int getLottoCount(int amount){
        return amount/Lotto.PRICE;
    }
}
