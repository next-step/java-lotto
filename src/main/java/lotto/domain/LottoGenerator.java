package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_MINIMUM = 1;
    private static final int LOTTO_NUMBER_MAXIMUM = 45;
    private static final int LOTTO_TICKET_SIZE = 6;

    private static final List<LottoNumber> lottoNumbers = IntStream.rangeClosed(LOTTO_NUMBER_MINIMUM, LOTTO_NUMBER_MAXIMUM)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    private LottoGenerator() {
    }

    public static LottoTickets issue(int totalLottoCount, List<List<Integer>> manualNumbers) {
        int autoLottoCount = calculateAutoLottoCount(totalLottoCount, manualNumbers);

        List<List<LottoNumber>> autoLottoNumbers = generateAutoLottoNumbers(autoLottoCount);
        List<List<LottoNumber>> manualLottoNumbers = manualNumbers.stream()
                .map(LottoGenerator::toLottoNumbers)
                .collect(Collectors.toList());

        manualLottoNumbers.addAll(autoLottoNumbers);
        return LottoTickets.of(manualLottoNumbers);
    }

    private static int calculateAutoLottoCount(int totalLottoCount, List<List<Integer>> manualNumbers) {
        return totalLottoCount - manualNumbers.size();
    }

    private static List<LottoNumber> toLottoNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private static List<List<LottoNumber>> generateAutoLottoNumbers(int autoCount) {
        return IntStream.range(0, autoCount)
                .mapToObj(i -> generateAutoLottoNumber())
                .collect(Collectors.toList());
    }

    private static List<LottoNumber> generateAutoLottoNumber() {
        Collections.shuffle(lottoNumbers, new Random(System.currentTimeMillis()));
        return new ArrayList<>(lottoNumbers.subList(0, LOTTO_TICKET_SIZE));
    }
}
