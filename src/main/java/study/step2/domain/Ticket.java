package study.step2.domain;

import java.util.List;

public class Ticket {
    private List<Integer> numbers;

    private Ticket(List<Integer> numbers){
        this.numbers = numbers;
    }

    public static Ticket from(List<Integer> numbers) {
        return new Ticket(numbers);
    }

    public List<Integer> getTicket(){
        return numbers;
    }
}
