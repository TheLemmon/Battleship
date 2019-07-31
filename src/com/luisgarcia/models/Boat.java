package com.luisgarcia.models;

import com.luisgarcia.enumerations.BoatType;

public class Boat {
    private int startRow;
    private int startColumn;
    private int endRow;
    private int endColumn;

    public Boat(int startRow, int startColumn, int endRow, int endColumn) {
        this.startRow = startRow;
        this.startColumn = startColumn;
        this.endRow = endRow;
        this.endColumn = endColumn;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getStartColumn() {
        return startColumn;
    }

    public void setStartColumn(int startColumn) {
        this.startColumn = startColumn;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getEndColumn() {
        return endColumn;
    }

    public void setEndColumn(int endColumn) {
        this.endColumn = endColumn;
    }

    public int getBoatLength() {
        BoatType boatType = this.getBoatType();
        if (boatType == BoatType.POINT) {
            return 1;
        } else if (boatType == BoatType.HORIZONTAL) {
            return (endColumn - startColumn) + 1;
        } else {
            return (endRow - startRow) + 1;
        }
    }

    public BoatType getBoatType() {
        if (startRow == endRow && startColumn == endColumn) {
            return BoatType.POINT;
        } else if (startColumn == endColumn) {
            return BoatType.VERTICAL;
        } else {
            return BoatType.HORIZONTAL;
        }
    }
}