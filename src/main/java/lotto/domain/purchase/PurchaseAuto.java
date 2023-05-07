package lotto.domain.purchase;

import static lotto.domain.Lotto.LOTTO_NUMBER_COUNT;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class PurchaseAuto implements PurchaseStrategy {

    public static final List<LottoNumber> LOTTO_NUMBER_LIST = IntStream.rangeClosed(
            LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
        .boxed()
        .map(LottoNumber::new)
        .collect(Collectors.toList());
    private static final PurchaseAuto INSTANCE = new PurchaseAuto();

    private PurchaseAuto() {
    }

    public static PurchaseAuto instance() {
        return INSTANCE;
    }

    @Override
    public Lotto purchase() {
        return newInstance(LOTTO_NUMBER_LIST);
    }

    protected Lotto newInstance(List<LottoNumber> lottoNumbers) {
        return autoLotto(subList(shuffled(lottoNumbers)));
    }

    private Lotto autoLotto(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private List<LottoNumber> subList(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.subList(0, LOTTO_NUMBER_COUNT);
    }

    private List<LottoNumber> shuffled(List<LottoNumber> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }

}
