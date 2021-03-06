package com.lift.shykhov.util;

import com.lift.shykhov.entity.Building;
import com.lift.shykhov.entity.Passenger;
import com.lift.shykhov.exception.InvalidParameterException;

import java.util.Random;

public class Utils {

    public static void fillBuildingByPassengers(Building building, int minOnFloor, int maxOnFloor) {
        for (int i = 0; i < building.getFloorsCount(); i++) {
            for (int j = 0; j < getRandomNumber(minOnFloor, maxOnFloor); j++) {
                int randomNumber = getRandomNumber(0, building.getFloorsCount() - 1);
                while (randomNumber == i) {
                    randomNumber = getRandomNumber(0, building.getFloorsCount() - 1);
                }
                try {
                    building.putPassenger(i, new Passenger(randomNumber));
                } catch (InvalidParameterException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int getRandomNumber(int min, int max) {
        return new Random().nextInt(max + 1 - min) + min;
    }


}
