package domain.wrapper;

import domain.Lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoNo extends PlusNumber {
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static Map<Integer, LottoNo> instanceMap = new HashMap<>();
    public LottoNo(int number) {
        super(number);
        getInstanceMap();

        if(LOTTO_MIN_NUM > number || number > LOTTO_MAX_NUM ){
            throw new RuntimeException("로또 범위를 벗어났습니다.");
        }
    }

    private static void getInstanceMap() {
        if(instanceMap == null){
            for(int i = LOTTO_MIN_NUM; i <= LOTTO_MAX_NUM; i++){
                instanceMap.put(i,new LottoNo(i));
            }
        }
    }

    @Override
    public boolean equalsNumber(PlusNumber obj) {
        return super.equalsNumber(obj);
    }

    public static LottoNo getLottoNo(int number){
        getInstanceMap();
        if(!instanceMap.containsKey(number)){
            LottoNo lottoNo = new LottoNo(number);
            instanceMap.put(number,lottoNo);
            return lottoNo;
        }
        return instanceMap.get(number);

    }
}
