package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoList {

    private List<Lotto> lottoList;

    private int[] winningNumbers;
    
    private int bonusNumber;

    public List<Lotto> getLottoList(){
        return lottoList;
    }

    public int getLottoSize(){
        return lottoList.size();
    }

    public int[] getWinningNumbers(){
        return winningNumbers;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }

    public void setWinningNumbers(int[] winningNumbers){
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(int bonusNumber){
        validateBonusNumber(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validateBonusNumber(int[] winningNumbers, int bonusNumber){
        Arrays.stream(winningNumbers)
                .forEach(n -> {
                    if (n == bonusNumber){
                        throw new IllegalArgumentException(String.format("%s는 중복되는 번호입니다.", n));
                    }
                });

    }

    public LottoList createLottoList(int size){
        List<Lotto> tempList = new ArrayList<>();
        for(int i = 0; i < size; i++){
            Lotto lotto = new Lotto().createLotto();
            tempList.add(lotto);
        }
        LottoList lottoList = new LottoList(tempList);
        return lottoList;
    }

    public LottoList(List<Lotto> winningList){
        this.lottoList = winningList;
    }

    public LottoList(){
    }
    
}