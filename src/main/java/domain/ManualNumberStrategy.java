package domain;

import java.util.ArrayList;
import java.util.List;

public class ManualNumberStrategy implements PickNumberStrategy {

    List<LottoNumber> lottoNumbers = new ArrayList<>();

    public ManualNumberStrategy(int[] lottoNumber) {
        for (int number : lottoNumber) {
            lottoNumbers.add(new LottoNumber(number));
        }
    }

    @Override
    public List<LottoNumber> makeLottoNumber() {
        return lottoNumbers;
    }

}
