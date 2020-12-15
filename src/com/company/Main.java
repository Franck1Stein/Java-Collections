package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Theatre theatre = new Theatre("Olympian", 8, 12);
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
        printList(seatCopy);
        seatCopy.get(1).reserve();
        if (theatre.reserveSeat("A02")) {
            System.out.println("Please Pay for A02");
        } else {
            System.out.println("Seat already reserved");
        }

        Theatre.Seat minSeat = Collections.min(seatCopy);
        Theatre.Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Min seat number is " + minSeat.getSeatNumber());
        System.out.println("Max seat number is " + maxSeat.getSeatNumber());

        Collections.shuffle(seatCopy);
        System.out.println("Printing seatCopy");
//        printList(seatCopy);
//        System.out.println("Printing theatre.seat");
//        printList(theatre.seats);

        sortList(seatCopy);
        System.out.println("Printing sorted seatCopy");
        printList(seatCopy);

//        theatre.getSeat();
//
//        if (theatre.reserveSeat("B13")) {
//            System.out.println("Please make payment");
//        } else {
//            System.out.println("sorry, seat is already taken");
//        }

    }

    public static void printList(List<Theatre.Seat>list) {

        for(Theatre.Seat seat : list) {
            System.out.println(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("===============================================================");
    }



    public static void sortList(List<? extends Theatre.Seat> list) {

        for (int i=0; i < list.size() -1; i++) {
            for(int j = i+1; j < list.size(); j++) {
                if( list.get(i).compareTo(list.get(j)) > 0 ) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }

}
