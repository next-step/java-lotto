package com.seok2.adder;

import com.seok2.adder.domain.StringAdder;

public class AdderMain {

    public static void main(String[] args) {

        System.out.println(StringAdder.sum(""));
        System.out.println(StringAdder.sum(" "));
        System.out.println(StringAdder.sum("1,2,3"));
        System.out.println(StringAdder.sum(null));

    }

}
