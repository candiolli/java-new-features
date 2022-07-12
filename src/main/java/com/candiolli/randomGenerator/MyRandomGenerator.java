package com.candiolli.randomGenerator;

import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class MyRandomGenerator {

    public static void main(String[] args) {
        RandomGenerator rg1 = RandomGeneratorFactory.of("Random")
                .create(42);

//        rg1.doubles().limit(100).forEach(d -> {
//            System.out.println(d);
//        });

        RandomGenerator rg2 = RandomGeneratorFactory.of("L32X64MixRandom")
                .create(42);

        rg2.ints().limit(100).forEach(d -> {
            System.out.println(d);
        });
    }
}
