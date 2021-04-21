package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateLotto {

    List<Integer> lottoNumbers;

    public GenerateLotto() {
        this.lottoNumbers = new ArrayList<>();
        for (int i=1; i<=45 ; i++) {
            this.lottoNumbers.add(i);
        }
    }

    public List<Integer> generateAuto(){

        Collections.shuffle(this.lottoNumbers);
        ArrayList autoLottoNumber = new ArrayList();
        for(int i = 0; i< 6; i++) {
            autoLottoNumber.add(this.lottoNumbers.get(i));
        }
        Collections.sort(autoLottoNumber);
        return autoLottoNumber;
    }

}
