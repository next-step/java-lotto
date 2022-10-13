package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.model.LottoNumber.initializeLottoNumbers;

public class LottoMachine implements LottoFactory {

    private Lotto createLotto() {
        List<LottoNumber> lottoNumberList = initializeLottoNumbers();
        Collections.shuffle(lottoNumberList);

        List<LottoNumber> createdLotto = lottoNumberList.subList(0, 6);
        Collections.sort(createdLotto);

        return new Lotto(createdLotto);
    }

    @Override
    public List<Lotto> create(int purchasedCount) {
        return IntStream.rangeClosed(1, purchasedCount)
                .mapToObj(v -> createLotto())
                .collect(Collectors.toList());
    }
}
