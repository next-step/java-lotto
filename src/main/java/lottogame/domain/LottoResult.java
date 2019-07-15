package lottogame.domain;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {
    private final static int EXIST_COUNT = 1;

    private LottoRevenue lottoRevenue;
    private List<WinnerGroup> winnerGroups;

    public LottoRevenue getWinningRevenue() {
        return lottoRevenue;
    }

    public List<WinnerGroup> getWinnerGroups() {
        return winnerGroups;
    }

    // 로또 자동 생성 번호와 지난 당첨 번호를 비교하여 당첨 번호 갯수 확인
    public void getWinningResult(LottoGame lottoGame, WinningLottoNumber winningLottoNumber) {
        List<WinnerGroup> result = lottoGame.getLottoPrice().stream()
                .map(lottoNumber -> lottoNumber.compareWinningNumber(winningLottoNumber.getWinningNumber(), winningLottoNumber.bonusBall))
                .collect(Collectors.toList());

        makeWinnerGroups(result);
        lottoRevenue = new LottoRevenue(calculatorRevenue(calculatorTotalWinningRevenue(), lottoGame.getPrice().getPrice()));
    }

    public LottoRankData findWinnerData() {
        return winnerGroups.stream()
                .filter(winner -> winner.getCount() == EXIST_COUNT)
                .findAny()
                .orElse(null)
                .getRankData();
    }

    private void initializeWinnerGroups() {
        winnerGroups = new ArrayList<>();
        for (LottoRankData value : LottoRankData.values()) {
            WinnerGroup element = new WinnerGroup(value, 0);
            winnerGroups.add(element);
        }
    }

    private void makeWinnerGroups(List<WinnerGroup> resultList) {
        initializeWinnerGroups();

        winnerGroups.forEach(element -> {
            for (WinnerGroup result : resultList) {
                if (element.isEqualRankData(result.getRankData())) {
                    element.addCount();
                }
            }
        });
    }

    private BigDecimal calculatorRevenue(double total, int lottoPrice) {
        return new BigDecimal(total / lottoPrice);
    }

    private int calculatorTotalWinningRevenue() {
        return winnerGroups.stream().mapToInt(WinnerGroup::getRevenue).sum();
    }
}
