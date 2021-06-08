package lotto;

import java.util.ArrayList;
import java.util.Collections;
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

    public void addLotto(BuyingCount num) {
        if (lottoList == null) {
            lottoList = new ArrayList<>();
        }
        for (int i = 0; i < num.buyingCount(); i++) {
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
        if (idx >= this.lottoList.size() || idx < 0) {
            return Collections.emptyList();
        }
        return this.lottoList.get(idx).lottoNum();
    }

    public int getLottoSize() {
        return this.lottoList.size();
    }

}
