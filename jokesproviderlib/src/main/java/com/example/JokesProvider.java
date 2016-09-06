package com.example;

import java.util.Random;

public class JokesProvider {
     static String[]Jokes={
            "Q: what`s the object oriented way to get wealthy? " +
                    "\n A: Inheritance "
            ,
            "Q: Why do programmers always mix up Halloween and Christmas?" +
                    "\n" +
                    "A: Because Oct 31 == Dec 25!"
            ,"“Knock, knock.”\n" +
            "\n" +
            "“Who’s there?”\n" +
            "\n" +
            "very long pause….\n" +
            "\n" +
            "“Java.”\n" +
            "\n" +
            ":-o\n" +
            "\n"

    };

   public static String getJoke(){
        Random rn = new Random();
        int randomIndex = rn.nextInt(Jokes.length) ;
        return Jokes[randomIndex];
    }

}