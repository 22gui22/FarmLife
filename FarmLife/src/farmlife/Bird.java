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
public class Bird extends Animal{
    public int flyCost;
    public int gainedEnergy;
    
    /**
     * Constructor for class Bird that receives as parameter an integer gender.
     * @param gender
     */
    public Bird(int gender){
        super(20,5,gender);
        flyCost = 2;
        gainedEnergy = 5;
    }
    /**
     * Constructor for class Bird that receives as parameter an integer runningCost,integer flyCost,integer gender,integer gainedEnergy.
     * @param runningCost
     * @param flyCost
     * @param gender
     * @param gainedEnergy
     */
    public Bird(int runningCost,int flyCost,int gender,int gainedEnergy){
        super(20,runningCost,gender);
        this.flyCost = flyCost;
        this.gainedEnergy = gainedEnergy;
    }
    /**
     * Method used to realize the fly action, and removes the energy cost of flying.
     */
    public void fly(){
        removeEnergy(flyCost);
    }
}
