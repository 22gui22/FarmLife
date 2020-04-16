/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmlife;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Guilherme Manteigas - 170262014 - guilherme.manteigas@gmail.com
 * @author João Pascoal - 170262010 - jp_pascoal@hotmail.com
 * @author José Abreu - 170262013 - abreu.ricardo@live.com.pt
 * @version 1.0
 */
public class Simulator {
    LinkedList<Dog> dogList = new LinkedList<>();
    LinkedList<Cat> catList = new LinkedList<> ();
    LinkedList<Mouse> mouseList = new LinkedList<> ();
    LinkedList<Bird> birdList = new LinkedList<> ();
    LinkedList<Integer> optionsForRandom = new LinkedList<>();
    LinkedList<Integer> optionsForBirth = new LinkedList<>();
    Random rand = new Random();
    int gender;
    
    /**
     * Constructor for class Simulator that receives as parameter an integer numDogs, integer numCats, integer numMouses, integer numBirds.
     * @param numDogs
     * @param numCats
     * @param numMouses
     * @param numBirds
     */
    public Simulator(int numDogs, int numCats, int numMouses, int numBirds){
        newAnimal("Dog",numDogs);
        newAnimal("Cat",numCats);
        newAnimal("Mouse",numMouses);
        newAnimal("Bird",numBirds);
        
        for(int i = 1; i <= 5; i++){
            optionsForRandom.add(i);
        }
        
        for(int i = 1; i <= 4; i++){
            optionsForBirth.add(i);
        }
    }
    
    /**
     * Method that creates animals in the simulator.
     * @param animalType
     * @param amount
     */
    public void newAnimal(String animalType,int amount){
        if(animalType.equals("Dog")){
            for(int i = 0; i < amount; i++){ 
                gender = rand.nextInt(2) + 1;
                Dog dog = new Dog(gender);
                dogList.add(dog);
            }
        }
        if(animalType.equals("Cat")){
            for(int i = 0; i < amount; i++){
                gender = rand.nextInt(2) + 1;
                Cat cat = new Cat(gender);
                catList.add(cat);
            }
        }
        if(animalType.equals("Mouse")){
            for(int i = 0; i < amount; i++){
                gender = rand.nextInt(2) + 1;
                Mouse mouse = new Mouse(gender);
                mouseList.add(mouse);
            }
        }
        if(animalType.equals("Bird")){
            for(int i = 0; i < amount; i++){
                gender = rand.nextInt(2) + 1;
                Bird bird = new Bird(gender);
                birdList.add(bird);
            }
        }
    }
    
    /**
     * Method that returns a String with the information.
     * @return info
     */
    public String showInfo(){
        String msg;
        msg = "+------------------------------+\n";
        msg += " |             Animal Info              |\n";
        msg += "+------------------------------+\n";
        for(Dog a: dogList){
            msg += "    Specie: " + a.animalType() + "\n";
            msg += "    Name: " + a.getName() + "\n";
            msg += "    Mom: " + a.mom + "\n";
            msg += "    Dad: " + a.dad + "\n";
            msg += "    Is alive: " + a.isAlive + "\n";
            msg += "    Is sleeping: " + a.isSleeping + "\n";
            msg += "    Energy: " + a.currentEnergy + "\n";
            msg += "    Max Energy: " + a.maxEnergy + "\n";
            msg += "+------------------------------+\n";
        }
        for(Cat a: catList){
            msg += "    Specie: " + a.animalType() + "\n";
            msg += "    Name: " + a.getName() + "\n";
            msg += "    Mom: " + a.mom + "\n";
            msg += "    Dad: " + a.dad + "\n";
            msg += "    Is alive: " + a.isAlive + "\n";
            msg += "    Is sleeping: " + a.isSleeping + "\n";
            msg += "    Energy: " + a.currentEnergy + "\n";
            msg += "    Max Energy: "  + a.maxEnergy + "\n";
            msg += "+------------------------------+\n";
        }
	for(Mouse a: mouseList){
            msg += "    Specie: " + a.animalType() + "\n";
            msg += "    Is alive: " + a.isAlive + "\n";
            msg += "    Is sleeping: " + a.isSleeping + "\n";
            msg += "    Energy: " + a.currentEnergy + "\n";
            msg += "    Max Energy: " + a.maxEnergy + "\n";
            msg += "+------------------------------+\n";
        }
        for(Bird a: birdList){
            msg += "    Specie: " + a.animalType();
            msg += "    Is alive: " + a.isAlive + "\n";
            msg += "    Is sleeping: " + a.isSleeping + "\n";
            msg += "    Energy: " + a.currentEnergy + "\n";
            msg += "    Max Energy: " + a.maxEnergy + "\n";
            msg += "+------------------------------+\n";
        }
        return msg;
    }
    
