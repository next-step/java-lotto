package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoService {
    private int lottoCount;

    public int buyLotto(int price) {
        this.lottoCount = price/1000;
        return lottoCount;
    }

    public List<LottoTicket> generateAutoLotto(int lottoCount) {
        return Arrays.asList(new LottoTicket(), new LottoTicket());
        //return new ArrayList<LottoTicket>(new LottoTicket(), new LottoTicket());
    }
}
