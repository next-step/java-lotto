package lotto;

public class ResultAll {
    private ResultThreeWon resultThreeWon;
    private ResultFourWon resultFourWon;
    private ResultFiveWon resultFiveWon;
    private ResultSixWon resultSixWon;

    public ResultAll() {
        resultThreeWon = new ResultThreeWon();
        resultFourWon = new ResultFourWon();
        resultFiveWon = new ResultFiveWon();
        resultSixWon = new ResultSixWon();
    }

    public ResultThreeWon getResultThreeWon() {
        return resultThreeWon;
    }

    public ResultFourWon getResultFourWon() {
        return resultFourWon;
    }

    public ResultFiveWon getResultFiveWon() {
        return resultFiveWon;
    }

    public ResultSixWon getResultSixWon() {
        return resultSixWon;
    }
}
