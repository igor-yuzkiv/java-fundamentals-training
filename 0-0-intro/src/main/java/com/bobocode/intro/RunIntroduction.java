package com.bobocode.intro;

public class RunIntroduction {
    public static void main(String [] args) {
        Introduction introduction = new Introduction();
        System.out.println(introduction.encodeMessage(introduction.getWelcomeMessage()));
    }
}
