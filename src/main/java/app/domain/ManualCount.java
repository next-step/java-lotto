package app.domain;

public class ManualCount {
    private int count;

    public ManualCount(int count) {
        if(count <0){
            throw new IllegalArgumentException("1이상 숫자만 입력 가능합니다.");
        }
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
