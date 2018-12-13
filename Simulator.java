
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafal-PC
 */
public class Simulator {
    
    public void start() {
        Reader scanner = new Reader();
        ArrayList<Jumper> participants = new ArrayList<Jumper>();
        
        System.out.println("Kumpula ski jumping week\n");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        while(true) {
            System.out.print("  Participant name: ");
            String name = scanner.read();            
            if(name.equals("")) {break;}        
            participants.add(new Jumper(name));
        }
        
        Collections.sort(participants, new SortByPoints());
        
        System.out.println("\nThe tournament begins!");//-----------------------------------JUMPS----------------------------------------
        int round = 1;
        while(true) {
            System.out.print("\nWrite \"jump\" to jump; otherwise you quit: ");
            if(!scanner.read().equals("jump")) {
                break;
            }
            System.out.println("\nRound "+round);
            Collections.sort(participants, new SortByPoints());
            System.out.println("Jumping order:");
            int order = 0;
            for(Jumper jp: participants) {
                order ++;
                System.out.println("  "+order+". "+jp);
            }
            
            System.out.println("\nResults of round "+round);
            for(Jumper jp: participants) {
                int length = jump();//-----------------------performs a jump;
                jp.addJump(length);
                ArrayList<Integer> votes = judge(length);//--jump gets judged;
                int score = score(votes);//------------------votes get added to the score;
                System.out.println("  "+jp.getName()+"\n"
                                + "    length: "+length+"\n"
                                + "    judge votes: "+votes);
                jp.addPoints(length + score);
            }
            round ++;
        }
        
        System.out.println("\nThanks!\n\nTournament results:");
        System.out.print("Position    Name");
        int position = 1;
        Collections.sort(participants, new SortByPoints());
        Collections.reverse(participants);
        for(Jumper jp: participants) {
            System.out.print("\n"+position+"           "+jp+"\n            jump lengths: ");
            int last = jp.getJumps().size();
            for(Integer jump: jp.getJumps()) {
                System.out.print(jump + " m");
                if(jp.getJumps().indexOf(jump) == last -1) {System.out.println(); break;}
                System.out.print(", ");
            }
            position ++;
        }
    }
    
    public ArrayList<Integer> judge(Integer length) {
        ArrayList<Integer> votes = new ArrayList<Integer>();
        Random vote = new Random();
        for(int i = 0; i < 5; i++) {
            votes.add(10 + vote.nextInt(10));
        }
        return votes;
    }
    
    public int jump() {
        Random jump = new Random();
        return 60 + jump.nextInt(60);
    }
    
    public int score(ArrayList<Integer> votes) {
        Collections.sort(votes);
        return votes.get(1)+ votes.get(2) + votes.get(3);
    }
    
}
