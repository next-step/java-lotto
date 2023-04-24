package lotto.Model;

public class Ticket {
    private static final int TICKET_SIZE = 6;
    private final int[] numbers;

    public Ticket(int[] numbers) {
        if (numbers.length != TICKET_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        this.numbers = numbers;
    }

    public int[] numbers() {
        return numbers;
    }
}
