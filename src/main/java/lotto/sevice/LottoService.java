package lotto.sevice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoRecord;
import lotto.domain.Rank;

public class LottoService {
    public static final int WON = 1000;

    public  LottoRecord lottoGame(final LottoList lottoList, final int[] winningNumbers, int bonusNumber){
        LottoRecord resultList = checkLotto(lottoList, winningNumbers, bonusNumber);
        resultList.calculatorProfit(lottoList.getLottoSize());
        
        return resultList;
    }

    public LottoList issueLotto(final int money){
        final int lottoSize = money/WON;
        LottoList lottoList = new LottoList().createLottoList(lottoSize);

        return lottoList;
    }

    public LottoRecord checkLotto(final LottoList lottoList, final int[] winningNumbers, int bonusNumber){

        final List<Integer> listA = Arrays.stream(winningNumbers).boxed().collect(Collectors.toList());

        List<int[]> listB = new ArrayList<>();
        lottoList.getLottoList().stream().map(Lotto::getLotto).forEach(listB::add);

        List<Integer> temp = new ArrayList<>();
        LottoRecord record = new LottoRecord();

        for (int i = 0; i < listB.size(); i++){
            List<Integer> union = new ArrayList<>();
            temp = Arrays.stream(listB.get(i)).boxed().collect(Collectors.toList());
            temp.stream().filter(e -> listA.contains(e)).forEach(union::add);
            boolean is2nd = classify2nd(temp, union.size(), bonusNumber);
            record = setRecord(record, union.size(), is2nd);
        }

        return record;
    }

    public LottoRecord setRecord(LottoRecord record, int result , boolean is2nd){
        if (result == 3) {
            record.setCountThree();
        }
        if (result == 4) {
            record.setCountFour();
        }
        if (result == 5 && is2nd == false) {
            record.setCountFive();
        }
        if (result == 5 && is2nd == true) {
            record.setcountFiveAndBonus();
        }
        if (result == 6) {
            record.setCountSix();
        }

        return record;
    }

    public boolean classify2nd(List<Integer> list, int size, int bonusNumber){
        boolean result = false;
        if (size == Rank.SECOND.getCountOfMatch()) {
            result = isMatchBounus(list, bonusNumber);
        }
        return result;
    }

    public boolean isMatchBounus(List<Integer> list, int bonusNumber){
        boolean result = false;
        if (list.stream().filter(e -> list.contains(bonusNumber)).findFirst().get() != null){
            result = true;
        }
        return result;
    }
    
}
