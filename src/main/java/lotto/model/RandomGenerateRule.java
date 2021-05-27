package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomGenerateRule implements GenerateRule{
    private LottoTicket candidateNumbers;
    private int cursor;

    public RandomGenerateRule() {
        this.cursor = 0;
        this.candidateNumbers = CandidateLottoGenerator.generate().shuffle();
    }

    @Override
    public void init(){
        this.cursor = 0;
        this.candidateNumbers.shuffle();
    }

    @Override
    public LottoNumber generate() {
        return candidateNumbers.get(cursor++);
    }

    public LottoTicket generateTicket(int size) throws Exception {
        if(size < 0 || size > 45){
            throw new Exception("can not generate ticker");
        }
        List<LottoNumber> lottoTicket = new ArrayList<>();
        for (int i=0; i<size; i++ ){
            lottoTicket.add(generate());
        }
        return new LottoTicket(lottoTicket);
    }

}
