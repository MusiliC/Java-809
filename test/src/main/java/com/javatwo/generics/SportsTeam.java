package com.javatwo.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * InnerSportsTeam
 */
 record Affiliation(String name, String type, String code) {
    @Override
    public String toString() {
        return name + "( type " + type + " in " + code + ")";
    }
}

public class SportsTeam<T extends PLayer, S>  {
    //?upper bound - all T should be subclass of player or Player itself
    private String name;
    private List<T> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLoses  = 0;
    private int totalTies = 0;
    private S affiliation;

    public SportsTeam(String name, S affiliation) {
        this.name = name;
        this.affiliation = affiliation;
    }

    public void addTeamMember(T t){
        if(!teamMembers.contains(t)){
            teamMembers.add(t);
        }
    }

    public void listTeamMembers(){
        System.out.println(name + " Roaster: ");
        System.out.println(affiliation == null  ? "" : affiliation);
        System.out.println(teamMembers); 
    }

    public int ranking(){
        return (totalLoses * 2) + totalTies + 1;
    }


    public String setScore(int ourScore, int theirScore){
        String message = "lost to";

        if(ourScore > theirScore){
            totalWins ++;
            message = "beat";
        }else if(ourScore == theirScore){
            totalTies++;
            message = "tied";
        }else{
            totalLoses ++;
        }

        return message;
    }

    @Override
    public String toString() {
        return name + "( Ranked " + ranking() + ")";
    }

    
}
