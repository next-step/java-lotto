package Lotto.model;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static Lotto.LottoConstant.LOTTO_MAX_NUMBER;
import static Lotto.LottoConstant.LOTTO_MIN_NUMBER;

public class LottoNumberCreateMachine {
    private static final int PROPER_LOTTONUMBER_COUNT = 6;

    private final List<LottoNumber> allLottoNumbers;

    public LottoNumberCreateMachine() {
        this.allLottoNumbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).mapToObj(LottoNumber::new).collect(Collectors.toList());
    }

    public Lottos createLottos(LottoBuyResource lottoBuyResource,Lottos manualLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoBuyResource.getAutoLottoCount(); i++) {
            Lotto lotto = new Lotto(this.pick());
            lottos.add(lotto);
        }
        manualLottos.addLottos(lottos);
        return manualLottos;
    }

    public Lotto getLuckyNumbers(List<String> numbers) {
        return new Lotto(numbers.stream()
                .map(it -> new LottoNumber(Integer.parseInt(it)))
                .collect(Collectors.toList()));
    }
    private List<LottoNumber> pick() {
        Collections.shuffle(allLottoNumbers);
        List<LottoNumber> lotto = new ArrayList<>(allLottoNumbers.subList(0, PROPER_LOTTONUMBER_COUNT));
        Collections.sort(lotto);
        return lotto;
    }
}
