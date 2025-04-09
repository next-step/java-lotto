package domain;

import java.util.List;
import java.util.stream.Collectors;

import static domain.LottoGenerator.DRAW_NUMBER_COUNT;

public class Lotto {
    public static final int PRICE_PER_ONE = 1000;

    private final List<LottoNumber> lottoNumberList;
    private Rank rank;

    public Lotto(List<Integer> lottoNumberList) {
        if (lottoNumberList == null || lottoNumberList.isEmpty()) {
            throw new IllegalArgumentException("numList가 null이거나 비어있을수 없습니다.");
        }

        if (lottoNumberList.size() != DRAW_NUMBER_COUNT) {
            throw new IllegalArgumentException("numList의 size가 잘못되었습니다. numList.size() : " + lottoNumberList.size());
        }

        this.lottoNumberList = convertLottoNumberList(lottoNumberList);
    }

    public Lotto(List<Integer> lottoNumberList, WinningNumbers winningNumbers) {
        this(lottoNumberList);
        this.matchRank(winningNumbers);
    }


    public List<LottoNumber> getLottoNumberList() {
        return lottoNumberList;
    }

    public static List<LottoNumber> convertLottoNumberList(List<Integer> lottoNumberList) {
        return lottoNumberList.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    public void matchRank(WinningNumbers winningNumbers) {
        int countOfMatch = this.getMatchCount(winningNumbers);
        boolean matchBonus = this.isMatchBonus(winningNumbers.getBonusNumber());

        this.rank = Rank.valueOf(countOfMatch, matchBonus);
    }

    private boolean isMatchBonus(BonusNumber bonusNumber) {
        return lottoNumberList.contains(bonusNumber.getLottoNumber());
    }

    private int getMatchCount(WinningNumbers winningNumbers) {
        return (int) this.lottoNumberList.stream()
            .filter(winningNumbers::isMatch)
            .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumberList.contains(lottoNumber);
    }


    public Rank getRank() {
        return rank;
    }
}
