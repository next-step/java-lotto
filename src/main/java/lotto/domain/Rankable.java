package lotto.domain;


public interface Rankable {
    Rankable NONE = new Rankable() {
        @Override
        public int rank(int countMatch) {
            return 0;
        }
    };

    int rank(int countMatch);
}

class FirstClass implements Rankable {
    @Override
    public int rank(int countMatch) {
        return 1;
    }
}

class SecondClass implements Rankable {
    @Override
    public int rank(int countMatch) {
        return 2;
    }
}

class ThirdClass implements Rankable {
    @Override
    public int rank(int countMatch) {
        return 3;
    }
}

class FourthClass implements Rankable {
    @Override
    public int rank(int countMatch) {
        return 4;
    }
}


