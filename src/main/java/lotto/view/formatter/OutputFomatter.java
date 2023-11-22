package lotto.view.formatter;

import java.util.List;
import java.util.stream.Collectors;
import lotto.common.Symbol;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoNumber;

public class OutputFomatter {

    public static final String MOVEMENT_MARK = Symbol.HYPHEN;
    public static final String WINNERS_SEPARATOR = Symbol.COMMA;

    public int toLottoCount(LottoCount lottoCount) {
        return lottoCount.getLottoCount();
    }

    public String toLotto(Lotto lotto) {
        List<LottoNumber> rawLottoNumbers = lotto.getLottoNumbers();
        List<String> lottoNumbers = rawLottoNumbers.stream()
                .map(lottoNumber -> lottoNumber.getLottoNumber() + "")
                .collect(Collectors.toList());
        return String.join(", ", lottoNumbers);
    }
}