    /**
     * Method that receives as parameter a String animalType and returns the number of alive animals of a specie.
     * @param animalType
     * @return alive animals
     */
    public int aliveAnimals(String animalType){
        int dogsAlive = 0;
        int catsAlive = 0;
        int miceAlive = 0;
        int birdsAlive = 0;
        if(animalType.equals("Dog")){
            for(Dog a: dogList){
                if(a.isAlive == true){
                    dogsAlive++; 
                }
            }
            return dogsAlive;
        }
        if(animalType.equals("Cat")){
            for(Cat a: catList){
                if(a.isAlive == true){
                    catsAlive++; 
                }
            }
            return catsAlive;
        }
        if(animalType.equals("Mouse")){
            for(Mouse a: mouseList){
                if(a.isAlive == true){
                    miceAlive++; 
                }
            }
            return miceAlive;
        }
        if(animalType.equals("Bird")){
            for(Bird a: birdList){
                if(a.isAlive == true){
                    birdsAlive++; 
                }
            }
            return birdsAlive;
        }
        return 0;
    }
    
    /**
     * Method that returns a string with the statistics.
     * @return statistics
     */
    public String showStats(){
        int dogsAlive = aliveAnimals("Dog");
        int catsAlive = aliveAnimals("Cat");
        int miceAlive = aliveAnimals("Mouse");
        int birdsAlive = aliveAnimals("Bird");
        String str;

        str = "+------------------------------+\n";
        str += " |               Statistics                |\n";
        str += "+------------------------------+\n";
        str += "    Dogs Alive: " + dogsAlive + "\n";
        str += "    Dogs Dead: " + (dogList.size() - dogsAlive) + "\n";
        str += "+------------------------------+\n";
        str += "    Cats Alive: " + catsAlive + "\n";
        str += "    Cats Dead: " + (catList.size() - catsAlive) + "\n";
        str += "+------------------------------+\n";
        str += "    Mouses Alive: " + miceAlive + "\n";
        str += "    Mouses Dead: " + (mouseList.size() - miceAlive) + "\n";
        str += "+------------------------------+\n";
        str += "    Birds Alive: " + birdsAlive + "\n";
        str += "    Birds Dead: " + (birdList.size() - birdsAlive) + "\n";
        str += "+------------------------------+\n";
        return str;
    }
      
