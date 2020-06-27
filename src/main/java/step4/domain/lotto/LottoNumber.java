package step4.domain.lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable {

    public static final int LOTTO_MAX_LIMIT = 45;
    public static final int LOTTO_DRAW_LIMIT = 6;
    public static final int LOTTO_DRAW_BASE_NUMBER = 0;
    public static final String FIXED_DELIMITER = ",|:";

    // default 1 to LOTTO_MAX_LIMIT (45)
    private static final List<LottoNumber> lottoGameNumbers;

    private final int lottoNumber;

    static {
        lottoGameNumbers = IntStream.rangeClosed(1, LOTTO_MAX_LIMIT)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public LottoNumber(int lottoNumber) {
        checkLottoRules(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(int index) {
        checkLottoRules(index);
        return lottoGameNumbers.stream()
                .filter(x -> x.getLottoNumber() == index)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    // issue
    public static LottoTickets issueLotto(Integer boughtLottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < boughtLottoCount; i++) {
            lottoList.add(auto());
        }
        return new LottoTickets(lottoList);
    }

    public static void checkLottoRules(Collection<LottoNumber> lottoNumbers) {
        if (Collections.min(lottoNumbers).getLottoNumber() < 1) {
            throw new IllegalArgumentException();
        }
        if (Collections.max(lottoNumbers).getLottoNumber() > LOTTO_MAX_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkLottoRules(int input) {
        if (input > LOTTO_MAX_LIMIT || input < 1) {
            throw new IllegalArgumentException();
        }
    }

    public static List<LottoNumber> drawLottoNumbers(List<LottoNumber> lottoNumbers) {
        checkLottoRules(lottoNumbers);
        return lottoNumbers.subList(LOTTO_DRAW_BASE_NUMBER, LOTTO_DRAW_LIMIT);
    }

    private static Lotto auto() {
        Collections.shuffle(lottoGameNumbers);
        // pick LOTTO_DRAW_LIMIT
        return new Lotto(new TreeSet<>(drawLottoNumbers(lottoGameNumbers)));
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public int compareTo(Object o) {
        if (this.lottoNumber == ((LottoNumber) o).getLottoNumber()) {
            return 0;
        }
        return ((LottoNumber) o).getLottoNumber() > this.lottoNumber ? -1 : 1;
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "lottoNumber=" + lottoNumber +
                '}';
    }
}
