package com.javatwo.generics;


/**
 * InnerMain
 */
 interface PLayer {

    
}

/**
 * InnerMain
 */
 record BaseballPlayer(String name, String position) implements PLayer {
}

record FootballPlayer(String name, String position) implements PLayer {
}

public class Main {
  

    public static void main(String[] args) {

        Affiliation Nai = new Affiliation("Nairobi", "school team", "Nai");

       SportsTeam<BaseballPlayer, Affiliation> City = new SportsTeam<>("City", Nai);
       SportsTeam<BaseballPlayer, Affiliation>  Chelsea = new SportsTeam<>("Chelsea", Nai);

       SportsTeam<FootballPlayer, Affiliation> Gor = new SportsTeam<>("Gor", Nai);
       SportsTeam<FootballPlayer, Affiliation>  Afc = new SportsTeam<>("Afc", Nai);

        var Foden = new BaseballPlayer("Foden", "CAM");
        var Silva = new BaseballPlayer("Silva", "Right WIng");

        var Rooney = new FootballPlayer("Onyango", "utility");
        var Austin = new FootballPlayer("Odhiambo", "CM");

        City.addTeamMember(Silva);
        City.addTeamMember(Foden);

        Gor.addTeamMember(Rooney);
        Gor.addTeamMember(Austin);

        scoreResult(City, 5, Chelsea, 3);
        scoreResult(Gor, 2, Afc, 3);
        City.listTeamMembers();
        Gor.listTeamMembers();
    }


    public static void scoreResult(SportsTeam team1,int t1_score, SportsTeam team2, int t2_score){
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
