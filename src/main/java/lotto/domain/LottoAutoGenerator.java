package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoAutoGenerator {

    private static final Random random = new Random();

    private LottoAutoGenerator() {
    }

    public static LottoTicket generateAutoLottoTicket(int lottoCount) {
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
        List<Integer> candidates = new ArrayList<>();
        for (int i = LottoNumber.LOWER; i <= LottoNumber.UPPER; i++) {
            candidates.add(i);
        }
        return candidates;
    }


}
