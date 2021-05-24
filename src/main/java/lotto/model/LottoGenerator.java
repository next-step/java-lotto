package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGenerator {
    private final int MAX_LOTTO_NUMBER = 45;
    private GenerateRule generateRule;

    public LottoGenerator(GenerateRule generateRule) {
        this.generateRule = generateRule;
    }

    public LottoNumbers generate(){
        List<LottoNumber> temp = new ArrayList<LottoNumber>();
        for (int i=0; i<6; i++){
            temp.add(generateRule.generate());
        }
        return new LottoNumbers(temp);
    }
}
