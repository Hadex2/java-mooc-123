
import java.util.ArrayList;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafal-PC
 */
public class Jumper {
    private String name;
    private int points;
    private ArrayList<Integer> jumps = new ArrayList<Integer>();
    
    public Jumper(String name) {
        this.name = name;
    }
    
    public void addJump(int jump) {
        this.jumps.add(jump);
    }
    
    public ArrayList<Integer> getJumps() {
        return this.jumps;
    }
    
    public void addPoints(int points) {
        this.points += points;
    }
    
    public int getPoints() {
        return this.points;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String toString() {
        return this.name+" ("+this.points+" points) ";
    }

}
