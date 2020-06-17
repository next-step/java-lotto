package step4.domain.lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    public static final int LOTTO_MAX_LIMIT = 45;
    public static final int LOTTO_DRAW_LIMIT = 6;
    public static final int LOTTO_DRAW_BASE_NUMBER = 0;
    public static final String FIXED_DELIMITER = ",|:";

    // default 1 to LOTTO_MAX_LIMIT (45)
    private static final List<Integer> lottoGameNumbers = IntStream.rangeClosed(1, LOTTO_MAX_LIMIT)
            .boxed()
            .collect(Collectors.toList());

    // issue
    public static LottoTickets issueLotto(Integer boughtLottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < boughtLottoCount; i++) {
            lottoList.add(auto());
        }
        return new LottoTickets(lottoList);
    }

    public static void checkLottoRules(Set<Integer> lottoNumbers) {
        if (Collections.max(lottoNumbers) > LOTTO_MAX_LIMIT) {
            throw new IllegalArgumentException();
        }
        if (lottoNumbers.size() != LOTTO_DRAW_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> drawLottoNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.subList(LOTTO_DRAW_BASE_NUMBER, LOTTO_DRAW_LIMIT);
    }

    private static Lotto auto() {
        Collections.shuffle(lottoGameNumbers);
        // pick LOTTO_DRAW_LIMIT
        return new Lotto(new TreeSet<>(drawLottoNumbers(lottoGameNumbers)));
    }

}
