package refactoringlotto.domain;

import refactoringlotto.random.LottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AllRoundLottoNumbers {
    private List<LottoNumbers> lottoNumbersList = new ArrayList<>();

    public static AllRoundLottoNumbers initAllRoundLottoNumbers(LottoGenerator lottoGenerator, int tryCount) {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            lottoNumbersList.add(new LottoNumbers(lottoGenerator.executeStrategy()));
        }
        return new AllRoundLottoNumbers(lottoNumbersList);
    }

    public AllRoundLottoNumbers(List<LottoNumbers> lottoNumbersList) {
        this.lottoNumbersList = lottoNumbersList;
    }

    public List<List<Integer>> totalRoundLottoNumberList() {
        List<List<Integer>> totalNumbersList = new ArrayList<>();
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            totalNumbersList.add(lottoNumbers.convertIntLottoNumbersList());
        }
        return totalNumbersList;
    }

    public List<Integer> lottoRankList(LottoNumbers winningLottoNumbers) {
        return lottoNumbersList.stream()
                .mapToInt(lottoNumbers -> winningLottoNumbers.lottoRank(lottoNumbers.getLottoNumberList()))
                .filter(lottoRank -> lottoRank > 0 && lottoRank < 5)
                .boxed().collect(Collectors.toList());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllRoundLottoNumbers that = (AllRoundLottoNumbers) o;
        return Objects.equals(lottoNumbersList, that.lottoNumbersList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumbersList);
    }
}
