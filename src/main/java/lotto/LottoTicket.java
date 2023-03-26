package lotto;

import lotto.domain.LottoRandomPicker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    private Set<LottoNumber> lottoNumbers;
    private LottoResult lottoResult;
    public static final int PRICE = 1000;
    public static final int NUMBERS = 6;

    public LottoTicket(){
        this.lottoNumbers = new HashSet<>();
    }
    public LottoTicket(Set<LottoNumber> lottoNumberSet){
        this.lottoNumbers = lottoNumberSet;
    }

    public static boolean canBuyTicket(int num){
        if(num > PRICE){
            return true;
        }
        return false;
    }

    public void pickAuto(){
        while(lottoNumbers.size() < NUMBERS){
            lottoNumbers.add(new LottoNumber(LottoRandomPicker.pickLottoNumber()));
        }
    }

    public boolean isInLottoNumber(LottoNumber num){
        for (LottoNumber lottoNumber : this.lottoNumbers) {
            return lottoNumber.equals(num);
        }
        return false;
    }

    public Set<LottoNumber> getLottoNumbers(){
        return lottoNumbers;
    }
    public LottoResult getLottoResult(){
        return lottoResult;
    }

    public List<Integer> toIntegerList(){
        List<Integer> list = new ArrayList<>();
        for(LottoNumber lottoNumber : lottoNumbers){
            list.add(lottoNumber.getNum());
        }
        return list;
    }


    //3개 일치 (5000원)- 1개 - 5등
    //4개 일치 (50000원)- 0개 - 4등
    //5개 일치 (1500000원)- 0개 - 3등
    //5개 일치, 보너스 볼 일치(30000000원) - 0개 - 2등?
    //6개 일치 (2000000000원)- 0개 - 1등?
    public void markResult(int matchCount, boolean matchBouns){
        if(matchCount == 6){
            lottoResult = LottoResult.FIRST;
            return;
        }
        if(matchCount == 5 && matchBouns){
            lottoResult = LottoResult.SECOND;
            return;
        }
        if(matchCount == 5){
            lottoResult = LottoResult.THIRD;
            return;
        }
        if(matchCount == 4){
            lottoResult = LottoResult.FOURTH;
            return;
        }
        if(matchCount == 3){
            lottoResult = LottoResult.FIFTH;
            return;
        }
        lottoResult = LottoResult.NONE;
    }


}
