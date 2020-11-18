package controller;

import domain.Lotto;
import domain.LottoInfo;
import domain.LottoNumbers;
import domain.Lottos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    private LottoInfo lottoInfo;

    public LottoController() {
    }

    public LottoController(LottoInfo lottoInfo) {
        this.lottoInfo = lottoInfo;
    }

    public LottoController(int price) {
        lottoInfo = LottoInfo.from(price);
    }

    public Lottos initLottos() {
        List<Lotto> lottoList = IntStream
                .range(0, lottoInfo.getQuantity())
                .mapToObj(quantity -> Lotto.createLotto())
                .collect(Collectors.toList());
        return Lottos.from(lottoList);
    }

    public int getLottoQuantity() {
        return lottoInfo.getPrice() / 1000;
    }

    public int matchLottoNumbers(LottoNumbers winningLotto, Lotto lotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        List<Integer> lottoNumbers = lotto.getLottoNumbers().getNumbers();

        return (int) lottoNumbers
                .stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public Map<Integer, Integer> compileLottoStatistics(LottoNumbers winningLotto, Lottos lottos) {
        List<Integer> matches = lottos.getLottos()
                .stream()
                .map(lotto -> matchLottoNumbers(winningLotto, lotto))
                .filter(match -> match >= 3)
                .collect(Collectors.toList());

        Map<Integer, Integer> matchMap = new HashMap<>();
        matches.forEach(match -> matchMap.merge(match, 1, Integer::sum));
        return matchMap;
    }
}
