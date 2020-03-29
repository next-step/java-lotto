package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoMachine {

    private static final Money DEFAULT_LOTTO_PRICE = Money.won(1000);
    private static final Random random = new Random();

    private LottoMachine() {}

    public static LottoTicket generateLottoTicket(Money inputMoney) {
        int lottoCount = inputMoney.divide(DEFAULT_LOTTO_PRICE.getAmount()).intValue();

        LottoTicket lottoTicket = new LottoTicket();
        for (int i = 0 ; i < lottoCount ; i++) {
            lottoTicket.add(LottoNumbers.valueOf(generateRandomNumbers()));
        }

        return lottoTicket;
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbersBetween1And45 = generateNumbersBetween1And45();
        List<Integer> randomNumbersBetween1And45 = new ArrayList<>();

        for (int i = 0 ; i < LottoNumbers.LOTTO_SIZE ; i++) {
            int randIdx = random.nextInt(numbersBetween1And45.size());
            randomNumbersBetween1And45.add(numbersBetween1And45.get(randIdx));
            numbersBetween1And45.remove(randIdx);
        }

        return randomNumbersBetween1And45;
    }

    private static List<Integer> generateNumbersBetween1And45() {
        List<Integer> from1To45 = new ArrayList<>();
        for (int i = LottoNumber.LOWER ; i <= LottoNumber.UPPER ; i++) {
            from1To45.add(i);
        }
        return from1To45;
    }


}
