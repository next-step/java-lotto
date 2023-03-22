package lotto.domain;

import lotto.view.LottoMessage;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumbers {
    private static int LOTTO_NUMBER_MAX = 6;
    private Set<LottoNumber> lottoNumberList;

    public LottoNumbers(Set<LottoNumber> lottoNumberList) {
        this.lottoNumberList = lottoNumberList;
        numberListCheck(lottoNumberList);
    }

    public Set<LottoNumber> getLottoNumber() {
        return lottoNumberList;
    }

    private void numberListCheck(Set<LottoNumber> lottoNumberList) {
        final Set<Integer> InputLottoNumbers = new HashSet<>();
        for (LottoNumber lottoNumber : lottoNumberList) {
            InputLottoNumbers.add(lottoNumber.getNumber());
        }
        lottoNumberCheck(InputLottoNumbers);
    }

    private void lottoNumberCheck(Set<Integer> checkLottoNumber) {
        if (checkLottoNumber.size() != LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("로또 번호 중복 발생");
        }
    }

    public void bonusNumberCheck(LottoNumber bonusNumber) {
        for(LottoNumber lottoNumber : lottoNumberList){
            if(lottoNumber.getNumber() == bonusNumber.getNumber()){
                throw new IllegalArgumentException("보너스 번호 중복 발생");
            }
        }
    }
}
