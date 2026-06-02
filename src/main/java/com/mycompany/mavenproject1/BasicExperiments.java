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
}
