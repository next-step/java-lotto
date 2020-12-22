package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Lotto {
    private final List<LottoNumbers> lottoNumbers;

    public Lotto() {
        this.lottoNumbers = new ArrayList<>();
    }

    public List<LottoNumbers> getLottoNumbers() {
        return lottoNumbers;
    }

    /**
     * 로또 생성 번호 추가
     * @param lottoNumbers 로또 생성 번호
     */
    public void addLottoNumbers(LottoNumbers lottoNumbers) {
        this.lottoNumbers.add(lottoNumbers);
    }

    /**
     * 번호 비교
     * @param target 지난주 당첨 번호
     * @return List<Match>
     */
    public List<Match> getMatch(List<Integer> target) {
        return lottoNumbers.stream()
                .map(numbers -> Match.getMatchInfo(numbers.getEqualCount(target)))
                .collect(Collectors.toList());
    }

    /**
     * 생성된 로또번호와 지난주 당첨번호 비교 후 등급에 속한 리스트 반환
     * @param targetNumbers 지난주 당첨 번호
     * @return Map<Match, List<Match>>
     */
    public Map<Match, List<Match>> getMatchLottoCount(List<Integer> targetNumbers) {
        return getMatch(targetNumbers).stream()
                .filter(r -> r != Match.MISS)
                .sorted(Comparator.comparingLong(Match::getMatchCount))
                .collect(groupingBy(rank -> rank, Collectors.toList()));
    }
}
