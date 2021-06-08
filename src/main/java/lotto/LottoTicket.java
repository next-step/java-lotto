package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private List<Lotto> lottoList;

    public LottoTicket(int num) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            lottoList.add(new Lotto());
        }
    }

    public LottoTicket(List<Lotto> lottoList) {
        if (lottoList == null) {
            lottoList = new ArrayList<>();
        }
        this.lottoList = lottoList;
    }

    public void addLotto(int num) {
        if (num < 1) {
            throw new RuntimeException("로또는 하나이상 추가해야합니다.");
        }
        if (lottoList == null) {
            lottoList = new ArrayList<>();
        }
        for (int i = 0; i < num; i++) {
            lottoList.add(new Lotto());
        }
    }

    public List<Lotto> lottoList() {
        return lottoList;
    }

    public void compareWinList(WinningLotto winningLotto, LottoNumber bonusNumber) {
        List<LottoNumber> winList = winningLotto.value();
        for (Lotto lotto : lottoList) {
            lotto.calculateLottoWin(winList, bonusNumber);
        }
    }

    public List<LottoNumber> getLottoNumWithIdx(int idx) {
        return this.lottoList.get(idx).lottoNum();
    }

    public int getLottoSize() {
        return this.lottoList.size();
    }

}
