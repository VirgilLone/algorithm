package com.lw.algorithm.copy_Obj;

import java.io.Serializable;

public class Computer implements Cloneable , Serializable {
    private String computerName;

    public Computer(String computerName) {
        this.computerName = computerName;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
