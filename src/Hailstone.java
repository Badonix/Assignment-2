/*
 * File: Hailstone.java
 * Name:
 * Section Leader:
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.ConsoleProgram;

public class Hailstone extends ConsoleProgram {
    public void run() {
        int current = readInt("Enter a number: ");
        int count = 0;
        if (current < 1) {
            println("Number has to be >= 1");
        }
        while (current != 1) {
            count++;
            current = calculateNext(current);
        }
        println("The process took " + count + " steps to reach 1");
    }

    private int calculateNext(int current) {
        int newNum;
        if (current % 2 == 0) {
            newNum = current / 2;
            println(current + " is even, so I take half: " + newNum);
        } else {
            newNum = current * 3 + 1;
            println(current + " is odd, so I make 3n + 1: " + newNum);
        }
        return newNum;
    }
}

