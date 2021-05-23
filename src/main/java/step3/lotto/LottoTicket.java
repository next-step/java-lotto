package step3.lotto;

import java.util.*;
import java.util.stream.IntStream;

public class LottoTicket {
    private static final int LOTTO_START_DIGIT = 0;
    private static final int LOTTO_END_DIGIT = 6;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final List<Integer> DEFAULT_NUMBERS = new ArrayList<>();

    static {
        IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .boxed().distinct().forEach(DEFAULT_NUMBERS::add);
    }

    private final Set<LottoNumber> lottoTicket;

    public LottoTicket() {
        lottoTicket = new TreeSet<>();
        createLottoRandomNumbers();
        insertLottoRandomNumbers();
    }

    public LottoTicket(List<Integer> winningNumbers) {
        lottoTicket = new TreeSet<>();
        insertLottoWinningNumbers(winningNumbers);
    }

    private void createLottoRandomNumbers() {
        Collections.shuffle(DEFAULT_NUMBERS);
    }

    private void insertLottoRandomNumbers() {
        for (int i = LOTTO_START_DIGIT; i < LOTTO_END_DIGIT; i++) {
            this.lottoTicket.add(new LottoNumber(DEFAULT_NUMBERS.get(i)));
        }
    }

    private void insertLottoWinningNumbers(List<Integer> numbers) {
        for (int i = LOTTO_START_DIGIT; i < LOTTO_END_DIGIT; i++) {
            this.lottoTicket.add(new LottoNumber(numbers.get(i)));
        }
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> list = new ArrayList<>();
        Iterator<LottoNumber> it = this.lottoTicket.iterator();
        while (it.hasNext()) {
            list.add(it.next().getLottoNumber());
        }
        return list;
    }

    public Iterator<LottoNumber> iteratorLottoTicket() {
        return this.lottoTicket.iterator();
    }
}
