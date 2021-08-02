package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private List<Lotto> lottoList = new ArrayList<>();

    public static LottoList create() {
        return new LottoList();
    }

    public int getSize() {
        return lottoList.size();
    }

    public void buyLotto(LottoMachine machine) {
        this.lottoList.add(machine.makeLotto());
    }

    public Lotto getLotto(int idx) {
        if (idx > lottoList.size()) {
            throw new IllegalArgumentException(String.format("입력한 인덱스(%d) 가 리스트 사이즈를 초과하엿습니다.", idx));
        }
        return this.lottoList.get(idx);
    }

    public List<Lotto> getAll() {
        return lottoList;
    }
}
