package com.hskim.lotto.model;

import java.util.List;

public class PositiveNumberExpr {

    public List<String> tokenList;

    public PositiveNumberExpr(List<String> tokenList) {

        this.tokenList = tokenList;
    }

    public List<String> getTokenList() {

        return tokenList;
    }
}
