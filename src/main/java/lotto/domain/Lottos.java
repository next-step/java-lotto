package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(LottoPrice lottoPrice, List<String> manualLotto) {
        this.lottos = generateLottos(lottoPrice.calculateLottoNumber() - manualLotto.size());
        addManualLotto(manualLotto);
    }

    public void addManualLotto(List<String> manualLotto) {
        manualLotto.forEach(lotto -> lottos.add(new Lotto(Arrays.stream(lotto.split(", "))
            .map(lottoNumber -> new LottoNumber(Integer.parseInt(lottoNumber)))
            .collect(Collectors.toSet()))));
    }

    private List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottoLists = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoLists.add(LottoNumberGenerator.generate());
        }
        return lottoLists;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
