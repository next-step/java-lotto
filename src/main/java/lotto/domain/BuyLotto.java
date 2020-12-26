package lotto.domain;

import lotto.util.LottoNumberGenerator;
import lotto.dto.RequestDTO;

import java.util.List;
import java.util.Map;

public class BuyLotto {
    private final RequestDTO requestDTO;

    private final LottoTicket lottoTicket = new LottoTicket();

    public BuyLotto(int money) {
        requestDTO = new RequestDTO(money);

        makeAmountLottoNumbers();
    }

    public int getMoney() {
        return this.requestDTO.getMoney();
    }

    public int getTotalAmount() {
        return this.requestDTO.getTotalAmount();
    }

    private void makeAmountLottoNumbers() {
        for (int amount = 0; amount < requestDTO.getTotalAmount(); amount++) {
            lottoTicket.addLottoNumbers(new Lotto(LottoNumberGenerator.makeLottoNumber()));
        }
    }

    public List<Lotto> getLotto() {
        return lottoTicket.getLottoNumbers();
    }

    public Map<Rank, List<Rank>> getMatchLottoCount(List<Integer> targetNumbers, int bonusNumber) {
        return lottoTicket.getMatchLottoCount(targetNumbers, bonusNumber);
    }
}
