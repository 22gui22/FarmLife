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
public class Cat extends Animal{
    public String name;
    public int lossEnergy;
    Random rand = new Random();
    
    /**
     * Constructor for class Cat that receives as parameter an integer gender.
     * @param gender
     */
    public Cat(int gender) {
        super(500, 25, gender);
        this.name = catName();
    }
    
    /**
     * Constructor for class Dog that receives as parameter a String name, integer runningCost, integer gender.
     * @param name
     * @param runningCost
     * @param gender
     */
    public Cat(String name, int runningCost, int gender) {
        super(500, runningCost, gender);
        this.name = name;
    }
    
    /**
     * Method used to give a random name to a Cat.
     * @return random name
     */
    public String catName(){
        switch(gender){
            case 1:
                switch(rand.nextInt(20) + 1){
                    case 1: return "Tigger";
                    case 2: return "Shadow";
                    case 3: return "Oreo";
                    case 4: return "Oliver";
                    case 5: return "Jasper";
                    case 6: return "Smokey";
                    case 7: return "Gizmo";
                    case 8: return "Simba";
                    case 9: return "Charlie";
                    case 10: return "Jack";
                    case 11: return "Peanut";
                    case 12: return "Toby";
                    case 13: return "Loki";
                    case 14: return "Midnight";
                    case 15: return "Milo";
                    case 16: return "Max";
                    case 17: return "Rocky";
                    case 18: return "CoCo";
                    case 19: return "Oscar";
                    case 20: return "Buddy";
                    default: return "Boots";
                }
            case 2:
                switch(rand.nextInt(20) + 1){
                    case 1: return "Bella";
                    case 2: return "Chloe";
                    case 3: return "Luna";
                    case 4: return "Kitty";
                    case 5: return "Lucy";
                    case 6: return "Molly";
                    case 7: return "Angel";
                    case 8: return "Lily";
                    case 9: return "Baby";
                    case 10: return "Princess";
                    case 11: return "Sophie";
                    case 12: return "Harley";
                    case 13: return "Missy";
                    case 14: return "Zoe";
                    case 15: return "Misty";
                    case 16: return "Nala";
                    case 17: return "Pepper";
                    case 18: return "Sasha";
                    case 19: return "Pumpkin";
                    case 20: return "Kiki";
                    default: return "Daisy";
                }
            default: return "Error";
        }
    }
    
    /**
     * Method used to get the name of the cat.
     * @return name
     */
    public String getName(){
        return name;
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
                removeEnergy(runningCost);
                if(prey instanceof Bird)
                    ((Bird)prey).fly();
                else{
                    prey.removeEnergy(prey.runningCost);
                }
                if((prey.animalType().equals("Mouse") && rand.nextInt(5) + 1 == 1) || (prey.animalType().equals("Bird") && rand.nextInt(10) + 1 == 1)){   
                    addEnergy(prey.currentEnergy);
                    prey.die();
                    return animalType() + " " + name + " chased a " + prey.animalType() + " and was able to hunt it\n";
                }else{
                    if(prey.animalType().equals("Bird")){
                        prey.addEnergy(((Bird)prey).gainedEnergy);
                        if(prey.currentEnergy < (prey.maxEnergy / 4))
                            prey.sleep();
                        return animalType() + " " + name + " tried to hunt a " + prey.animalType() + " but he was able to fly away\n";
                    }else{
                        prey.addEnergy(((Mouse)prey).gainedEnergy);
                        if(prey.currentEnergy < (prey.maxEnergy / 4))
                            prey.sleep();
                        return animalType() + " " + name + " tried to hunt a " + prey.animalType() + " but he was able to run away\n";
                    }
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
