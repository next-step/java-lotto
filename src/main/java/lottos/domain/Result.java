package lottos.domain;

import java.util.Objects;

public class Result {

    private int nameOfMatches;
    private int countOfMatches;

    public Result(int nameOfMatches, int countOfMatches) {
        this.nameOfMatches = nameOfMatches;
        this.countOfMatches = countOfMatches;
    }

    public int getNameOfMatches() {
        return nameOfMatches;
    }

    public int getCountOfMatches() {
        return countOfMatches;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return nameOfMatches == result.nameOfMatches && countOfMatches == result.countOfMatches;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfMatches, countOfMatches);
    }
}
