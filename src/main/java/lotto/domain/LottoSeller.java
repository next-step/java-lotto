package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LottoSeller implements Seller {
    private final LottoCount lottoCount;

    public LottoSeller(LottoCount lottoCount) {
        this.lottoCount = lottoCount;
    }

    @Override
    public Lottos generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        int presentLottoCount = 0;
        while (lottoCount.isLessThanCount(presentLottoCount)) {
            lottos.add(generateLotto());
            presentLottoCount++;
        }
        return new Lottos(lottos);
    }

    public Lotto generateLotto() {
        Set<Integer> lottoNumbers = new HashSet<>();
        boolean isValidLotto = true;
        int presentLottoNumberCount = 0;
        while (isValidLotto && presentLottoNumberCount < 6) {
            int lottoNumber = new Random().nextInt(45) + 1; // 테스트 위해 랜덤 클래스로 빼서 주입 시키기
            isValidLotto = lottoNumbers.add(lottoNumber);
            presentLottoNumberCount++;
        }
        List<Integer> lotto = new ArrayList<>(lottoNumbers);
        Collections.sort(lotto);
        return Lotto.from(lotto);
    }
}
