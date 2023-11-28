package step4.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutomaticLottoGenerator implements LottoGenerator {

    private static final List<LottoNumber> NUMBER_LIST = IntStream.range(1, 46)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final int count;

    public AutomaticLottoGenerator(final int automaticLottoCount) {
        this.count = automaticLottoCount;
    }

    @Override
    public List<UserLotto> generate() {
        List<UserLotto> userLottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Collections.shuffle(NUMBER_LIST);
            Set<LottoNumber> lottoNumbers = NUMBER_LIST.stream().limit(LOTTO_NUMBER_COUNT).collect(Collectors.toSet());
            userLottoList.add(new UserLotto(lottoNumbers));
        }
        return userLottoList;
    }
}
