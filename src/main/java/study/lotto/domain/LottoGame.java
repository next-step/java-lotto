package study.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private Lottos lottos;
    private LottoIssuer lottoIssuer;
    private Amount investmentAmount;

    public LottoGame(Amount amount, LottoIssuer lottoIssuer) {
        this.lottoIssuer = lottoIssuer;
        generateLottoTicket(amount);
    }

    public LottoGame(int amount, LottoIssuer lottoIssuer) {
        this(new Amount(amount), lottoIssuer);
    }

    private void generateLottoTicket(Amount amount) {
        int quantity = amount.getValue() / Lotto.PRICE;

        investmentAmount = new Amount(quantity * Lotto.PRICE);
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoList.add(lottoIssuer.issue());
        }

        this.lottos = new Lottos(lottoList);
    }

    public Lottos getLottos() {
        return new Lottos(lottos);
    }

    public LottoResult result(LottoWinningNumber lottoWinningNumber) {
        WinningLottos winningLottos = lottos.ranks(lottoWinningNumber);
        return new LottoResult(winningLottos, investmentAmount);
    }
}
