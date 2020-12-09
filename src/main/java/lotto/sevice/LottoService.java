package lotto.sevice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoRecord;

public class LottoService {
    public static final int WON = 1000;

    public  LottoRecord lottoGame(final LottoList lottoList, final int[] winningNumbers){
        LottoRecord resultList = checkLotto(lottoList, winningNumbers);
        resultList.calculatorProfit(lottoList.getLottoList().size());
        
        return resultList;
    }

    public LottoList issueLotto(final int money){
        List<Lotto> tempList = new ArrayList<>();
        final int lottoSize = money/WON;

        for(int i = 0; i < lottoSize; i++){
            Lotto lotto = new Lotto();
            tempList.add(lotto);
        }
        LottoList lottoList = new LottoList(tempList);

        return lottoList;
    }

    public LottoRecord checkLotto(final LottoList lottoList, final int[] winningNumbers){

        final List<Integer> listA = Arrays.stream(winningNumbers).boxed().collect(Collectors.toList());

        List<int[]> listB = new ArrayList<>();
        lottoList.getLottoList().stream().map(Lotto::getLotto).forEach(listB::add);

        List<Integer> temp = new ArrayList<>();
        LottoRecord record = new LottoRecord();

        for (int i = 0; i < listB.size(); i++){
            List<Integer> union = new ArrayList<>();
            temp = Arrays.stream(listB.get(i)).boxed().collect(Collectors.toList());
            temp.stream().filter(e -> listA.contains(e)).forEach(union::add);
            record = setRecord(record, union.size());
        }

        return record;
    }

    public LottoRecord setRecord(LottoRecord record, int result){
        if(result == 3){
            record.setCountThree();
        }
        if(result == 4){
            record.setCountFour();
        }
        if(result == 5){
            record.setCountFive();
        }
        if(result == 6){
            record.setCountSix();
        }

        return record;
    }
    
}
