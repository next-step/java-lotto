package lotto.domain.rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.WinningNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoRepository;

public class RankRepository {

    private final List<Rank> ranks;

    private RankRepository(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public static RankRepository getRanksOf(LottoRepository lottoManager, WinningNumber winningNumber) {
        List<Rank> ranks = new ArrayList<>();

        for (Lotto lotto : lottoManager.getLottos()) {
            List<Integer> lottoNumbers = lotto.getNumbers().stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());

            ranks.add(winningNumber.compareTo(lottoNumbers));
        }

        return new RankRepository(ranks);
    }

    public List<Rank> getRanks() {
        return Collections.unmodifiableList(ranks);
    }
}
