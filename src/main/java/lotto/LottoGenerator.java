package lotto;

import java.util.Random;

public class LottoGenerator {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final Random random = new Random();

    public static LottoTicket generate() {
        int[] numbers = new int[LOTTO_SIZE];
        for (int i = 0; i < LOTTO_SIZE; i++) {
            numbers[i] = random.nextInt(MAX) + MIN;
        }
        return new LottoTicket(numbers);
    }
}