    /**
     * Method that runs a random event in the simulator and returns a string with the action that happened.
     * @return action
     */
    public String randomEvent(){
        LinkedList<Dog> dogsAvailable = new LinkedList<> ();
        LinkedList<Cat> catsAvailable = new LinkedList<> ();
        LinkedList<Mouse> miceAvailable = new LinkedList<> ();
        LinkedList<Bird> birdsAvailable = new LinkedList<> ();
        int attacker;
        int defender;
        String msg = "";
        
        switch(optionsForRandom.get(rand.nextInt(optionsForRandom.size()))){
            case 1: 
                for(Dog dog : dogList){
                    if(dog.isAlive == true && dog.isSleeping == false)
                        dogsAvailable.add(dog);
                }
                for(Cat cat : catList){
                    if(cat.isAlive == true)
                        catsAvailable.add(cat);
                }
                
                if(dogsAvailable.size() > 0 && catsAvailable.size() > 0){
                    attacker = rand.nextInt(dogsAvailable.size());
                    defender = rand.nextInt(catsAvailable.size());
                    msg = dogsAvailable.get(attacker).attack(catsAvailable.get(defender));
                }else{
                    dogsAvailable.clear();
                    for(Dog dog : dogList){
                        if(dog.isAlive == true)
                            dogsAvailable.add(dog);
                        if(dogsAvailable.isEmpty() || catsAvailable.isEmpty())
                            optionsForRandom.remove(new Integer(1));
                    }
                }
                break;
            case 2: 
                for(Dog dog : dogList){
                    if(dog.isAlive == true && dog.isSleeping == false)
                        dogsAvailable.add(dog);
                }
                for(Mouse mouse : mouseList){
                    if(mouse.isAlive == true)
                        miceAvailable.add(mouse);
                } 
                if(dogsAvailable.size() > 0 && miceAvailable.size() > 0){
                    attacker = rand.nextInt(dogsAvailable.size());
                    defender = rand.nextInt(miceAvailable.size());
                    msg = dogsAvailable.get(attacker).hunt(miceAvailable.get(defender));
                }else{
                    dogsAvailable.clear();
                    for(Dog dog : dogList){
                        if(dog.isAlive == true)
                            dogsAvailable.add(dog);
                        if(dogsAvailable.isEmpty() || miceAvailable.isEmpty())
                            optionsForRandom.remove(new Integer(2));
                    }
                }
                break;
            case 3: 
                for(Cat cat : catList){
                    if(cat.isAlive == true && cat.isSleeping == false)
                        catsAvailable.add(cat);
                }
                for(Mouse mouse : mouseList){
                    if(mouse.isAlive == true)
                        miceAvailable.add(mouse);
                } 
                if(catsAvailable.size() > 0 && miceAvailable.size() > 0){
                    attacker = rand.nextInt(catsAvailable.size());
                    defender = rand.nextInt(miceAvailable.size());
                    msg = catsAvailable.get(attacker).hunt(miceAvailable.get(defender));
                }else{
                    catsAvailable.clear();
                    for(Cat cat : catList){
                        if(cat.isAlive == true)
                            catsAvailable.add(cat);
                        if(catsAvailable.isEmpty() || miceAvailable.isEmpty())
                            optionsForRandom.remove(new Integer(3));
                    }
                }
                break;
            case 4: 
                for(Cat cat : catList){
                    if(cat.isAlive == true && cat.isSleeping == false)
                        catsAvailable.add(cat);
                }
                for(Bird bird : birdList){
                    if(bird.isAlive == true)
                        birdsAvailable.add(bird);
                } 
                if(catsAvailable.size() > 0 && birdsAvailable.size() > 0){
                    attacker = rand.nextInt(catsAvailable.size());
                    defender = rand.nextInt(birdsAvailable.size());
                    msg = catsAvailable.get(attacker).hunt(birdsAvailable.get(defender));
                }else{
                    catsAvailable.clear();
                    for(Cat cat : catList){
                        if(cat.isAlive == true)
                            catsAvailable.add(cat);
                        if(catsAvailable.isEmpty() || birdsAvailable.isEmpty())
                            optionsForRandom.remove(new Integer(4));
                    }
                }
                break;
            case 5: 
                if(optionsForRandom.isEmpty() == false)
                    msg = newBorn();
                break;
            default:
                break;
        }

        return msg;
    }
    /**
     * Method that gives birth to a dog and returns a string with the action that happened.
     * @return action
     */
    public String dogBirth(Dog dad,Dog mom){
        int size;
        if(dad.gender != mom.gender){
            size = dogList.size();
            gender = rand.nextInt(2) + 1;
            Dog dog = new Dog(gender);
            dogList.add(dog);
            dogList.get(size).mom = mom.getName();
            dogList.get(size).dad = dad.getName();
            if(gender == 1)
                return "The dogs " + dad.getName() + " and " + mom.getName() + " had a baby boy and the farm owners named him " + dogList.get(size).getName() + "\n";
            else
                return "The dogs " + dad.getName() + " and " + mom.getName() + " had a baby girl and the farm owners named her " + dogList.get(size).getName() + "\n";
        }
        return "";
    }
    
    /**
     * Method that gives birth to a cat and returns a string with the action that happened.
     * @return action
     */
    public String catBirth(Cat dad,Cat mom){
        int size;
        if(dad.gender != mom.gender){
            size = catList.size();
            gender = rand.nextInt(2) + 1;
            Cat cat = new Cat(gender);
            catList.add(cat);
            catList.get(size).mom = mom.getName();
            catList.get(size).dad = dad.getName();
            if(gender == 1)
                return "The cats " + dad.name + " and " + mom.name + " had a baby boy and the farm owners named him " + catList.get(size).name + "\n";
            else
                return "The cats " + dad.name + " and " + mom.name + " had a baby girl and the farm owners named her " + catList.get(size).name + "\n";
        }
        return "";
    }
    
