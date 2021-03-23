package step2.domain;

import step2.domain.lotto.LottoList;
import step2.domain.lotto.WinningLotto;
import step2.domain.price.PriceList;
import step2.dto.JudgeResponseDTO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Judge {

    public JudgeResponseDTO calculateResult(LottoList lottoList, WinningLotto winningLotto) {
        List<Integer> matchCountList = matchCountList(lottoList, winningLotto);
        List<Boolean> matchBonusList = matchBonusList(lottoList, winningLotto);
        PriceList priceList = new PriceList(matchCountList, matchBonusList);
        Map<String, Integer> priceMap = priceList.priceMap();
        Map<String, Integer> priceCountMap = priceList.countMap();
        double profitIndex = priceList.getProfitIndex();
        return new JudgeResponseDTO(priceMap, priceCountMap, profitIndex);
    }

    private List<Boolean> matchBonusList(LottoList lottoList, WinningLotto winningLotto) {
        return lottoList.getLottos()
                .stream()
                .map(winningLotto::matchBonus)
                .collect(Collectors.toList());
    }

    private List<Integer> matchCountList(LottoList lottoList, WinningLotto winningLotto) {
        return lottoList.getLottos()
                .stream()
                .map(winningLotto::matchCount)
                .collect(Collectors.toList());
    }

}
