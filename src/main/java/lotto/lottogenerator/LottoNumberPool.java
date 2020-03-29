package lotto.lottogenerator;

import lotto.model.LottoNumbers;
import lotto.model.MyLottos;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberPool {
    private static List<LottoNumbers> myLottoNumbers = new ArrayList<>();

    public static MyLottos generateLottoAsMuchAs(int autoLottoCount){
        generateAutomatically(autoLottoCount);
        return new MyLottos(myLottoNumbers);
    }

    private static void generateAutomatically(int autoLottoCount) {
        for(int i = 0; i < autoLottoCount ; i++){
            myLottoNumbers.add(new LottoNumbers(LottoNumGeneratorByAuto.generate()));
        }
    }
}