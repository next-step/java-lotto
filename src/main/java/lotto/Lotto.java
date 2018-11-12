package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//로또 한줄 구하는 객체
public class Lotto {
    private static final int LOTTO_MAX_COUNT=45;
    private List<Integer> numbers;

    public Lotto(){
        numbers = new ArrayList<Integer>();
        for(int i=0;i<LOTTO_MAX_COUNT;i++){
            numbers.add(i+1);
        }

    }
    public List<Integer> generateLottoNumber(){
        shuffleNumbers();
        return sortNumbers(pickSixNumbers());
    }

    public List<Integer> pickSixNumbers(){
        List<Integer> resultNumbers = new ArrayList<Integer>();
        for(int i=0;i<6;i++){
            resultNumbers.add(numbers.get(i));
        }
        return resultNumbers;
    }

    public void shuffleNumbers(){
        Collections.shuffle(numbers);

    }

    public List<Integer> sortNumbers(List<Integer> numbers){
        Collections.sort(numbers);
        return numbers;

    }
}
