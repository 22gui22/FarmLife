/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmlife;

/**
 *
 * @author Guilherme Manteigas - 170262014 - guilherme.manteigas@gmail.com
 * @author João Pascoal - 170262010 - jp_pascoal@hotmail.com
 * @author José Abreu - 170262013 - abreu.ricardo@live.com.pt
 * @version 1.0
 */
public class Mouse extends Animal{
    public int gainedEnergy;
    
    /**
     * Constructor for class Mouse that receives as parameter an integer gender.
     * @param gender
     */
    public Mouse(int gender){
        super(50,2,gender);
        gainedEnergy = 5;
    }
    
    /**
     * Constructor for class Bird that receives as parameter an integer runningCost,integer gender,integer gainedEnergy.
     * @param runningCost
     * @param gender
     * @param gainedEnergy
     */
    public Mouse(int runningCost,int gender,int gainedEnergy){
        super(50,runningCost,gender);
        this.gainedEnergy = gainedEnergy;
    }
}
