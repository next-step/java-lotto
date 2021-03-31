package study.step4.domain;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import study.step4.util.StringUtil;

public class LottoFactory {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private static List<LottoNumber> allLottoNumbers = new ArrayList<>();

    static {
        IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER + 1)
            .forEach(i -> allLottoNumbers.add(LottoNumber.of(i)));
    }

    private static Lotto createAutoLotto() {
        Collections.shuffle(allLottoNumbers);
        return new Lotto(allLottoNumbers.stream()
            .limit(LOTTO_SIZE)
            .collect(Collectors.toList()));
    }

    private static Lotto createManualLotto(String lottoNumbers) {
        return new Lotto(Arrays.stream(StringUtil.split(lottoNumbers))
            .map(i -> LottoNumber.of(i))
            .collect(toList()));
    }

    public static Lottos buy(LottoTicketCount lottoTicketCount, List<String> manualNumbers) {
        Lottos autoLottos = buyAutoLotto(lottoTicketCount);
        Lottos manualLottos = buyManualLotto(manualNumbers);

        return new Lottos(Stream.concat(manualLottos.getLottos().stream(), autoLottos.getLottos().stream())
            .collect(Collectors.toList()));
    }

    public static Lottos buyAutoLotto(LottoTicketCount lottoTicketCount) {
        Lottos lottoList = new Lottos();
        int count = lottoTicketCount.getLottoTicketCount();
        for (int i = 0; i < count; i++) {
            lottoList.add(createAutoLotto());
        }
        return lottoList;
    }

    public static Lottos buyManualLotto(List<String> stringNumbers) {
        Lottos lottoList = new Lottos();
        for (int i = 0; i < stringNumbers.size(); i++) {
            lottoList.add(createManualLotto(stringNumbers.get(i)));
        }
        return lottoList;
    }
}