    /**
     * Method that gives birth to a mouse and returns a string with the action that happened.
     * @return action
     */
    public String mouseBirth(Mouse dad,Mouse mom){
        if(dad.gender != mom.gender){
            gender = rand.nextInt(2) + 1;
            Mouse mouse = new Mouse(gender);
            mouseList.add(mouse);
            return "A mouse couple had a baby, so the number of mice in the farm increased!\n";
        }
        return "";
    }
    
    /**
     * Method that gives birth to a bird and returns a string with the action that happened.
     * @param dad
     * @param mom
     * @return action
     */
    public String birdBirth(Bird dad,Bird mom){
        if(dad.gender != mom.gender){
            gender = rand.nextInt(2) + 1;
            Bird bird = new Bird(gender);
            birdList.add(bird);
            return "A bird couple had a baby, so the number of birds in the farm area increased!\n";
        }
        return "";
    }
    
    /**
     * Method that is responsible for randomly choosing who will be the next animals breeding and returns a string with the action that happened.
     * @return action
     */
    public String newBorn(){
        String msg = "";
        if(optionsForBirth.isEmpty() == false){
            switch(optionsForBirth.get(rand.nextInt(optionsForBirth.size()))){
                case 1:
                    LinkedList<Dog> maleDog = new LinkedList<> ();
                    LinkedList<Dog> femaleDog = new LinkedList<> ();
                    for(Dog a : dogList){
                        if(a.gender == 1 && a.isAlive == true)
                            maleDog.add(a);
                        if(a.gender == 2 && a.isAlive == true)
                            femaleDog.add(a);
                    }
                    if(maleDog.size() > 0 && femaleDog.size() > 0)
                        msg = dogBirth(maleDog.get(rand.nextInt(maleDog.size())), femaleDog.get(rand.nextInt(femaleDog.size())));
                    else
                        optionsForBirth.remove(new Integer(1));
                    break;
                case 2:
                    LinkedList<Cat> maleCat = new LinkedList<> ();
                    LinkedList<Cat> femaleCat = new LinkedList<> ();
                    for(Cat a : catList){
                        if(a.gender == 1 && a.isAlive == true)
                            maleCat.add(a);
                        if(a.gender == 2 && a.isAlive == true)
                            femaleCat.add(a);
                    }
                    if(maleCat.size() > 0 && femaleCat.size() > 0)
                        msg = catBirth(maleCat.get(rand.nextInt(maleCat.size())), femaleCat.get(rand.nextInt(femaleCat.size())));
                    else
                        optionsForBirth.remove(new Integer(2));
                    break;
                case 3:
                    LinkedList<Mouse> maleMouse = new LinkedList<> ();
                    LinkedList<Mouse> femaleMouse = new LinkedList<> ();
                    for(Mouse a : mouseList){
                        if(a.gender == 1 && a.isAlive == true)
                            maleMouse.add(a);
                        if(a.gender == 2 && a.isAlive == true)
                            femaleMouse.add(a);
                    }
                    if(maleMouse.size() > 0 && femaleMouse.size() > 0)
                        msg = mouseBirth(maleMouse.get(rand.nextInt(maleMouse.size())), femaleMouse.get(rand.nextInt(femaleMouse.size())));
                    else
                        optionsForBirth.remove(new Integer(3));
                    break;
                case 4:
                    LinkedList<Bird> maleBird = new LinkedList<> ();
                    LinkedList<Bird> femaleBird = new LinkedList<> ();
                    for(Bird a : birdList){
                        if(a.gender == 1 && a.isAlive == true)
                            maleBird.add(a);
                        if(a.gender == 2 && a.isAlive == true)
                            femaleBird.add(a);
                    }
                    if(maleBird.size() > 0 && femaleBird.size() > 0)
                        msg = birdBirth(maleBird.get(rand.nextInt(maleBird.size())), femaleBird.get(rand.nextInt(femaleBird.size())));
                    else
                        optionsForBirth.remove(new Integer(4));
                    break;
                default: break;
            }
        }
        return msg;
    }
}
