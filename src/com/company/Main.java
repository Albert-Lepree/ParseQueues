package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {


    public static void main(String args[]) throws FileNotFoundException {



        // array of objects?

        // queues have to be initialized even after making an array
        DynamicQueue[] queues = new DynamicQueue[4];
        queues[0] = new DynamicQueue();
        queues[1] = new DynamicQueue();
        queues[2] = new DynamicQueue();
        queues[3] = new DynamicQueue();

        File file = new File("C:/Users/finn2/IdeaProjects/QueueHW1/src/com/company/data.txt");
        Scanner scan = new Scanner(file);


        while (scan.hasNext()) {

            String temp = scan.nextLine();
            char letter = temp.charAt(0);
            char index = temp.charAt(2);

            if (index == '0') {
                System.out.print("Read key " + letter + " for queue " + index + ". ");
                queues[0].searchInsert(letter);
                System.out.print("Q0: ");
                queues[0].printQueue();
                System.out.println();

            } else if (index == '1') {
                System.out.print("Read key " + letter + " for queue " + index + ". ");
                queues[1].searchInsert(letter);
                System.out.print("Q1: ");
                queues[1].printQueue();
                System.out.println();

            } else if (index == '2') {
                System.out.print("Read key " + letter + " for queue " + index + ". ");
                queues[2].searchInsert(letter);
                System.out.print("Q2: ");
                queues[2].printQueue();
                System.out.println();

            } else if (index == '3') {
                System.out.print("Read key " + letter + " for queue " + index + ". ");
                queues[3].searchInsert(letter);
                System.out.print("Q3: ");
                queues[3].printQueue();
                System.out.println();

            } else {
                System.out.println("Invalid input");
            }

        }

        System.out.println("\n..Final Queues..");
        for (int i = 0; i < queues.length; i++) {
            System.out.print("Q" + i + ": ");
            queues[i].printQueue();
            System.out.println();
        }



    } // end main
}
