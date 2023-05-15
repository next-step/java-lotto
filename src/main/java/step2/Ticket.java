package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static step2.Lotto.*;

public class Ticket {

    public static final int NUMBER_LIMIT = 6;
    private List<Integer> numbers;

    public Ticket() {
        createTicket();
    }

    private List<Integer> createTicket() {

        Collections.shuffle(lottoNumber);
        numbers = new ArrayList<>(lottoNumber.subList(0,6));
        Collections.sort(numbers);

        return numbers;
    }

    public Ticket(List<Integer> numbers){
        numbersCheck(numbers);
        this.numbers = numbers;
    }

    private static void numbersCheck(List<Integer> numbers) {
        if(numbers.size() != NUMBER_LIMIT){
            throw new IllegalArgumentException("로또는 6개의 숫자여야합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}