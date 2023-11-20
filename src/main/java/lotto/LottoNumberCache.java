package lotto;

import java.util.*;

public class LottoNumberCache {
    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;

    private static final Map<Integer, LottoNumber> CACHE = new HashMap<>();

    private LottoNumberCache(){}

    static {
        for(int i=MIN_NUMBER;i<=MAX_NUMBER;i++){
            CACHE.put(i, new LottoNumber(i));
        }
    }

    public static LottoNumber findNumber(int number){
        return CACHE.get(number);
    }

    public static Collection<LottoNumber> values(){
        return Collections.unmodifiableCollection(CACHE.values());
    }


}

