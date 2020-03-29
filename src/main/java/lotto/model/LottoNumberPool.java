package lotto.model;

import lotto.lottogenerator.LottoNumGeneratorByAuto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberPool {
    private static List<LottoNumbers> myLottoNumbers = new ArrayList<>();

    public static MyLottos getMyLottos(int autoLottoCount) {
        generateAutomatically(autoLottoCount);
        return new MyLottos(myLottoNumbers);
    }

    private static void generateAutomatically(int autoLottoCount) {
        for (int i = 0; i < autoLottoCount; i++) {
            myLottoNumbers.add(new LottoNumbers(LottoNumGeneratorByAuto.generate()));
        }
    }
}