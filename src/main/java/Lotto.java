import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Lotto {
    private final ArrayList<Integer> nums;

    public int numCount() {
        return this.nums.size();
    }

    public Lotto(ArrayList<Integer> nums){
        if(nums.stream().anyMatch(num -> num < 1 || num > 46)){
            throw new IllegalArgumentException("로또 번호는 1~46 범위이어야 합니다.");
        }

        this.nums = nums;
    }

    public Lotto(String numStr){
        this.nums = Arrays.stream(numStr.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public boolean has(int num){
        return this.nums.contains(num);
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
