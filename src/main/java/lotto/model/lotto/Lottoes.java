package lotto.model.lotto;

import lotto.model.CandidateLotto;
import lotto.strategy.AutoStrategy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottoes {

    private List<CandidateLotto> lottoes = new LinkedList<>();
    private int autoLottoCount;

    public Lottoes(int autoLottoCount, Optional<List<CandidateLotto>> lottoes){
        this.lottoes.addAll(lottoes.orElse(Collections.emptyList()));
        this.autoLottoCount = autoLottoCount;
        this.lottoes.addAll(buyLottoes());
    }


    public List<LottoTicket> getLottoes() {
        return lottoes.stream()
                .map(CandidateLotto::getLottoTicket)
                .collect(Collectors.toList());
    }

    private List<CandidateLotto> buyLottoes() {
        return IntStream.range(0, autoLottoCount)
                .mapToObj(e -> new CandidateLotto(new AutoStrategy()))
                .collect(Collectors.toList());
    }
}
