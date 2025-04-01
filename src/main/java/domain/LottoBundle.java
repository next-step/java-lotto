package domain;

import java.util.List;

import static domain.LottoGenerator.DRAW_NUMBER_COUNT;

public class LottoBundle {
    private final List<Lotto> lottoList;
    private final LottoStatics lottoStatics;

    public LottoBundle(List<Lotto> lottoList, List<Integer> winningNums, BonusNumber bonusNumber) {
        if (winningNums == null || winningNums.isEmpty()) {
            throw new IllegalArgumentException("winningNums는 null이거나 비어있을 수 없습니다.");
        }

        if (winningNums.size() != DRAW_NUMBER_COUNT) {
            throw new IllegalArgumentException("winningNums의 사이즈가 잘못되었습니다. winningNums.size() : " + winningNums.size());
        }

        this.lottoList = lottoList;
        this.matchRank(winningNums, bonusNumber);
        this.lottoStatics = new LottoStatics(lottoList);
    }

    public LottoStatics getLottoStatics() {
        return lottoStatics;
    }

    private void matchRank(List<Integer> winningNums, BonusNumber bonusNumber){
        for(Lotto lotto : lottoList){
            lotto.matchRank(winningNums, bonusNumber);
        }
    }
}
