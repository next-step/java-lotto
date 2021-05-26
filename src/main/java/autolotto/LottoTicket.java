package autolotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private List<Lotto> lottoList;
    private LottoStatistics lottoStatistics = new LottoStatistics();

    public LottoTicket(int num) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            lottoList.add(new Lotto());
        }
    }

    public List<Lotto> lottoList() {
        return lottoList;
    }

    public LottoStatistics lottoStatistics() {
        return lottoStatistics;
    }

    public void calculateWinList(int[] winList) {
        for (int i = 0; i < lottoList.size(); i++) {
            lottoStatistics.collectWin(lottoList.get(i).countWin(winList));
        }
    }
}
