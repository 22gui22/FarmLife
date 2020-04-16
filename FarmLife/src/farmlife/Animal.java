/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmlife;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Guilherme Manteigas - 170262014 - guilherme.manteigas@gmail.com
 * @author João Pascoal - 170262010 - jp_pascoal@hotmail.com
 * @author José Abreu - 170262013 - abreu.ricardo@live.com.pt
 * @version 1.0
 */
public abstract class Animal {
    protected int currentEnergy;
    protected int maxEnergy;
    protected int runningCost;
    protected boolean isSleeping;
    protected boolean isAlive;
    protected int gender;
    protected String mom = "Unknown";
    protected String dad = "Unknown";
    
    /**
     * Constructor for class Animal that receives as parameter an integer maxEnergy, integer runningCost, integer gender.
     * @param maxEnergy
     * @param runningCost
     * @param gender
     */
    public Animal(int maxEnergy, int runningCost, int gender){
        this.maxEnergy = maxEnergy;
        currentEnergy = maxEnergy;
        this.runningCost = runningCost;
        isAlive = true;
        isSleeping = false;
        this.gender = gender;
    }

    /**
     * Method that returns the max energy.
     * @return maxEnergy
     */
    public int getMaxEnergy() {
        return maxEnergy;
    }

    /**
     * Method that returns the running cost.
     * @return runningCost
     */
    public int getRunningCost() {
        return runningCost;
    }
    
    /**
     * Method that returns the current energy.
     * @return currentEnergy
     */
    public int getCurrentEnergy() {
        return currentEnergy;
    }
    
    /**
     * Method that puts the animal sleeping.
     */
    public void sleep() {
        isSleeping = true;
        currentEnergy = maxEnergy;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                isSleeping = false;
                timer.cancel();
            }
        }, 5000);
    }
    
    /**
     * Method that wakes up the animal.
     */
    public void wakeUp() {
        if(isSleeping == true){
            isSleeping = false;
        }                        
    }
    
    /**
     * Method that kills the animal.
     */
    public void die() {
        removeEnergy(maxEnergy);
        isAlive = false;                      
    }
 
    /**
     * Method that returns the animal specie.
     * @return specie
     */
    public String animalType() {
        switch(maxEnergy){
            case 10000: return "Dog";
            case 500:   return "Cat";
            case 300:   return "Falcon";
            case 50:    return "Mouse";
            case 20:    return "Bird";
            default: return "";
        }
    }
    
    /**
     * Method that removes energy from the animal.
     * @param amount
     */
    public void removeEnergy(int amount){
        if(currentEnergy < amount){
            currentEnergy = 0;
            addEnergy(maxEnergy);
            sleep();
        }else{
            currentEnergy = currentEnergy - amount;
        }
    }
    
    /**
     * Method that adds energy from the animal.
     * @param amount
     */
    public void addEnergy(int amount){
        if(currentEnergy + amount > maxEnergy){
            currentEnergy = maxEnergy;
        }else{
            currentEnergy = currentEnergy + amount;
        }
    }
    
    /**
     * Method that realizes the running action for animal.
     */
    public void run(){
        removeEnergy(runningCost);
    }
}
