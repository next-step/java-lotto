package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final int MAX_LOTTO_NUMBER = 45;
    private int numLottoTickets;
    private GenerateRule generateRule;

    public LottoGenerator(int numLottoTickets, GenerateRule generateRule) {
        this.numLottoTickets = numLottoTickets;
        this.generateRule = generateRule;
    }

    public LottoTicket generate(){
        generateRule.init();
        List<LottoNumber> temp = new ArrayList<LottoNumber>();
        for (int i=0; i<6; i++){
            temp.add(generateRule.generate());
        }
        return new LottoTicket(temp);
    }

    public List<LottoTicket> generateAll(){
        List<LottoTicket> result = new ArrayList<>();
        for (int i=0; i<numLottoTickets; i++){
            result.add(generate());
        }
        return result;
    }

}
