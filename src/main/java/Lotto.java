import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNums;

    public Lotto(String numStr){
        this((List<Integer>)Arrays.stream(numStr.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    public Lotto(int... nums) {
        this(new ArrayList<>(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new))));
    }

    public Lotto(List<Integer> nums){
        this.lottoNums = nums.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public int numCount() {
        return this.lottoNums.size();
    }

    public boolean has(int num){
        return this.lottoNums.contains(num);
    }

    public boolean has(LottoNumber bonusBall){
        return bonusBall.isOneOf(this.lottoNums);
    }

    public MatchCount match(Lotto other) {
        MatchCount count = new MatchCount();

        for(LottoNumber num : this.lottoNums){
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
