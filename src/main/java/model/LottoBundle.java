package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBundle {
    private List<List<Integer>> manualLottoNumbers;
    private List<List<Integer>> randomLottoNumbers;
    private LottoNumberGenerator lottoNumberGenerator;

    public LottoBundle(
            int totalPrice,
            LottoNumberGenerate lottoNumberGenerate
    ) {
        this(Collections.emptyList(), totalPrice, lottoNumberGenerate);
    }

    public LottoBundle(
            List<List<Integer>> manualLottoNumbers,
            int totalPrice,
            LottoNumberGenerate lottoNumberGenerate
    ) {
        this.manualLottoNumbers = manualLottoNumbers;
        this.lottoNumberGenerator = new LottoNumberGenerator(lottoNumberGenerate);
        this.randomLottoNumbers = this.lottoNumberGenerator.run(getCountOfRandomLottoNumbers(totalPrice));
    }

    private int getCountOfRandomLottoNumbers(int totalPrice) {
        return totalPrice / LottoMachine.PRICE_OF_A_LOTTO - this.manualLottoNumbers.size();
    }

    public int getCountOfRandomLottoNumbers() {
        return this.randomLottoNumbers.size();
    }

    public List<List<Integer>> getLottoNumbers() {
        List<List<Integer>> lottoNumbers = new ArrayList<>(this.manualLottoNumbers);
        lottoNumbers.addAll(this.randomLottoNumbers);
        return lottoNumbers;
    }
}
