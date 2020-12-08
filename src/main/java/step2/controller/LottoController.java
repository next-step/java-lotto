package step2.controller;

import step2.domain.LottoRank;
import step2.domain.LottoStore;
import step2.domain.dto.LottoDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoController {

    private LottoStore lottoStore;

    public LottoController() {
        this.lottoStore = new LottoStore();
    }

    public void initWinNumbers(List<Integer> winningNumbers) {
        lottoStore.initWinNumbers(winningNumbers);
    }

    public Map<LottoRank, Integer> findLottoResult() {
        return lottoStore.findWinLottoMoney();
    }

    public BigDecimal findBenefit() {
        return lottoStore.findBenefit();
    }

    public void addBonusNumber(int bonusNumber) {
        lottoStore.addBonusNumber(bonusNumber);
    }

    public List<LottoDTO> buyLotto(int fee, List<List<Integer>> notAutoNumbers) {
        return lottoStore.buy(fee, notAutoNumbers)
                .stream()
                .map(lotto -> LottoDTO.from(lotto))
                .collect(Collectors.toList());
    }
}
