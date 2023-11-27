package step4.domain.lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ManualLottoGenerator implements LottoGenerator {

    private final List<Set<LottoNumber>> lottoNumbers;

    public ManualLottoGenerator(final List<Set<LottoNumber>> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public List<UserLotto> generate() {
        return lottoNumbers.stream().map(UserLotto::new).collect(Collectors.toList());
    }
}
