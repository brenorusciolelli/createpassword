package com.netdeal.crud.createpassword.model;

public enum Position {
	
    CEO(1),
    Manager(2),
    Supervisor(3),
    Employee(4);

    private final int value;
    private Position superior;

    Position(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public void setSuperior(Position superior) {
        this.superior = superior;
    }

    public Position getSuperior() {
        return superior;
    }
    
    public Position setSuperiorPosition(Position position) {
        Position superior = null;
        switch (position) {
            case CEO: 
            	superior = null;
                break;
            case Manager: 
            	superior = Position.CEO;
                break;    
            case Supervisor: 
            	superior = Position.Manager;
                break; 
            case Employee: 
            	superior = Position.Supervisor;
                break; 
        }
        return superior;
    }

}
