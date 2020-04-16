/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmlife;
import java.util.Random;

/**
 *
 * @author Guilherme Manteigas - 170262014 - guilherme.manteigas@gmail.com
 * @author João Pascoal - 170262010 - jp_pascoal@hotmail.com
 * @author José Abreu - 170262013 - abreu.ricardo@live.com.pt
 * @version 1.0
 */
public class Dog extends Animal{
    private String name;
    private int attackEnergy;
    Random rand = new Random();
    
    /**
     * Constructor for class Dog that receives as parameter an integer gender.
     * @param gender
     */
    public Dog(int gender) {
        super(10000, 50, gender);
        this.name = dogName();
        this.attackEnergy = 100;
    }
    
    /**
     * Constructor for class Dog that receives as parameter a String name, integer runningCost, integer attackEnergy, integer gender.
     * @param name
     * @param runningCost
     * @param attackEnergy
     * @param gender
     */
    public Dog(String name, int runningCost, int attackEnergy, int gender) {
        super(10000, runningCost, gender);
        this.name = name;
        this.attackEnergy = attackEnergy;
    }
    
    /**
     * Method used to give a random name to a Dog.
     * @return random name
     */
    public String dogName(){
        switch(gender){
            case 1:
                switch(rand.nextInt(20) + 1){
                    case 1: return "Apolo";
                    case 2: return "Charlie";
                    case 3: return "Max";
                    case 4: return "Buddy";
                    case 5: return "Archie";
                    case 6: return "Rocky";
                    case 7: return "Cody";
                    case 8: return "Snoopy";
                    case 9: return "Oscar";
                    case 10: return "Toby";
                    case 11: return "Cooper";
                    case 12: return "Bear";
                    case 13: return "Lucky";
                    case 14: return "Teddy";
                    case 15: return "Rusty";
                    case 16: return "Gizmo";
                    case 17: return "Baxter";
                    case 18: return "Milo";
                    case 19: return "Frankie";
                    case 20: return "Jack";
                    default: return "Winston";
                }
            case 2:
                switch(rand.nextInt(20) + 1){
                    case 1: return "Bella";
                    case 2: return "Lucy";
                    case 3: return "Molly";
                    case 4: return "Daisy";
                    case 5: return "Maggie";
                    case 6: return "Sophie";
                    case 7: return "Chloe";
                    case 8: return "Bailey";
                    case 9: return "Lola";
                    case 10: return "Zoe";
                    case 11: return "Abby";
                    case 12: return "Ginger";
                    case 13: return "Roxy";
                    case 14: return "Gracie";
                    case 15: return "Sasha";
                    case 16: return "Lily";
                    case 17: return "Princess";
                    case 18: return "Emma";
                    case 19: return "Annie";
                    case 20: return "Rosie";
                    default: return "Ruby";
                }
            default: return "Error";
        }
    }
    
    /**
     * Method used to get the name of the dog.
     * @return name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Method that realizes the action Dog attacking a Cat, that returns a String with the action details.
     * @param prey
     * @return action
     */
    public String attack(Cat prey){
        if(currentEnergy >= runningCost + attackEnergy){
                removeEnergy(runningCost);
                removeEnergy(attackEnergy);
                prey.removeEnergy(prey.lossEnergy);
                if(prey.currentEnergy < (prey.maxEnergy / 4))
                    prey.sleep();
                return animalType() + " " + name + " chased a " + prey.animalType() + " " + prey.name + " and was able to attack it\n";
        }else{
            sleep();
            return animalType() + " " + name + " tried but wasn't able to chase the " + prey.animalType() + " " + prey.getName() + " because " + animalType() + " " + name + " didn't have enough energy\n";
        }
    }
    
    /**
     * Method that realizes the action hunt a prey, that returns a String with the action details.
     * @param prey
     * @return action
     */
    public String hunt(Animal prey){
        if(currentEnergy >= runningCost){
            if(prey.isSleeping == true){
                run();
                if(rand.nextInt(2) + 1 == 1){
                    prey.run();
                    prey.addEnergy(((Mouse)prey).gainedEnergy);
                    prey.wakeUp();
                    return animalType() + " " + name + " tried to hunt a " + prey.animalType() + " while he was sleeping but the " + prey.animalType() + " was able to run away\n";
                }else{
                    addEnergy(prey.currentEnergy);
                    prey.die();
                    return animalType() + " " + name + " chased a " + prey.animalType() + " and was able to hunt it\n";
                }
            }else if(prey.currentEnergy >= prey.runningCost){
                run();
                prey.run();
                if(rand.nextInt(25) + 1 == 1){   
                    addEnergy(prey.currentEnergy);
                    prey.die();
                    return animalType() + " " + name + " chased a " + prey.animalType() + " and was able to hunt it\n";
                }else{
                    prey.addEnergy(((Mouse)prey).gainedEnergy);
                    if(prey.currentEnergy < (prey.maxEnergy / 4))
                        prey.sleep();
                    return animalType() + " " + name + " chased a " + prey.animalType() + " but wasn't able to get it\n";
                }               
            }else{
                addEnergy(prey.currentEnergy);
                prey.die();
                return animalType() + " " + name + " was abel to hunt " + prey.animalType() + " because he was to tired to run\n";
            }
        }else{
            sleep();
            return animalType() + " " + name + " tried but wasn't able to chase the " + prey.animalType() + " because " + animalType() + " " + name + " didn't have enough energy\n";
        }
    }
}
