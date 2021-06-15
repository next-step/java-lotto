package lottoAuto.model;

import java.util.Collections;
import java.util.List;

public class UserLotto {
    private List<Integer> lottoNumbers;

    public UserLotto(List<Integer> lottoNumbers) {
        
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
