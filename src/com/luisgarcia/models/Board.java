package com.luisgarcia.models;

import com.luisgarcia.enumerations.BoatType;

public class Board {
    private Boat[] boats;

    public Board(Boat[] boats) {
        this.boats = boats;
    }

    public Boat[] getBoats() {
        return boats;
    }

    public void setBoats(Boat[] boats) {
        this.boats = boats;
    }

    public boolean checkAvailable(Boat newBoat) {
        return true;
    }

    public boolean checkPosition(Boat newBoat) {
        for (Boat boat: boats) {
            if (boat != null) {
                if (newBoat.getBoatType() == BoatType.VERTICAL) {
                    // check if the new boat intersects with a horizontal boat
                    if (boat.getBoatType() == BoatType.HORIZONTAL || boat.getBoatType() == BoatType.POINT) {
                        if (boat.getStartRow() >= newBoat.getStartRow() && boat.getEndRow() <= newBoat.getEndRow()) {
                            return false;
                        }
                    } else if (boat.getBoatType() == BoatType.VERTICAL) {
                        if (newBoat.getStartRow() >= boat.getStartRow() && newBoat.getStartRow() <= boat.getEndRow()) {
                            return false;
                        }
                        if (newBoat.getEndRow() >= boat.getStartRow() && newBoat.getEndRow() <= boat.getEndRow()) {
                            return false;
                        }
                    }
                }
                // check if the new boat intersects with a vertical boat
                if (newBoat.getBoatType() == BoatType.HORIZONTAL) {
                    if (boat.getBoatType() == BoatType.VERTICAL || boat.getBoatType() == BoatType.POINT) {
                        if (boat.getStartColumn() >= newBoat.getStartColumn() && boat.getEndColumn() <= newBoat.getEndColumn()) {
                            return false;
                        }
                    } else if (boat.getBoatType() == BoatType.HORIZONTAL) {
                        if (newBoat.getStartColumn() >= boat.getStartColumn() && newBoat.getStartColumn() <= boat.getEndColumn()) {
                            return false;
                        }
                        if (newBoat.getEndRow() >= boat.getStartColumn() && newBoat.getEndColumn() <= boat.getEndColumn()) {
                            return false;
                        }
                    }
                }
                // check if the new boat intersects with a point boat
                if (newBoat.getBoatType() == BoatType.POINT) {
                    // check row
                    if (newBoat.getStartRow() >= boat.getStartRow() && newBoat.getEndRow() <= boat.getEndRow()) {
                        if (newBoat.getStartColumn() >= boat.getStartColumn() && newBoat.getEndColumn() <= boat.getEndColumn()) {
                            return  false;
                        }
                    }
                    // check column
                    if (newBoat.getStartColumn() >= boat.getEndColumn() && newBoat.getEndColumn() <= boat.getEndColumn()) {
                        if (newBoat.getStartRow() >= boat.getStartRow() && newBoat.getEndRow() <= boat.getEndRow()) {
                            return  false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
