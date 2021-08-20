package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final List<LottoNumber> lottoNumbersPool = new ArrayList<>();

    static {
        IntStream.rangeClosed(1, 45)
                .forEach(number -> lottoNumbersPool.add(new LottoNumber(number)));
    }

    private LottoGenerator() {
    }

    private static List<Lotto> createRandomLottos(int ticketNumber) {
        List<Lotto> lottoList = new ArrayList<>();
        IntStream.range(0, ticketNumber)
                .forEach(idx -> lottoList.add(new Lotto(createLottoNumbers())));
        return lottoList;
    }

    private static Set<LottoNumber> createLottoNumbers() {
        Collections.shuffle(lottoNumbersPool);
        return lottoNumbersPool.stream()
                .limit(6)
                .collect(Collectors.toSet());
    }

    private static List<Lotto> createManualLottos(List<Set<Integer>> manualLottoNumbers) {
        List<Lotto> lottoList = new ArrayList<>();
        for (Set<Integer> numberSet: manualLottoNumbers){
            lottoList.add(new Lotto(numberSet.stream().map(number -> new LottoNumber(number))
                    .collect(Collectors.toSet())));
        }
        return lottoList;
    }

    public static List<Lotto> createLottos(List<Set<Integer>> manualLottoNumbers, int totalTicketNumber) {
        int manualTicketNumber = manualLottoNumbers.size();
        if(manualTicketNumber > totalTicketNumber){
            throw new IllegalArgumentException("수동 로또의 갯수가 총 개수보다 많습니다. 수동 로또 개수 : " + manualTicketNumber);
        }

        int randomTicketNumber = totalTicketNumber - manualTicketNumber;

        List<Lotto> lotto = new ArrayList<>();
        lotto.addAll(createManualLottos(manualLottoNumbers));
        lotto.addAll(createRandomLottos(randomTicketNumber));

        return lotto;
    }
}
