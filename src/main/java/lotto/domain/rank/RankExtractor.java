package lotto.domain.rank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.WinningNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public class RankExtractor {

    public static List<Rank> getRanks(List<Lotto> lottos, WinningNumber winningNumber) {
        List<Rank> ranks = new ArrayList<>();

        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers().stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());

            ranks.add(winningNumber.compareTo(lottoNumbers));
        }

        return ranks;
    }
}
