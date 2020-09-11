package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberGenerator {

    public static final int FIRST_NUMBER = 1;
    public static final int LAST_NUMBER = 45;
    public static final int INT_ZERO = 0;
    public static final int INT_SIX = 6;

    private List<LottoNo> lottoNumberCandidate;

    public NumberGenerator() {
        lottoNumberCandidate = createLottoNumberCandidate();
    }

    private List<LottoNo> createLottoNumberCandidate() {
        return IntStream.rangeClosed(FIRST_NUMBER, LAST_NUMBER)
                .mapToObj(e->new LottoNo(e))
                .collect(Collectors.toList());
    }

    public Set<LottoNo> generate() {
        Collections.shuffle(lottoNumberCandidate);

        List<LottoNo> numList = new ArrayList<>(lottoNumberCandidate)
                .subList(INT_ZERO, INT_SIX);

        Set<LottoNo> lotto = new HashSet<>(numList);

        return lotto;
    }
}
