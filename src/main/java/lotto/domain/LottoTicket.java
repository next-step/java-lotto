package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LottoTicket {
    private List<Integer> lottoNumbers;

    public LottoTicket(){
        this.lottoNumbers = IntStream.range(1, 46).boxed().collect(Collectors.toList());;
        Collections.shuffle(this.lottoNumbers);
        this.lottoNumbers = this.lottoNumbers.subList(0,6);
    }

    public List<Integer> getSortedLottoNumbers(){
        Collections.sort(this.lottoNumbers);
        return this.lottoNumbers;
    }
}
