package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.enums.LottoResultType;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public boolean sameSize(int expectSize){
        return lottos.size() == expectSize;
    }

    public LottoResult result(Lotto resultLotto) {
        Map<LottoResultType,Lottos> result  = new HashMap<>();
        for (LottoResultType lottoResultType : LottoResultType.values()) {
            List<Lotto> matchLottos = lottoResultType.result(this.lottos, resultLotto);
            result.put(lottoResultType, Lottos.of(matchLottos));
        }
        // 5개 일치를 찾고
        // 5개 일치 중에 보너스 번호가 -> 보너스 번호는
        // LottoResultType.NO_MATCH 결과 삭제 로직 추가
        return LottoResult.defaultOf(result);
    }
    public double calculatePrice(LottoResultType lottoResultType) {
        int count = this.lottos.size();
        return lottoResultType.calculatePrice(count);
    }

    public int size() {
        return this.lottos.size();
    }

    public  List<String> toStringStatus() {

        List<String> lottoStatusList = new ArrayList<>();
        for (Lotto lotto : this.lottos) {
            StringBuilder stringBuilder = new StringBuilder();
            String lottoStatus = stringBuilder.append(lotto.toStringStatus()).toString();
            lottoStatusList.add(lottoStatus);
        }
        return lottoStatusList;
    }

    public Lottos findBonusLottos(LottoNumber bonusLottoNumber) {
        List<Lotto> bonusMatchLottos = this.lottos.stream()
            .filter(each -> each.equals(bonusLottoNumber))
            .collect(Collectors.toList());
        return Lottos.of(bonusMatchLottos);
        }
}
