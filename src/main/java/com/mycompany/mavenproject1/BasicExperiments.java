/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import com.mycompany.mavenproject1.domain.Laboratory;

/**
 *
 * @author johan
 */
public final class BasicExperiments {
    
    
    
    public static void experiment_read_file_into_object(){ //The first few experiments do not use type specification because generics were added to the class Container at a later date.
        
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
    
    public static void experiment_generics_and_interfaces() {
        Container<String> jokes;
        jokes = new Container<>("Jokes",10);
        Stack stack = jokes;
        //stack.store("test"); //This doesn't work because an interface variable can only use the methods specified in the interface.
        //Container<String> items = stack; //This doesn't work because an interface can't be case to an object
        jokes.store("Best Gorilla joke of 1897");
        stack.push("But doctor, I am Pagliacci");
        
        
        pop_and_print(stack);
        pop_and_print(jokes);

    }
    private static void pop_and_print(Stack stack){
        System.out.println(stack.pop());
    }

    public static void experiment_streams_one() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Test");
        list.add("Other test");
        list.add("Final final test");
        var listLengths = list.stream().mapToInt(s -> s.length());
        System.out.println(listLengths.summaryStatistics());
//        System.out.println("Average string length: "+listLengths.average());
//        System.out.println("Total list length: "+ listLengths.sum());
        //Apparently each step in the stream can only be operated upon once, and trying to do two things with the same intermediary product
        // produces an error.
        
        
    }

    public static void experiment_comparable_containers() {
        Container<String> c1 = new Container<>("container 1",5);
        Container<String> c2 = new Container<>("Container 2",5);
        c1.push("Item 1"); c1.push("Item 2"); c2.push("Item 2-1");

        System.out.println(c1.compareTo(c2));


    }

    public static void experiment_stream_lambda_sorting(){
        var c1 = new Container<String>("Blackbeard", 10);
        c1.push("Gold");
        c1.push("Treasure Map");
        var c2 = new Container<String>("Bartholomew Roberts",5);
        c2.push("Saffron");
        var c3 = new Container<String>("Francis Drake", 5);
        c3.push("Exotic tea");

        ArrayList<Container<String>> arrr = new ArrayList<>();
        arrr.add(c2);
        arrr.add(c1); //Putting one of the smaller sized containers before and after, so sorting has an effect regardless of ascending or descending order.
        arrr.add(c3);
        arrr.stream().forEach(a -> System.out.println(a.label));
        Collections.sort(arrr,(a, b)-> a.compareTo(b));
        System.out.println("");
        arrr.stream().forEach(a -> System.out.println(a.label));

    }

    public static void experiment_enum() {
        RiskLevel sl = RiskLevel.valueOf("HIGH"); //Needs to be the exact same. Capitalization is important!
        System.out.println(sl);
        System.out.println(sl.ordinal());
        System.out.println(sl.higherRiskLevel());


    }

    public static void experiment_iterator() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Word 1");
        list.add("Word 2");
        list.add("error");
        list.add("Word 4");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }
        iterator = list.iterator();

        while (iterator.hasNext()) {
            if (iterator.next()== "error") {
                // removing from the list the element returned by the previous next-method call
                iterator.remove();
            }
        }
        System.out.println(list);




    }

    private static void remove_errors(Iterator iterator,String s) {
        if (s == "error") {
            iterator.remove();
        }

    }

    public static void experiment_imported_package() {
        Laboratory.develop("Boots");
    }

    public static void experiment_exceptions(){


        try (Scanner scanner = new Scanner(Paths.get("file.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        try (Scanner scanner = new Scanner(Paths.get("fakefile.txt"))) {
            System.out.printf(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Error because of non-existent file: " + e + " | "+ e.getMessage());
            e.printStackTrace();
        }
        try {
            arewecoolyet(); //Having "throws exception in the method signature means the user will be forced to handle that exception!"
        } catch (Exception e){
            System.out.println("You shouldn't be here.");
        }
    }

    private static void arewecoolyet() throws Exception{
        System.out.println("Are we cool yet?");
    }


    public static void experiment_make_file(){
        try {

            //Path path = Files.createFile(Path.of("newFile.txt"));
            FileWriter writer = new FileWriter("newFile2.txt");
            writer.write("This is a test line.");
            writer.close();

        } catch (Exception e) {
            System.out.println("Oops: "+e);
        }
    }









}
