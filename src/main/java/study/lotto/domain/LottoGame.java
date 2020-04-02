package study.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private List<Lotto> lottos;
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
        int quantity = amount.getAmount() / Lotto.PRICE;

        investmentAmount = new Amount(quantity * Lotto.PRICE);
        lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(lottoIssuer.issue());
        }
    }

    public List<Lotto> getLottos() {
        return lottos.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    public LottoResult result(LottoWinningNumber lottoWinningNumber) {
        return new LottoResult(lottos,
                lottoWinningNumber,
                investmentAmount);
    }
}
