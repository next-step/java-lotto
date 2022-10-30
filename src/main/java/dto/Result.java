package dto;

public class Result {
    private long result;

    public Result(long result) {
        this.result = result;
    }

    public long add(long number) {
        result += number;
        return result;
    }

    public long getResult() {
        return result;
    }
}
