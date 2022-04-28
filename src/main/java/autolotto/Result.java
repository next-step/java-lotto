package autolotto;

import java.util.Objects;

public class Result {
    private final int name;
    private final long prize;
    private int matchCount;

    public Result(int name, long prize) {
        this.name = name;
        this.prize = prize;
    }

    public boolean isMatch(int name) {
        return this.name == name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return name == result.name && prize == result.prize && matchCount == result.matchCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, prize, matchCount);
    }
}
