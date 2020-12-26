package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class LottoTicket {
    private final List<Lotto> lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = new ArrayList<>();
    }

    public List<Lotto> getLottoNumbers() {
        return lottoNumbers;
    }

    /**
     * 로또 생성 번호 추가
     * @param lotto 로또 생성 번호
     */
    public void addLottoNumbers(Lotto lotto) {
        this.lottoNumbers.add(lotto);
    }

    /**
     * 번호 비교
     * @param target 지난주 당첨 번호
     * @return List<Match>
     */
    public List<Rank> getMatch(List<Integer> target, boolean isBonus) {
        return lottoNumbers.stream()
                .map(numbers -> Rank.valueOf(numbers.getEqualCount(target), isBonus))
                .collect(Collectors.toList());
    }

    /**
     * 생성된 로또번호와 지난주 당첨번호 비교 후 등급에 속한 리스트 반환
     * @param targetNumbers 지난주 당첨 번호
     * @return Map<Match, List<Match>>
     */
    public Map<Rank, List<Rank>> getMatchLottoCount(List<Integer> targetNumbers, int bonusNumber) {
        boolean isBonus = targetNumbers.stream().anyMatch(number -> bonusNumber == number);

        return getMatch(targetNumbers, isBonus).stream()
                .filter(r -> r != Rank.MISS)
                .sorted(Comparator.comparingLong(Rank::getCountOfMatch))
                .collect(groupingBy(rank -> rank, Collectors.toList()));
    }
}
