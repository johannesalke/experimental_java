/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author johan
 */
public final class BasicExperiments {
    
    
    
    public static void read_files_into_object(){
        
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
    
    public static void assigning_references(){ 
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
    
    
}
