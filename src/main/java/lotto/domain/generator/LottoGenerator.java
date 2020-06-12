package lotto.domain.generator;

import lotto.domain.data.LottoNumber;
import lotto.domain.data.LottoNumberPool;
import lotto.domain.data.ManualLotto;
import lotto.domain.data.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator implements Generator {

    @Override
    public List<Lotto> generate(int autoCount, List<ManualLotto> manualLottos) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(manualLottoGenerate(manualLottos));
        lottos.addAll(autoLottoGenerator(autoCount));
        return lottos;
    }

    private List<LottoNumber> createRandomLottoNumbers() {
        List<LottoNumber> lottoNumberAll = LottoNumberPool.getAll();
        Collections.shuffle(lottoNumberAll);
        return lottoNumberAll.stream().limit(Lotto.LOTTO_NUMBER_COUNT).collect(Collectors.toList());
    }

    private List<Lotto> autoLottoGenerator(int autoLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0 ; i < autoLottoCount ; i++) {
            lottos.add(Lotto.of(createRandomLottoNumbers()));
        }
        return lottos;
    }

    private List<Lotto> manualLottoGenerate(List<ManualLotto> manualLottos) {
        final List<Lotto> lottos = new ArrayList<>();

        if(manualLottos == null) {
            return lottos;
        }

        List<ManualLotto> targetManualLottos = manualLottos.stream()
                .filter(manualLotto -> !manualLotto.isEmpty())
                .collect(Collectors.toList());
        for (ManualLotto manualLotto : targetManualLottos) {
            lottos.add(Lotto.of(manualLotto.getNumbers()));
        }

        return lottos;
    }
}
