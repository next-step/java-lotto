package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManualLotto {
    private static final String DUPLICATE_MANUAL_LOTTO_MESSAGE ="중복된 로또 번호입니다";
    private final List<LottoNumber> manualLottoNumbers;

    public ManualLotto(List<LottoNumber> manualLottoNumbers) {
        checkDuplicateLottoNumber(manualLottoNumbers);
        this.manualLottoNumbers = manualLottoNumbers;
    }

    private void checkDuplicateLottoNumber(List<LottoNumber> manualLottoNumbers){
        Set<LottoNumber> checkSet = new HashSet<>(manualLottoNumbers);
        if(checkSet.size()<manualLottoNumbers.size()){
            throw new IllegalArgumentException(DUPLICATE_MANUAL_LOTTO_MESSAGE);
        }

    }

    public List<Lotto> addManualLotto(List<Lotto> manualLottos){
        manualLottos.add(new Lotto(manualLottoNumbers));
        return manualLottos;
    }

}
