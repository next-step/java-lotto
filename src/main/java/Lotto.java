import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> nums;

    public Lotto(String numStr){
        this((List<Integer>)Arrays.stream(numStr.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    public Lotto(int... nums) {
        this(new ArrayList<>(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new))));
    }

    public Lotto(List<Integer> nums){
        if(nums.stream().anyMatch(num -> num < Constants.MIN_LOTTO_NUMBER || num > Constants.MAX_LOTTO_NUMBER)){
            throw new IllegalArgumentException("로또 번호는 1~46 범위이어야 합니다.");
        }

        this.nums = nums;
    }

    public int numCount() {
        return this.nums.size();
    }

    public boolean has(int num){
        return this.nums.contains(num);
    }

    public boolean has(BonusBall bonusBall){
        return bonusBall.isOneOf(this.nums);
    }

    public MatchCount match(Lotto other) {
        MatchCount count = new MatchCount();

        for(int num : this.nums){
            count.tryIncrement(other.has(num));
        }

        return count;
    }

    @Override
    public String toString() {
        String str = "";
        boolean isFirst = true;

        for(int num : this.nums) {
            str = concatNums(str, num, isFirst);
            isFirst = false;
        }

        return str;
    }

    private String concatNums(String numStr, int num, boolean isFirst){
        if(!isFirst){
            numStr += ", ";
        }

        numStr += num;

        return numStr;
    }
}
