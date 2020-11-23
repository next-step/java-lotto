package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberMaker {

    public static List<Integer> makeNumber(){
        List<Integer> wholeNumbers = new ArrayList<>();
        for(int i=1;i<=45;i++){
            wholeNumbers.add(i);
        }
        Collections.shuffle(wholeNumbers);

        List<Integer> pickNumbers = wholeNumbers.subList(0,5);
        Collections.sort(pickNumbers);
        return pickNumbers;
    }

}
