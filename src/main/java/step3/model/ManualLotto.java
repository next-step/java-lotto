package step3.model;

import step3.util.StringUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManualLotto {

    private final static int LOTTO_NUM_SIZE = 6;
    private final static String LOTTO_NUM_SIZE_MESSAGE = "로또 번호는 6자리이여만 합니다.";

    private final List<Lotto> lottoList = new ArrayList<>();

    public ManualLotto(List<String> manualLotto) {
        for(String lotto : manualLotto) {
            addManualLotto(lotto);
        }
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    private void addManualLotto(String lottoNum) {
        String[] lottoNums = StringUtil.divideNum(lottoNum);
        confirmLottoNumberSize(lottoNums);
        this.lottoList.add(createLotto(lottoNums));
    }

    private Lotto createLotto(String[] lottoNum) {
        Set<LottoNumber> lotto = new HashSet<>();

        for(String num : lottoNum) {
            lotto.add(new LottoNumber(Integer.parseInt(num)));  // 중복된 값은 자동으로 제외
        }

        return new Lotto(lotto);
    }

    //로또번호의 갯수를 확인한다.
    private void confirmLottoNumberSize(String[] lottoNumbers) {
        if(lottoNumbers.length != LOTTO_NUM_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUM_SIZE_MESSAGE);
        }
    }
}
