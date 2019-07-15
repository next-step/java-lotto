package lottogame.domain;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {
    private LottoRevenue lottoRevenue;
    private List<WinnerGroup> winnerGroup;

    public LottoRevenue getWinningRevenue() {
        return lottoRevenue;
    }
    public List<WinnerGroup> getWinnerGroup() {
        return winnerGroup;
    }

    // 로또 자동 생성 번호와 지난 당첨 번호를 비교하여 당첨 번호 갯수 확인
    public void getWinningResult(LottoGame lottoGame, WinningLottoNumber winningLottoNumber) {
        List<WinnerGroup> result = lottoGame.getLottoPrice().stream()
                .map(lottoNumber -> lottoNumber.compareWinningNumber(winningLottoNumber.getWinningNumber(), winningLottoNumber.bonusBall))
                .collect(Collectors.toList());

        makeWinnerGroupList(result);
        lottoRevenue = new LottoRevenue(calculatorRevenue(calculatorTotalWinningRevenue(), lottoGame.getPrice().getPrice()));
    }

    private void initializeWinnerGroupList() {
        winnerGroup = new ArrayList<>();
        Arrays.stream(LottoRankData.values())
                .map(value -> new WinnerGroup(value, 0))
                .forEach(element -> winnerGroup.add(element));
    }

    private void makeWinnerGroupList(List<WinnerGroup> resultList) {
        initializeWinnerGroupList();

        winnerGroup.forEach(element -> {
            resultList.stream().filter(result -> element.isEqualRankData(result.getRankData()))
                    .forEach(result -> element.addCount());
        });
    }

    private BigDecimal calculatorRevenue(double total, int lottoPrice) {
        return new BigDecimal(total / lottoPrice);
    }

    private int calculatorTotalWinningRevenue() {
        return winnerGroup.stream().mapToInt(WinnerGroup::getRevenue).sum();
    }
}
