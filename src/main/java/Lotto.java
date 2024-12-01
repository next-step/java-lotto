import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNums;

    public Lotto(String numStr){
        this(Arrays.stream(numStr.split(","))
                .map(LottoNumberCache::get)
                .collect(Collectors.toList()));
    }

    public Lotto(int... nums) {
        this(Arrays.stream(nums)
                .mapToObj(LottoNumberCache::get)
                .collect(Collectors.toList()));
    }

    public Lotto(List<LottoNumber> nums) {
        this.lottoNums = nums;
    }

    public int numCount() {
        return this.lottoNums.size();
    }

    public boolean has(LottoNumber bonusBall){
        return bonusBall.isOneOf(this.lottoNums);
    }

    public MatchCount match(Lotto other) {
        MatchCount count = new MatchCount();

        for (LottoNumber num : this.lottoNums){
            count.tryIncrement(other.has(num));
        }

        return count;
    }

    @Override
    public String toString() {
        String str = "";
        boolean isFirst = true;

        for(LottoNumber num : this.lottoNums) {
            str = concatNums(str, num, isFirst);
            isFirst = false;
        }

        return str;
    }

    private String concatNums(String numStr, LottoNumber num, boolean isFirst){
        if(!isFirst){
            numStr += ", ";
        }

        numStr += num.toString();

        return numStr;
    }
}
