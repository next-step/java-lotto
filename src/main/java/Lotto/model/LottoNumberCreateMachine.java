package Lotto.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberCreateMachine {
    private static final int PROPER_LOTTONUMBER_COUNT = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public Lottos createLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(this.pick());
            lottos.add(lotto);
        }
        Lottos result = new Lottos(lottos);
        return result;
    }

    public Lotto getLuckyNumbers(List<String> numbers) {
        return new Lotto(numbers.stream()
                .map(it -> new LottoNumber(Integer.parseInt(it)))
                .collect(Collectors.toList()));
    }

    private List<LottoNumber> pick() {
        final List<LottoNumber> allLottoNumbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).mapToObj(LottoNumber::new).collect(Collectors.toList());
        Collections.shuffle(allLottoNumbers);
        List<LottoNumber> lotto = new ArrayList<>(allLottoNumbers.subList(0, PROPER_LOTTONUMBER_COUNT));
        Collections.sort(lotto);
        return lotto;
    }
}
