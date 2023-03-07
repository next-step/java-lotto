package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoObject {
    private List<Integer> lottoNumbers;

    public LottoObject(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoObject() {
        this.lottoNumbers = new ArrayList<>();
    }

    public void setLottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }
    public void add(Integer lottoNumber) {
        lottoNumbers.add(lottoNumber);
    }

    @Override
    public String toString() {
        Collections.sort(lottoNumbers);
        return String.valueOf(lottoNumbers);
    }

    public LottoType contains(List<Integer> abd, int bonusNumber) {
        int answer = 0;
        int bonusAnswer = 0;
        for(Integer value : abd ){
            if(lottoNumbers.contains(value)){
                answer++;
            }
        }

        if(lottoNumbers.contains(bonusNumber)){
            bonusAnswer++;
        }
        return LottoType.of(answer,bonusAnswer);
    }
}
