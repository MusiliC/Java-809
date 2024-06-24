package com.javatwo.chapterone;

public class Employer {
     
    public int employeeId;
    public String firstName, lastName;
    public int yearStarted;

    @Override public int hashCode(){
        return employeeId;
    }

    public boolean equals(Employer e){
        return this.employeeId == e.employeeId;
    }
}
