package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static step2.Lotto.*;

public class Ticket {

    public static final int NUMBER_LIMIT = 6;

    private List<Integer> numbers;

    public Ticket(List<Integer> numbers){
        numbersCheck(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public static Ticket createTicket() {
        Collections.shuffle(lottoNumber);
        return new Ticket(new ArrayList<>(lottoNumber.subList(0, NUMBER_LIMIT)));
    }

    private static void numbersCheck(List<Integer> numbers) {
        System.out.println("numbers.size() = " + numbers.size());
        if(numbers.size() != NUMBER_LIMIT){
            throw new IllegalArgumentException("로또는 6개의 숫자여야합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isContainNumber(int num){
        return numbers.contains(num);
    }
}