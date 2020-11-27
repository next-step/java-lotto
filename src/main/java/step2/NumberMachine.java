package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberMachine implements Machine{
    private static final List<Integer> numbers = new ArrayList<>();

    public void setNumber(String inputNumber){
        for(int i = 1; i <= 45; i++){
            numbers.add(i);
        }
    }

    public List<Integer> getLottoNumbers(){
        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = numbers.subList(0,6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
