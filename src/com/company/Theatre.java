package com.company;

import java.util.*;



    public class Theatre {

        private final String theatreName;
        public List<Seat> seats = new ArrayList<>();

        public Theatre(String theatreName, int numRows, int seatPerRow) {
            this.theatreName = theatreName;

            int lastRow = 'A' + (numRows -1); // numRows - 1 bcx we are working with array; 2Dim array
            for(char row = 'A'; row <= lastRow; row++) {
                for (int seatNum = 1; seatNum <= seatPerRow; seatNum++) {

                    Seat seat = new Seat (row + String.format("%02d", seatNum));
                    seats.add(seat);
                }
            }

        }

        public String getTheatreName() {
            return theatreName;
        }

        public boolean reserveSeat(String seatNumber) {
            Seat requestedSeat = new Seat(seatNumber);

            int foundSeat = Collections.binarySearch(seats, requestedSeat, null);

            if(foundSeat >= 0) {
                return seats.get(foundSeat).reserve();
            } else {
                System.out.println("there is no seat " + seatNumber);
                return false;
            }

        }

        // for testing purposes
        public void getSeat() {
            for(Seat seat : seats) {
                System.out.println(seat.getSeatNumber());
            }
        }


        public class Seat implements Comparable<Seat> {

            private final String seatNumber;
            private boolean reserved = false;

            public Seat(String seatNumber) {
                this.seatNumber = seatNumber;
            }

            @Override
            public int compareTo(Seat seat) {
                return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
            }

            public boolean reserve() {
                if (!this.reserved) { // if it's not reserved then we can book it.
                    this.reserved = true;
                    System.out.println("Seat " + seatNumber + " reserved");
                    return true;
                } else {
                    return false; // it's already reserved... you can't book it.
                }

            }

            public boolean cancel() {
                if (this.reserved) {
                    this.reserved = false;
                    System.out.println("Reservation of seat " + seatNumber + " cancelled!");
                    return true;
                } else {
                    return false;
                }
            }

            public String getSeatNumber() {
                return seatNumber;
            }
        }

    }



