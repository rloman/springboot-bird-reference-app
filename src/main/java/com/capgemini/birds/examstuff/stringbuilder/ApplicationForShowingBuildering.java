package com.capgemini.birds.examstuff.stringbuilder;

public class ApplicationForShowingBuildering {

    public static void main(String[] args) {
        String firstName = "Erik";

        firstName.concat(" from the big book ");


        assert firstName.equals("Erik");

        String computer ="Compute";
        computer += "r";

        assert computer.equals("Computer") : "Here computer should be Computer";

        StringBuilder aComputerBuilder = new StringBuilder("Comp");

        aComputerBuilder.append("uter");

        String stringBuildFromTheBuilder = aComputerBuilder.toString();

        /// THIS IS TO EXPERIMENT
//        assert computer != stringBuildFromTheBuilder;

        // this is the way to do normally
        assert computer.equals(stringBuildFromTheBuilder) : "computer and stringBuildFronTheBuilder should be the same here";
    }
}
