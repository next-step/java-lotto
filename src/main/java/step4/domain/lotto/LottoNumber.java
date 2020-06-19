package step4.domain.lotto;

import step4.domain.PurchaseInfo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    public static final int LOTTO_MAX_LIMIT = 45;
    public static final int LOTTO_DRAW_LIMIT = 6;
    public static final int LOTTO_DRAW_BASE_NUMBER = 0;
    public static final String FIXED_DELIMITER = ",|:";

    // default 1 to LOTTO_MAX_LIMIT (45)
    private static List<LottoNo> lottoGameNumbers = new ArrayList<>();

    static {
        List<Integer> numbers645 = IntStream.rangeClosed(1, LOTTO_MAX_LIMIT)
                .boxed()
                .collect(Collectors.toList());
        for (Integer integer : numbers645) {
            lottoGameNumbers.add(new LottoNo(integer));
        }
    }

    // issue
    public static LottoTickets issueLotto(Integer boughtLottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < boughtLottoCount; i++) {
            lottoList.add(auto());
        }
        return new LottoTickets(lottoList);
    }

    public static void checkLottoRules(Set<LottoNo> lottoNumbers) {
        if (Collections.max(lottoNumbers).getLottoNo() > LOTTO_MAX_LIMIT) {
            throw new IllegalArgumentException();
        }
        if (lottoNumbers.size() != LOTTO_DRAW_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    public static List<LottoNo> drawLottoNumbers(List<LottoNo> lottoNumbers) {
        return lottoNumbers.subList(LOTTO_DRAW_BASE_NUMBER, LOTTO_DRAW_LIMIT);
    }

    private static Lotto auto() {
        Collections.shuffle(lottoGameNumbers);
        // pick LOTTO_DRAW_LIMIT
        return new Lotto(new TreeSet<>(drawLottoNumbers(lottoGameNumbers)));
    }

}
