package step5.lotto;

import java.util.*;
import java.util.stream.IntStream;

public class LottoTicket {
    private static final int LOTTO_START_DIGIT = 0;
    private static final int LOTTO_END_DIGIT = 6;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final List<Integer> DEFAULT_NUMBERS = new ArrayList<>();

    static {
        IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .boxed().distinct().forEach(DEFAULT_NUMBERS::add);
    }

    private final Set<LottoNumber> lottoTicket;

    public LottoTicket() {
        lottoTicket = new TreeSet<>();
        createAutoLottoNumbers();
    }

    public LottoTicket(Set<Integer> winningNumbers) {
        lottoTicket = new TreeSet<>();
        createWinningLottoNumbers(winningNumbers);
    }

    private void createAutoLottoNumbers() {
        Collections.shuffle(DEFAULT_NUMBERS);
        for (int i = LOTTO_START_DIGIT; i < LOTTO_END_DIGIT; i++) {
            this.lottoTicket.add(new LottoNumber(DEFAULT_NUMBERS.get(i)));
        }
    }
    private void createWinningLottoNumbers(Set<Integer> numbers) {
        for (int number: numbers) {
            this.lottoTicket.add(new LottoNumber(number));
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        List<LottoNumber> list = new ArrayList<>();
        Iterator<LottoNumber> it = this.lottoTicket.iterator();
        while (it.hasNext()) {
            list.add(it.next());
        }
        return list;
    }

    public List<Integer> getLottoNumberList() {
        List<Integer> list = new ArrayList<>();
        Iterator<LottoNumber> it = this.lottoTicket.iterator();
        while (it.hasNext()) {
            list.add(it.next().getLottoNumber());
        }
        return list;
    }

    public int isContainNumber(LottoNumber number) {
        if (lottoTicket.contains(number)) {
            return ONE;
        }
        return ZERO;
    }
}
