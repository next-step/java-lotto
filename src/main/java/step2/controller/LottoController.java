package step2.controller;

import step2.domain.dto.LottoDTO;
import step2.service.LottoService;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public List<LottoDTO> buyLotto(int fee) {
        return lottoService.buyLotto(fee)
                .stream()
                .map(lotto -> LottoDTO.createLottoDTO(lotto))
                .collect(Collectors.toList());
    }

    public void initWinNumbers(String winNumberString) {
        lottoService.initWinNumbers(winNumberString);
    }

    public List<Long> findLottoResult() {
        return lottoService.findLottoResult();
    }

    public double findBenefit() {
        return lottoService.findBenefit();
    }
}
