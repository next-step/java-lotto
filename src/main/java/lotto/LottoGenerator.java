package lotto;

import java.util.*;

public class LottoGenerator {
    private static final int LOTTO_SIZE = 6;
    private static final Random random = new Random();

    public static List<LottoTicket> generate(int price) {
        int ticketCount = price / LottoTicket.PRICE;
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(generateTicket());
        }
        return tickets;
    }

    private static LottoTicket generateTicket() {
        Set<LottoNumber> numbers = new HashSet<>();
        while (numbers.size() < LOTTO_SIZE) {
            int randomValue = random.nextInt(LottoNumber.MAX) + LottoNumber.MIN;
            LottoNumber number = LottoNumber.of(randomValue);
            numbers.add(number);
        }
        return new LottoTicket(numbers);
    }
}
