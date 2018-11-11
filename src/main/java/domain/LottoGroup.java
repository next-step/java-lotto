package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGroup {
    private List<Lotto> lottoGroup;

    public LottoGroup(List<Lotto> lottoGroup) {
        if (lottoGroup == null) {
            throw new NullPointerException();
        }
        if (lottoGroup.size() < 0) {
            throw new IllegalArgumentException("배열이 없습니다.");
        }
        this.lottoGroup = lottoGroup;
    }

    public LottoGroup(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
        this.lottoGroup = lottos;
    }

    public List<Lotto> getLottoGroup() {
        return lottoGroup;
    }

    public int getSize() {
        return lottoGroup.size();
    }

}
