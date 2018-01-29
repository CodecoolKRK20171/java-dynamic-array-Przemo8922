package com.codecool.dynamicArrayDojo;

public class DynamicIntArray {

    private int size;
    private int[] listNumber;

    public DynamicIntArray() {
        this.size = 0;
    }

    public DynamicIntArray(int size) {
        this.size = size;
        this.listNumber = new int[this.size];
    }

    public void add(int number) {
        int[] newNumberList = new int[getSize() + 1];
        if (getNumberList() != null)
            System.arraycopy(getNumberList(), 0, newNumberList, 0, getSize());

        newNumberList[newNumberList.length - 1] = number;
        setNumberList(newNumberList);
        setSize(getSize() + 1);
    }

    public void remove(int index) {
        checkSpace(index);
        int[] newNumberList = new int[getSize() - 1];
        for (int j = 0; j < newNumberList.length; j++) {
            if (j == index) {
                newNumberList[j] = getNumberList()[j+1];
            } else if (j < index) {
                newNumberList[j] = getNumberList()[j];
            } else if (j > index) {
                if (getNumberList().length > j+1) {
                    newNumberList[j] = getNumberList()[j + 1];
                }
            }
        }
        setSize(getSize()-1);
        setNumberList(newNumberList);
    }

    public void insert(int index, int value) {
        if (index > getSize())
            add(value);
        else {
            int[] newNumberList = new int[getSize() + 1];
            for (int i = 0; i <= index; i++) {
                if (i == index) {
                    newNumberList[index] = value;
                } else {
                    newNumberList[i] = getNumberList()[i];
                }
            }

            int newIndex = index + 1;
            for (int j = index; j < getSize(); j++) {
                newNumberList[newIndex++] = getNumberList()[j];
            }
            setSize(getSize() + 1);
            setNumberList(newNumberList);
        }
    }

    public String toString() {
        String output = "";
        for (int number : getNumberList()) {
            output += " " + number;
        }
        return output;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setNumberList(int[] newNumberList) {
        this.listNumber = newNumberList;
    }

    public int getSize() {
        return size;
    }

    public int[] getNumberList() {
        return listNumber;
    }

    private void checkSpace(int index) {
        if (index < 0 || index >= size ) {
            int maxRange = size-1;
            throw new ArrayIndexOutOfBoundsException("Index must be between 0 and " + maxRange);
        }
    }
}