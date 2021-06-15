package lottoAuto.model;

import java.util.Collections;
import java.util.List;

public class UserLottos {
    private List<Lotto> userLottoNumbers;

    public UserLottos(List<Lotto> userLottoNumbers){
        this.userLottoNumbers = userLottoNumbers;
    }

    public List<Lotto> getUserLottoNumbers() {
        return Collections.unmodifiableList(userLottoNumbers);
    }

}
