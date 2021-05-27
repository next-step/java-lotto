package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final int LOTTO_DIGIT_SIZE = 6;
    private int numLottoTickets;
    private GenerateRule generateRule;

    public LottoGenerator(int numLottoTickets, GenerateRule generateRule) {
        this.numLottoTickets = numLottoTickets;
        this.generateRule = generateRule;
    }

    public LottoTicket generate(){
        generateRule.init();
        List<LottoNumber> temp = new ArrayList<LottoNumber>();
        for (int i=0; i<LOTTO_DIGIT_SIZE; i++){
            temp.add(generateRule.generate());
        }
        return new LottoTicket(temp);
    }

    public List<LottoTicket> generateBulk(){
        List<LottoTicket> result = new ArrayList<>();
        for (int i=0; i<numLottoTickets; i++){
            result.add(generate());
        }
        return result;
    }

}
