/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

/**
 *
 * @author johan
 */
public final class BasicExperiments {
    
    
    
    public static void experiment_read_file_into_object(){
        
        Container container = new Container("test",5);
        
        try(Scanner scanner = new Scanner(Paths.get("file.txt"));) {
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (container.space_left()) {
                    container.store(line);
                    
                } else {
                    System.out.println("Container is full!");
                    break;
                }
                
            }
            ArrayList<String> contents = container.contents();
            for (String line: contents) {
                System.out.println(line);
            }

            
        } catch (Exception e){
            System.out.println("Error:"+e.getMessage());
        }
        
    }
    
    public static void experiment_assigning_references(){ 
        Container container = new Container("referenced",10);
        container.store("package 1 - stored with original reference");
        Container otherContainer = container;
        System.out.println(otherContainer.contents());
        modify_in_method(container);
        System.out.println(container.contents());
        
    } //Result: Both actions performed on 'copies' and inside methods equally apply to the original object.
    private static void modify_in_method(Container container){
        container.store("package 2 - stored in method");
    }
    
    public static void experiment_hashmaps() {
        HashMap<String, String> numbers = new HashMap<>();
        numbers.put("One", "Uno");
        numbers.put("Two", "Dos");
    
        var one = numbers.get("One");
        System.out.println(one);
        
        var none = numbers.get("three");
        System.out.println(none);
        if (none == null) {
            System.out.println("none == null");
        }       
    }
    
    public static void experiment_custom_equals(){
        var c1 = new Container("c1",5);
        var c2 = new Container("c2",10);
        var c3 = c1;
        var c4 = new Container("c1",5);
        c1.store("test");
        c4.store("test");
        
        System.out.println("container 1 equals container 2: "+(c1.equals(c2))); //Always false
        System.out.println("container 1 equals container 3: "+(c1.equals(c3))); //True by virtue of being references to same thing.
        System.out.println("container 1 equals container 4: "+(c1.equals(c4))); //True only if equals method was overwritten.
        c4.store("test2");
        System.out.println("container 1 still equals container 4: "+(c1.equals(c4))); //False because the contents changed.       
    }
    
    public static void experiment_custom_hashcodes() {
        var c1 = new Container("c1",5);
        var c2 = new Container("c2",10);
        var c4 = new Container("c1",10);
        var c5 = new Container("c1",5);
        
        System.out.println("Container 1 has the same hashcode as container 2: " + (c1.hashCode()==c2.hashCode()));
        System.out.println("Container 1 has the same hashcode as container 4: " + (c1.hashCode()==c4.hashCode())); //True because custom hashcode is based on label.
        System.out.println("--------------------------------------");
        HashMap<Container,String> map = new HashMap<>();
        map.put(c1, "Container 1");
        System.out.println("c1 in hashmap: "+ map.get(c1));
        map.put(c2, "Container 2");
        System.out.println("c2 in hashmap: "+ map.get(c2));
        map.put(c4,"Container 4");
        System.out.println("c4 in hashmap:" + map.get(c4));
        System.out.println("c1 in hashmap:" + map.get(c1));
        System.out.println("=>c1 was not overwritten, because the hashmap uses both hashcode AND .equal to determine equality, and the second container here had a different size");
        map.put(c5,"Container 5");
        System.out.println("c4 in hashmap:" + map.get(c5));
        System.out.println("c1 in hashmap:" + map.get(c1));
        System.out.println("=>This time c1 is overwritten, because both lable and size are the same. ");

        
        
        
                
    }
    
}
