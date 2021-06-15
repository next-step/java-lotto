package lottoAuto.model;

import java.util.Collections;
import java.util.List;

public class UserLottos {
    private List<UserLotto> userUserLottoNumbers;

    public UserLottos(List<UserLotto> userUserLottoNumbers){
        this.userUserLottoNumbers = userUserLottoNumbers;
    }

    public List<UserLotto> getUserLottoNumbers() {
        return Collections.unmodifiableList(userUserLottoNumbers);
    }

}
