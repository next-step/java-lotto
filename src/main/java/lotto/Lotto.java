package lotto;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//로또 한줄 구하는 객체
public class Lotto {
    private static final int LOTTO_MAX_COUNT = 45;
    private static final int LOTTO_NUMBER = 6;
    private List<Integer> numbers;
    private List<Integer> lotto;

    public Lotto(){
        numbers = new ArrayList<>();
        for(int i = 0; i < LOTTO_MAX_COUNT; i++){
            numbers.add(i+1);
        }
    }
    public Lotto(Integer[] oneTicket){
        lotto = Arrays.asList(oneTicket);
    }

    public void generateLottoNumber(){
        shuffleNumbers();
        lotto = sortNumbers(pickSixNumbers());
    }

    public List<Integer> pickSixNumbers(){
        List<Integer> resultNumbers = new ArrayList<>();
        for(int i = 0; i < LOTTO_NUMBER; i++){
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

    public boolean isContains(int num){
        return this.lotto.contains(num);
    }

    public String makeString(String delimeter){
        return StringUtils.join(this.lotto, ",");
    }

}
