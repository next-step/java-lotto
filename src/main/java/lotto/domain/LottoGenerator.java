package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoGenerator {

    private static final Money DEFAULT_LOTTO_PRICE = Money.won(1000);
    private static final Random random = new Random();

    private LottoGenerator() {
    }

    public static LottoTicket generateLottoTicket(Money inputMoney) {
        int lottoCount = inputMoney.divide(DEFAULT_LOTTO_PRICE.getAmount()).intValue();

        LottoTicket lottoTicket = new LottoTicket();
        for (int i = 0; i < lottoCount; i++) {
            lottoTicket.add(LottoNumbers.valueOf(generateRandomNumbers()));
        }

        return lottoTicket;
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> candidateNumbers = generateCandidates();
        List<Integer> chosenNumbers = new ArrayList<>();

        for (int i = 0; i < LottoNumbers.LOTTO_SIZE; i++) {
            int randIdx = random.nextInt(candidateNumbers.size());
            chosenNumbers.add(candidateNumbers.get(randIdx));
            candidateNumbers.remove(randIdx);
        }

        return chosenNumbers;
    }

    private static List<Integer> generateCandidates() {
        List<Integer> from1To45 = new ArrayList<>();
        for (int i = LottoNumber.LOWER; i <= LottoNumber.UPPER; i++) {
            from1To45.add(i);
        }
        return from1To45;
    }


}
